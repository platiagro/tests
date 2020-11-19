#language:pt

Funcionalidade: Apresentação dos resultados até o momento

Contexto: Acessar Plataforma
Dado que o usuário acessa a plataforma PlatIAgro
E está na tela inicial


@P
Cenário: C01 - Criar Projeto 
Dado que o usuário está na página Meus Projetos
Quando clicar no botão Novo Projeto
Então o sistema deve abrir um modal, com o nome Novo Projeto selecionado
# Quando o usuário limpar o campo nome do projeto
E nomear o projeto com:'APTeste'
E informar a seguinte descrição:'Funcionalidade: Criar projeto'
Quando clicar no botão Criar
Então o novo projeto será criado 
E o usuário será direcionado para a página Detalhes do projeto
E será apresentado os seguintes dados: Descrição, Última modificação e Criado por
E nessa página poderá escolher se deseja iniciar um fluxo de Experimentação ou Pré -implantação
Quando selecionar o card Experimento
Então o usuário será direcionado para a págino do projeto onde poderá iniciar um novo fluxo de experimento 
Quando o usuário retornar para a página Detalhes do Projeto
E selecionar o botão Editar, ao lado do nome do projeto
E o sistema abrir um modal, com o atual nome do projeto selecionado
 Quando o usuário limpar o campo
 E nomear o projeto com:'TesteProj3'
 E informar a seguinte descrição:'Teste - Alterar Nome e Descrição'
 E clicar no botão Salvar
 Então o nome e a descrição do projeto serão atualizados