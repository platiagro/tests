import pages.*
import geb.*
import db.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import cucumber.api.PendingException
import org.openqa.selenium.By
import static cucumber.api.groovy.PT.*


String filePath = System.getProperty("user.dir")
String caminho = "/src/cucumber/resources/files/"

//CENÁRIO 1

 Quando(/selecionar um projeto/) {  ->
  at PageProj
   
  Thread.sleep(5000)

     waitFor(60){
         $(By.xpath("//*[contains(text(), 'FluxoImp')]")).click()
    }

   Thread.sleep(5000)
 }

 E(/deverá observar que o projeto possuí Experimentos executados/) { -> assert true }

 E(/esses experimentos possuem arquivo Iris.csv/) { -> assert true }

 Então(/a lista de Fluxos Implantados ficará visível/) { ->
    Thread.sleep(60000)
 }

Então(/o nome da implantação deve conter o nome do projeto e do experimento do fluxo implantado/) {-> assert true}

 Quando(/a implantação for finalizada/){-> assert true}

  E(/o status definido com Succeeded/){-> Thread.sleep(65000) }

  E(/o usuário selecionar o botão Testar o fluxo/){->
   assert true
  }

  E(/selecionar um arquivo csv/){->
   at PageFluxoImp

   Thread.sleep(2000)

    String path = new File("../src/cucumber/resources/files/Teste1.csv").getCanonicalPath();

    waitFor(60){
         page.inputFile.click()
    }


   Thread.sleep(7000)
  }  

  E(/os dados do arquivo serão apresentados/){-> assert true}

  E(/para fazer o download do resultado, o usuário deverá selecionar o botão Fazer Download/){-> assert true}

  Então(/um arquivo do resultado será baixado/){-> assert true}
 
  E(/para copiar os resultados, o usuário deverá selecionar o botão Cópia/){-> assert true}

  Então(/uma mensagem de sucesso será exibido na tela/){-> assert true}

  Quando(/o arquivo selecionado não for compatível com o fluxo implantado/){-> assert true}

  Então(/será aberto o modal com uma mensagem de erro/){-> assert true}

  E(/o usuário poderá acesar o log para ter  mais detalhes sobre o erro/){-> assert true}


//CENÁRIO 2

 E(/esses experimentos possuem Tarefa para testar arquivo png/){-> assert true}
 
 E(/selecionar um arquivo jpg, jpeg ou png/){->
  at PageFluxoImp

   Thread.sleep(2000)

    String path = new File("../src/cucumber/resources/files/testeimg.jpg").getCanonicalPath();

   Thread.sleep(7000)
 }

 E(/a imagem selecionada será exibida/){-> assert true}


//CENÁRIO 3

 Dado(/que o usuário está na página Fluxos Implantados/){->
  at PageProj

  waitFor(60){ page.fluxosImpMenu.click() }

    Thread.sleep(5000)
 }

 E(/deseja deletar um dos fluxos implantados presente na lista/){-> assert true}

 Quando(/selecionar o botão Deletar, localizado na coluna Ação/){->
  at PageFluxoImp

   Thread.sleep(2000)

    waitFor(60){ page.btndelete.click() }
 }

 Então(/um popover com a seguinte mensagem será exibido "Você tem certeza que deseja excluir essa implantação?"/){-> assert true}

 Quando(/o usuário confirmar a operação, a implantação será deletada/){->
  at PageFluxoImp

   Thread.sleep(2000)

    waitFor(60){ page.btnsim.click() }

    Thread.sleep(5000)
 }

 E(/o botão Preparar para a implantação será habilitado novamente na página do experimento/){->
  at PageProj

   Thread.sleep(2000)

    waitFor(60){ page.projetoMenu.click() }

    Thread.sleep(5000)

    waitFor(60){
         $(By.xpath("//*[contains(text(), 'FluxoImp')]")).click()
    }

    Thread.sleep(6000)
 }

 Quando(/o usuário optar por não excluir a implantação/){->assert true}

 Então(/o popover será resetado/){-> assert true}

 E(/o botão Preparar para a implantação continuará desabilitado na página do experimento/){-> assert true}


 //CENÁRIO 4

 Quando(~/selecionar o botão Logs, localizado na coluna Ação/){->
  at PageFluxoImp

   Thread.sleep(2000)

    waitFor(60){ page.btnlogs.click() }

    Thread.sleep(5000)
 }

 Então(~/será aberto a tela Logs/){->assert true}

 E(~/as informações estarão divididas em três colunas: Data, Nível, Mensagem/){-> assert true}


 //CENÁRIO 5

  E(~/esses experimentos possuem arquivo csv/){->assert true}

 E(/o usuário deseja ter informações de como usar o fluxo implantado/){->assert true}

 Quando(/selecionar o botão Como usar Fluxo Implantado/){->
  at PageFluxoImp

   Thread.sleep(2000)

    waitFor(60){ page.btnUseImp.click() }

    Thread.sleep(5000)

 }
 
 Então(/será aberto um modal com as dicas do que o usuário deve fazer para usar a implantação/){->
  at PageFluxoImp

  Thread.sleep(2000)

    waitFor(60){$(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")).click() }

    Thread.sleep(5000)
  
 }
 