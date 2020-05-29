#language:pt

Funcionalidade: Criar Experimento na PlatIAgro
Como usuário da plataforma, desejo criar um novo Experimento.


# Data: 07/05/2020
# Execução dos cenários realizado manualmente e automaticamente


Contexto: Acessar Plataforma
Dado que o usuário acessa a plataforma PlatIAgro
E está na tela de longin
Quando inserir o usuário:'user'
E inserir a senha:'000000'
E confirmar
Então será apresentado a página inicial da plataforma


@CRUDPROJ
Cenário: C01 - Criar e Executar Experimento
Dado que o usuário está na página Meus Projetos
Quando selecionar o botão Novo Projeto
E nomear o projeto com: 'ProjetoTeste'
E deixar a descrição em branco 
E selecionar o botão Criar projeto  
Então o projeto será criado
E o usuário irá selecionar o botão Novo Fluxo
E irá escolher a opção Experimentação para iniciar um experimento

Quando o usuário estiver na tela de Experimentação
E selecionar o menu Conjunto de Dados
E selecionar a tarefa Arquivo.csv, que será adicionada ao fluxo
Então o usuário irá importar os dados de entrada do arquivo

Quando selecionar o botão Visualizar Dados
E a tela de visualização de dados for aberta
E importar um arquivo TXT
E selecionar um atributo alvo
Então o usuário irá voltar ao fluxo

Quando selecionar o Menu Engenharia de atributos
E selecionar a tarefa Imputer, que será adicionada ao fluxo
E adicionar a tarefa: 'AutoML Classifier' localizada no menu Treinamento
E ligar as tarefas 
E selecionar o botão Executar
E a operação será concluída com sucesso
Então o usuário irá selecionar as tarefas 
E visualizar o resultado da execução


@CRUDPROJ
Cenário: C02 - Executar Experimento com erro
Dado que o usuário está na página Meus Projetos
Quando selecionar o botão Novo Projeto
E nomear o projeto com: 'ProjetoTeste'
E deixar a descrição em branco 
E selecionar o botão Criar projeto  
Então o projeto será criado
E o usuário irá selecionar o botão Novo Fluxo
E irá escolher a opção Experimentação para iniciar um experimento

Quando o usuário estiver na tela de Experimentação
E selecionar o menu Conjunto de Dados
E selecionar a tarefa Arquivo.csv, que será adicionada ao fluxo
E não importar um arquivo com dados de entrada
E adicionar a tarefa Imputer ao fluxo
E adicionar a tarefa: 'AutoML Classifier' 
Quando ligar as tarefas 
E selecionar o botão Executar
Então a operação não será executada
E o sistema exibira uma mensagem de erro
E a tarefa com erro de execução estará destacada em vermelho
Quando o usuário selecionar a tarefa o motivo do erro deverá ser exibido no campo Erro na execução 


@CRUDPROJ
Cenário: C03 - Salvar Template
Dado que o usuário está na página Meus Projetos
Quando selecionar o botão Novo Projeto
E nomear o projeto com: 'ProjetoTeste'
E deixar a descrição em branco 
E selecionar o botão Criar projeto  
Então o projeto será criado
E o usuário irá selecionar o botão Novo Fluxo
E irá escolher a opção Experimentação para iniciar um experimento

Quando o usuário estiver na tela de Experimentação
E selecionar o menu Conjunto de Dados
E selecionar a tarefa Arquivo.csv, que será adicionada ao fluxo
Então o usuário irá importar os dados de entrada do arquivo

Quando selecionar o botão Visualizar Dados
E a tela de visualização de dados for aberta
E importar um arquivo TXT
E selecionar um atributo alvo
Então o usuário irá voltar ao fluxo

Quando selecionar o Menu Engenharia de atributos
E selecionar a tarefa Imputer, que será adicionada ao fluxo
E adicionar a tarefa: 'AutoML Classifier' localizada no menu Treinamento
E ligar as tarefas 
E selecionar o botão Executar
E a operação será concluída com sucesso
Então o usuário irá selecionar as tarefas 
E visualizar o resultado da execução

Quando o usuário selecionar o botão Salvar Template
E nomear o Template como: 'template teste1'
E confirmar a operação
Então o template será salvo 
E será adicionado ao menu Template de Fluxos 
 

@CRUDPROJ
Cenário: C04 - Excluir Experimento
Dado que o usuário está na página Meus Projetos
E selecionar um Projeto da lista de projetos
Quando for direcionado para a página de experimentos do projeto selecionado
E selecionar o experimento que deseja excluir
E clicar no botão Excluir
E o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Experimento?"
E o usuário confirmar a operação clicando no botão Sim
Então o experimento será excluído

 