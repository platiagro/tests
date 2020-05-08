#language:pt

Funcionalidade: Criar Experimento na PlatIAgro
Como usuário da plataforma, desejo criar um novo Experimento.


# Data: 07/05/2020
# Execução dos cenários realizado manualmente e automaticamente

Contexto: Acessar Plataforma
Dado que o usuário acessa a plataforma PlatIAgro
E é apresentado a página inicial da plataforma
Então o usuário irá selecionar a aba Projetos do Menu


@CRUDPROJ
Cenário: C01 - Criar Experimento
Dado que o usuário está na página Projetos da plataforma
E selecionar um Projeto da lista de projetos
Quando for direcionado para a página de experimentos do projeto selecionado
E selecionar o botão Adicionar, indicado com o sinal +
E será aberto um modal onde o usuário irá nomear o experimento como: '<Experimento1>'
Quando selecionar o botão Criar 
E a criação do experimento for executada
Então será adcionada a tarefa Conjunto de Dados ao fluxo
E o usuário estará habilitado para iniciar a montagem


@CRUDPROJ
Cenário: C02 - Alterar nome do Experimento
Dado que o usuário está na página Projetos da plataforma
E selecionar um Projeto da lista de projetos
Quando for direcionado para a página de experimentos do projeto selecionado
E selecionar o botão Editar - íncone Lápis ao lado do nome do Experimento
E renomear para:'Teste Experimento2'
Então o nome do experimento será atualizado


@CRUDPROJ
Cenário: C03 - Excluir Experimento
Dado que o usuário está na página Projetos da plataforma
E selecionar um Projeto da lista de projetos
Quando for direcionado para a página de experimentos do projeto selecionado
E selecionar o experimento que deseja excluir
E clicar no botão Excluir
E o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Experimento?"
E o usuário confirmar a operação clicando no botão Sim
Então o experimento será excluído


@CRUDPROJ
Cenário: C04 - Montar e Executar Experimento
Dado que o usuário está na página Projetos da plataforma
E selecionar um Projeto da lista de projetos
Quando for direcionado para a página de experimentos do projeto selecionado
E selecionar a tarefa: 'AutoML Classifier'
E essa tarefa for adicionada ao fluxo
E o usuário selecionar a tarefa Conjunto de Dados 
Então será aberto um modal
E o usuário irá selecionar um arquivo CSV
E um arquivo TXT
Quando selecionar o botão Importar
E informar qual seu atributo alvo
E voltar ao fluxo
E selecionar o botão Executar
Então a tarefa será executada com sucesso

@CRUDPROJ
Cenário: C05 - Salvar Template
Dado que o usuário está na página Projetos da plataforma
E selecionar um Projeto da lista de projetos
Quando for direcionado para a página de experimentos do projeto selecionado
E selecionar o botão Adicionar, indicado com o sinal +
E será aberto um modal onde o usuário irá nomear o experimento como: '<Experimento3>'
Quando selecionar o botão Criar 
E a criação do experimento for executada
Então será adcionada a tarefa Conjunto de Dados ao fluxo

Quando o usuário selecionar a tarefa:'MLP Classifier'
E essa tarefa for adicionada ao fluxo
E o usuário selecionar o botão Salvar Template
E nomear o Template como: 'template teste1'
E confirmar a operação
Então o template será salvo 
E será adicionado na lista de templates da página experimentos do projeto
 