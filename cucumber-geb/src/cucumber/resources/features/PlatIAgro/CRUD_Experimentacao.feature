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
Então será apresentado a página "Meus Projetos", com a lista de projetos existentes daquele usuário


@CRUDPROJ
Cenário: C01 - Criar e Executar Experimento
Dado que o usuário está na página "Meus Projetos"
Quando clicar no botão Novo Projeto
E o sistema abrir um modal, com o nome Novo Projeto selecionado
E o usuário limpar o campo nome
E nomear o projeto com: 'TesteExp'
E informar a seguinte descrição: 'Teste - Fluxo de Experimento'
Quando clicar no botão "Criar projeto"
Então o novo projeto será criado 
E o usuário será direcionado para a página do projeto
E nessa página poderá escolher se deseja iniciar um fluxo de Experimentação ou Pré -implantação

Quando o usuário eselecionar a opção Experimentação
Então a tela de Experimentação será apresentada
E o menu "Armazém de Tarefas" estará disponível
E os botões acima da tela do fluxo de experimentação estarão desabilitados

Quando o usuário selecionar o menu Conjunto de Dados
E selecionar a tarefa Arquivo.csv, que será adicionada ao fluxo
Então o usuário irá importar os dados de entrada do arquivo

Quando selecionar o botão Visualizar Dados
E a tela de visualização de dados for aberta
E importar um arquivo TXT
E selecionar um atributo alvo
Então o usuário irá voltar ao fluxo
E os botões "Salvar Template" e "Executar" estarão habilitados

Quando selecionar o Menu Engenharia de atributos
E selecionar a tarefa Imputer, que será adicionada ao fluxo
E adicionar a tarefa: 'AutoML Classifier' localizada no menu Treinamento
E ligar as tarefas uma a uma
E selecionar o botão Executar
Então o sistema envia a seguinte mensagem: "Treinamento iniciado!"
E as tarefas são sinalizadas como "Tarefa Pendente"
E os botões "Salvar Template" e "Executar" serão desabilitados
Quando a operação for concluída com sucesso
E as tarefas serem sinalizadas como "Tarefa executada com sucesso"
Então o usuário irá selecionar as tarefas 
E visualizar o resultado da execução


@CRUDPROJ
Cenário: C02 - Executar Experimento com erro
Dado que o usuário está na página "Meus Projetos"
Quando clicar no botão Novo Projeto
E o sistema abrir um modal, com o nome Novo Projeto selecionado
E o usuário limpar o campo nome
E nomear o projeto com: 'TesteExp2'
E informar a seguinte descrição: 'Teste - Fluxo de Experimento com falha'
Quando clicar no botão "Criar projeto"
Então o novo projeto será criado 
E o usuário será direcionado para a página do projeto
E nessa página poderá escolher se deseja iniciar um fluxo de Experimentação ou Pré -implantação
Quando o usuário eselecionar a opção Experimentação
Então a tela de Experimentação será apresentada
E o menu "Armazém de Tarefas" estará disponível
E os botões acima da tela do fluxo de experimentação estarão desabilitados

Quando o usuário estiver na tela de Experimentação
E selecionar o menu Conjunto de Dados
E selecionar a tarefa Arquivo.csv, que será adicionada ao fluxo
E não importar um arquivo com dados de entrada
E adicionar a tarefa Imputer ao fluxo
E adicionar a tarefa: 'AutoML Classifier' 
Quando ligar as tarefas uma a uma 
E selecionar o botão Executar
Então o sistema envia a seguinte mensagem: "Treinamento iniciado!"
E as tarefas são sinalizadas como "Tarefa Pendente"
E os botões "Salvar Template" e "Executar" serão desabilitados
Quando a operação Executar for concluída
E a tarefa apresentar erro de execução
Então o usuário deve selecionar a tarefa
E o motivo do erro deverá ser exibido no campo Erro na execução 



@CRUDPROJ
Cenário: C03 - Criar Experimento - Nome Repetido
Dado que o usuário está na página Meus Projetos
E selecionar um dos projetos da lista de projetos
E for direcionado para página do projeto
E esse projeto já possui um fluxo de experimento nomeado como "TesteExp"
Quando o usuário clicar no botão Novo Fluxo
E selecionar a opção Experimentação
E nomear o experimento para:'TesteExp'
Então a operação deve ser cancelada
E o sistema deverá informar que já existe um experimento com o nome informado



@CRUDPROJ
Cenário: C04 - Salvar Template
Dado que o usuário está na página "Meus Projetos"
Quando clicar no botão Novo Projeto
E o sistema abrir um modal, com o nome Novo Projeto selecionado
E o usuário limpar o campo nome
E nomear o projeto com: 'TesteExp3'
E informar a seguinte descrição: 'Teste - Salvar Template'
Quando clicar no botão "Criar projeto"
Então o novo projeto será criado 
E o usuário será direcionado para a página do projeto
E nessa página poderá escolher se deseja iniciar um fluxo de Experimentação ou Pré -implantação

Quando o usuário eselecionar a opção Experimentação
Então a tela de Experimentação será apresentada
E o menu "Armazém de Tarefas" estará disponível
E os botões acima da tela do fluxo de experimentação estarão desabilitados
Quando o usuário selecionar o menu Conjunto de Dados
E selecionar a tarefa Arquivo.csv, que será adicionada ao fluxo
Então o usuário irá importar os dados de entrada do arquivo

Quando selecionar o botão Visualizar Dados
E a tela de visualização de dados for aberta
E importar um arquivo TXT
E selecionar um atributo alvo
Então o usuário irá voltar ao fluxo
E os botões "Salvar Template" e "Executar" estarão habilitados

Quando selecionar o Menu Engenharia de atributos
E selecionar a tarefa Imputer, que será adicionada ao fluxo
E adicionar a tarefa: 'Linear Regression' localizada no menu Treinamento
E ligar as tarefas uma a uma
E selecionar o botão Executar
Então o sistema envia a seguinte mensagem: "Treinamento iniciado!"
E as tarefas são sinalizadas como "Tarefa Pendente"

Quando a operação for concluída com sucesso
E as tarefas serem sinalizadas como "Tarefa executada com sucesso"
Então o usuário irá selecionar as tarefas 
E visualizar o resultado da execução
Quando o usuário selecionar o botão Salvar Template
E nomear o Template como: 'template teste1'
E confirmar a operação
Então o template será salvo 
E será adicionado ao menu Template de Fluxos 
 

@CRUDPROJ
Cenário: C05 - Excluir Experimento
Dado que o usuário está na página Meus Projetos
E selecionar um Projeto da lista de projetos
Quando for direcionado para a página de experimentos do projeto selecionado
E selecionar o experimento que deseja excluir
E clicar no botão Excluir
E o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Experimento?"
E o usuário confirmar a operação clicando no botão Sim
Então o experimento será excluído

 