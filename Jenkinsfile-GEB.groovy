/* Definição de classes importadas */
import groovy.transform.Field
import static groovy.json.JsonOutput.*

pipeline {
    
    agent { label "jenkinsPlatIAgro" }
    
    options {
        disableConcurrentBuilds()
        timeout(time: 120, unit: 'MINUTES')
        timestamps()
        ansiColor('xterm')              
        buildDiscarder(logRotator(numToKeepStr: '150'))
    }
    // ATENCAO: É preciso executar uma primeira vez para que os parametros sejam criados para o job!! 
    parameters {
        choice(
            name: 'PROJECT',
            description: 'Nome do Projeto Bitbucket',
            choices: ['PLATIA'],
        )
        choice(
            name: 'REPOSITORY',
            description: 'Nome do repositório Git',
            choices: ['testes_automaticos'],
        )        
        string(
            name: 'BRANCH',
            description: 'Nome do branch',
            defaultValue: 'master',
            trim: true,
        )               
        string(
            name: 'GRADLE_BDD_PARAM',
            description: "Parâmetros para a chamada do 'gradle bdd'",
            defaultValue: '-Ptag=@CRUDPROJ -Penv=chromeheadless',
            trim: true,
        )               
        string(
            name: 'EMAIL',
            description: 'Email para divulgação',
            defaultValue: 'emelo@cpqd.com.br',
            trim: true,
        )       
    }
    environment {
        CREDENTIALS='ssh-password-ipadmin'      
        CRED_IPADMIN = credentials('ssh-password-ipadmin')
        
        SERVER_URL='https://artifactory.cpqd.com.br/artifactory/'
        MAVEN_SETTINGS_UNIX="${SETTINGS_CPQD}"

        GIT_URL="https://bitbucket.cpqd.com.br/scm/${env.PROJECT}/${env.REPOSITORY}.git"
    }   
    
    stages {            
        stage('Prepare') {
            steps {
                startStage ( info : BRANCH )
                
                // Lista variáveis de ambiente Jenkins
                sh "printenv | sort"
                echo "BUILD_NUMBER = ${env.BUILD_NUMBER}"
                sh 'echo BUILD_NUMBER = $BUILD_NUMBER'
                
                // Registra informações sobre a build
                script {
                    currentBuild.displayName = "${env.REPOSITORY}-${env.BRANCH}"
                    currentBuild.description = "${env.BRANCH}"                                       
                }
                script {
                    prodname_uppercase = "${env.REPOSITORY.toUpperCase()}"    
                    prodname_lowercase = "${env.REPOSITORY.toLowerCase()}"                                                    
                }                                       
            }    
        }       // stage prepare
        
        stage('Git: Checkout Code') {                  
            steps {
                startStage ( info : "${PROJECT}/${REPOSITORY}" )
                
                dir ('code') {
                    deleteDir()
                    git branch: BRANCH,
                        credentialsId: CREDENTIALS,                     
                        url: GIT_URL            
                }
                script {
                    notifyBitbucket(buildStatus: 'INPROGRESS')
                    currentBuild.description = "${env.BRANCH}"
                }

            }
        } // stage git checkout
        
        stage('GEB: Execução dos testes') {     
            steps {
                startStage ( info : "${BRANCH}" )
                envGEB {
    		    sh """
                            Xvfb :99 -screen 0 1280x1024x24 &
                            echo "gradle bdd..."
                            pwd
        		    gradle -version
                                
                            cd code/cucumber-geb
                            gradle bdd ${GRADLE_BDD_PARAM}
                        """
	        }
            }

        }
//        stage('GEB: Gerando relatorios HTML') {
//            steps {
//                script {
//                    cucumber buildStatus: 'UNSTABLE',
//                        reportTitle: 'My report',
//                        fileIncludePattern: '**/*.json',
//                        trendsLimit: 10,
//                        classifications: [
//                        [
//                            'key': 'Browser',
//                            'value': 'Firefox'
//                        ]
//                    ]
//                }
//            }
//        }
    }   // stages 
    post {
        always {
            script {
                echo 'One way or another, I have finished'
                currentBuild.result = currentBuild.result ?: 'SUCCESS'
                notifyBitbucket()
                echo "Status: ${currentBuild.result}"

                cucumber buildStatus: "${currentBuild.result}",
                    failedFeaturesNumber: 1,
                    failedScenariosNumber: 1,
                    skippedStepsNumber: 1,
                    failedStepsNumber: 1,
                    //                classifications: [
                    //                        [key: 'Commit', value: '<a href="${GERRIT_CHANGE_URL}">${GERRIT_PATCHSET_REVISION}</a>'],
                    //                        [key: 'Submitter', value: '${GERRIT_PATCHSET_UPLOADER_NAME}']
                    //                ],
                reportTitle: 'My report',
                    fileIncludePattern: '**/*cucumber.json',
                    sortingMethod: 'ALPHABETICAL',
                    trendsLimit: 100                
            }
        }
        success {
            echo 'I succeeeded!'
            script {
                mail to: EMAIL,
                    subject: "Pipeline: ${env.PROJECT} ${env.REPOSITORY} ${env.BRANCH}",
                    body: """
Success ${currentBuild.fullDisplayName} 
${env.BUILD_URL} => 
                 """
            }
        }
        unstable {
            echo 'I am unstable :/'
        }
        failure {
            echo 'I failed :('
            mail to: EMAIL,
                subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                body: "Something is wrong with ${env.BUILD_URL}"                        
        }
        changed {
            echo 'Things were different before...'
        }
    }
} // pipeline

/**
 * ==================================================================================================================================================================
 * Bibliotecas
 * ==================================================================================================================================================================
 */

/**
 * Imprime no log mensagem de início do Stage
 *
 * @param info     (String) Informações adicionais 
 */ 
def startStage (Map args) {
    println "*** ======================================================================================"
    println "*** STAGE: ${STAGE_NAME} - ${args.info}"
}

/**
 * Executa comando maven em maquina Linux
 * O settings já esta definido como argumento padrão do maven
 *
 * WARNINGS : 
 *      - Esta função deve ser executada somente dentro de um ambiente pré-definido, dentro da função : 'envLinux'
 *
 * @param args       Argumentos para o comando mvn
 * @param settings   Settings a ser utilizado para a compilação
 * @param list_poms  Lista de poms a serem compilados
 */
def mvn (args, settings, list_poms){
    list_poms.each{
        sh label: "Maven task : ${it}", script: "mvn -s ${settings} -DretryFailedDeploymentCount=5 ${args} -f ${it}"
    }
}

/**
 * Definição de ambiente Linux
 *
 * Define ambiente linux com as ferramentas :
 *  - Docker Image  : container-registry.cpqd.com.br/dockerhub/maven:3.5-jdk-8
 * 
 * A closure de parâmetro é executada dentro do container.
 *
 * WARNINGS : 
 *      - Esta função deve ser executada somente dentro de uma maquina Linux com o docker pré instalado.
 *      - Esta função deve ter sua lógica alterada dependendo do produto.
 *
 * @param cmd Closure a ser executada dentro do ambiente
 */
def envLinux (cmd){
    String dockerImage = 'artifactory.cpqd.com.br:8443/docker/cpqd/cdk-maven333-jdk8:latest'
    String dockerArgs = '''-v /home/builder/.m2:/home/builder/.m2 
            -v /home/builder/.m2/repo-m3:/home/builder/.m2/repo-m3 
            -v /home/builder:/home/builder'''

    withDockerRegistry([credentialsId: 'ssh-password-ipadmin', url: 'https://artifactory.cpqd.com.br:8443/docker']) {
        docker.image(dockerImage).inside(dockerArgs) {
            cmd()
        }
    }
}


def envGEB (cmd){
    String dockerImage = 'artifactory.cpqd.com.br:8443/docker/cpqd/geb-gradle4.0.1-jdk8:latest'
    String dockerArgs = ''' --privileged -v /home/builder/.m2:/home/builder/.m2
            -v /home/builder/.m2/repo-m3:/home/builder/.m2/repo-m3 
            -v /home/builder:/home/builder'''

    withDockerRegistry([credentialsId: 'ssh-password-ipadmin', url: 'https://artifactory.cpqd.com.br:8443/docker']) {
        docker.image(dockerImage).inside(dockerArgs) {
            cmd()
        }
    }
}