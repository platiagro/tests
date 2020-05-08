#language:pt

Funcionalidade: Criar Projeto na PlatIAgro
Como usuário da plataforma, desejo criar um novo Projeto para iniciar um experimento.


# Data: 07/05/2020
# Execução dos cenários realizado manualmente e automaticamente

Contexto: Acessar Plataforma
Dado que o usuário acessa a plataforma PlatIAgro
E é apresentado a página inicial da plataforma
Então o usuário irá selecionar a aba Projetos do Menu


@CRUDPROJ
Cenário: C01 - Lista de Projetos
Dado que o usuário acessa a tela inicial da plataforma
E selecionar a aba Projetos do Menu
Quando o sistema direcionar o usuário para a página de Projetos
Então deverá observar que todas os projetos existentes estarão listados
E as informações dos projetos estarão divididos em três colunas: Nome do Projeto, Data de Criação e Ação


@CRUDPROJ
Cenário: C02 - Criar Projeto
Dado que o usuário está na página Projetos da plataforma
Quando selecionar o botão Novo Projeto
E o sistema abrir um modal para o usuário informar o nome do projeto com:'Teste Projeto1'
E selecionar o botão Criar
Então o projeto será criado 
E o usuário será direcionado para a página de experimentos do projeto


@CRUDPROJ
Cenário: C03 - Alterar nome do Projeto
Dado que o usuário está na página de Experimentos do Projetos
Quando selecionar o botão Editar - íncone Lápis ao lado do nome do projeto
E renomear o projeto com:'Teste Projeto2'
Então o nome do projeto será atualizado


@CRUDPROJ
Cenário: C04 - Excluir Projeto
Dado que o usuário está na página Projetos da plataforma
Quando selecionar um projeto na lista de Projetos
E clicar no botão Excluir
E o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Projeto?"
E o usuário confirmar a operação clicando no botão Sim
Então o projeto será excluido da lista de Projetos




