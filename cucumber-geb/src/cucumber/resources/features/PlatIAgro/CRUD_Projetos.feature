#language:pt

Funcionalidade: Criar Projeto na PlatIAgro
Como usuário da plataforma, desejo criar um novo Projeto para iniciar um experimento.


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
Cenário: C01 - Lista de Projetos
Dado que o usuário está na página inicial da plataforma
Quando selecionar o menu Meus Projetos
E será apresentado uma lista com os projetos existentes
Então deverá observar que as informações dos projetos estarão divididos em cinco colunas: Nome do Projeto, Descrição, Tags, Ultima modificação e Ação


@CRUDPROJ
Cenário: C02 - Criar Projeto
Dado que o usuário está na página Meus Projetos
Quando selecionar o botão Novo Projeto
E nomear o projeto com: 'ProjetoTeste'
E deixar a descrição em branco 
E selecionar o botão Criar projeto  
Então o projeto será criado
E será adicionado a lista de projetos
E o usuário poderá escolher se deseja iniciar uma Experimentação ou uma Pré-implantação


@CRUDPROJ
Cenário: C03 - Alterar nome do Projeto
Dado que o usuário está na página Meus Projetos
Quando selecionar o botão Novo Projeto
E nomear o projeto com: 'ProjetoTeste2'
E deixar a descrição em branco 
E selecionar o botão Criar projeto  
Então o projeto será criado
E será adicionado a lista de projetos
Quando o usuário selecionar o projeto
E for direcionado a página do projeto
E selecionar o botão Editar - íncone Lápis ao lado do nome do projeto
E renomear o projeto como:'Teste Projeto3'
Então o nome do projeto será atualizado


@CRUDPROJ
Cenário: C04 - Excluir Projeto
Dado que o usuário está na página Meus Projetos
Quando selecionar o botão Novo Projeto
E nomear o projeto com: 'ProjetoTeste'
E deixar a descrição em branco 
E selecionar o botão Criar projeto  
Então o projeto será criado
E será adicionado a lista de projetos

Quando o usuário selecionar o projeto
E for direcionado a página do projeto
E selecionar o botão Excluir 
E o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Projeto?"
E confirmar a operação clicando no botão Sim
Então o projeto será excluido



@CRUDPROJ
Cenário: C05 - Excluir Projeto - Ação Excluir
Dado que o usuário está na página inicial da plataforma
Quando selecionar o menu Meus Projetos
E será apresentado uma lista com os projetos existentes
E selecionar um dos projetos da lista
E na coluna ação selecionar a opção Excluir
Quando o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Projeto?"
E o usuário confirmar a operação clicando no botão Sim
Então o projeto será excluido da lista de Projetos


@CRUDPROJ
Cenário: C06 - Excluir N Projetos
Dado que o usuário está na página inicial da plataforma
Quando selecionar o menu Meus Projetos
E será apresentado uma lista com os projetos existentes
E selecionar vários projetos da lista
E selecionaro botão Excluir Projetos
Quando o sistema abrir uma pop-up com a seguinte mensagem "Excluir projetos selecionados?"
E o usuário confirmar a operação clicando no botão Sim
Então os projetos serão excluidos da lista de Projetos

