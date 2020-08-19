#language:pt

Funcionalidade: Criar Projeto na PlatIAgro
Como usuário da plataforma, desejo criar um novo Projeto para iniciar um experimento.


# Data: 07/05/2020
# Execução dos cenários realizado manualmente e automaticamente

 Contexto: Acessar Plataforma
 Dado que o usuário acessa a plataforma PlatIAgro
 E está na tela inicial
# E está na tela de longin
# Quando inserir o usuário:'user'
# E inserir a senha:'000000'
# E confirmar
# Então será apresentado a página "Meus Projetos", com a lista de projetos existentes daquele usuário


@CRUDPROJ
Cenário: C01 - Lista de Projetos
Dado que o usuário está na página Meus Projetos
E será apresentado sua lista de projetos existentes 
Então deverá observar que as informações dos projetos estarão divididos em cinco colunas: Nome do Projeto, Descrição, Tags, Última Modificação e Ação


@CRUDPROJ
Cenário: C02 - Criar Projeto - Operação: Criar
Dado que o usuário está na página Meus Projetos
Quando clicar no botão Novo Projeto
Então o sistema deve abrir um modal, com o nome Novo Projeto selecionado
# Quando o usuário limpar o campo nome do projeto
E nomear o projeto com:'ProjetoTeste'
E informar a seguinte descrição:'Teste - Funcionalidade: Criar projeto'
Quando clicar no botão Criar
Então o novo projeto será criado 
E o usuário será direcionado para a página do projeto
E nessa página poderá escolher se deseja iniciar um fluxo de Experimentação ou Pré -implantação
Quando o usuário retornar para a página Meus Projetos deverá observar se o novo projeto foi adicionado à lista de projetos 


@CRUDPROJ
Cenário:C03 - Criar Projeto - Operação: Cancelar
Dado que o usuário está na página Meus Projetos
Quando clicar no botão Novo Projeto
Então o sistema deve abrir um modal, com o nome Novo Projeto selecionado
E o usuário clicar no botão Cancelar
Então o modal deve ser resetado e fechado
E nenhum projeto deve ser criado


@CRUDPROJ
Cenário:C04 - Criar Projeto - Nome repetido
Dado que o usuário está na página Meus Projetos
Quando clicar no botão Novo Projeto
Então o sistema deve abrir um modal, com o nome Novo Projeto selecionado
#E o usuário limpar o campo nome
E nomear o projeto com:'Teste'
E informar a seguinte descrição:'Teste - Nome Repetido'
Quando clicar no botão Criar
Então a operação deve ser cancelada
E o sistema deverá informar que já existe um projeto com o nome informado


@tst
Cenário:C05 - Alterar nome do Projeto - Operação: Salvar e Cancelar
Dado que o usuário está na página Meus Projetos
Quando clicar no botão Novo Projeto
Então o sistema deve abrir um modal, com o nome Novo Projeto selecionado
#E o usuário limpar o campo nome
E nomear o projeto com:'TesteProj2'
E informar a seguinte descrição:'Teste - Alterar Nome'
E clicar no botão Criar 
Então um novo projeto será criado

Quando o usuário estiver na página do Projeto
E selecionar o botão Editar, ao lado do nome do projeto
Então o sistema deve abrir um modal, com o atual nome do projeto selecionado
Quando o usuário limpar o campo
E nomear o projeto com:'TesteProj3'
E informar a seguinte descrição:'Teste - Alterar Nome e Descrição'
E clicar no botão Salvar
Então o nome e a descrição do projeto serão atualizados

Quando selecionar o botão Editar novamente
E o sitema abrir o modal
E o usuário clicar no botão Cancelar
Então o modal deve ser resetado e fechado
E nenhuma alteração deve ser feita


@C
Cenário: C06 - Alterar nome do Projeto - Nome repetido
Dado que o usuário está na página Meus Projetos
E selecionar um dos projetos da lista de projetos
E selecionar o botão Alterar nome e descrição
Então será aberto um modal
E o atual nome do projeto deve estar selecionado
Quando o usuário limpar o campo
E nomear o projeto com:'Teste'
E manter a descrição atual do projeto
E clicar no botão confirmar 
Então a operação deve ser cancelada
E o sistema deverá informar que já existe um projeto com o nome informado


@CRUDPROJ
Cenário: C07 - Pesquisar Nome do Projeto
Dado que o usuário está na página Meus Projetos
E deseja pesquisar um projeto pelo nome 
Quando selecionar o icone de pesquisa ao lado da coluna Nome do Projeto
Então será aberto um modal
Quando o usuário inserir:'TesteProj3'
E selecionar o botão Search
Então o sistema deve apresentar o projeto que possui o nome inserido no campo de pesquisa
E se não houver nenhum projeto com o nome informado o sitema deve apresentar a página em branco


@CRUDPROJ
Cenário: C08 - Pesquisar Nome do Projeto - Cancelar
Dado que o usuário está na página Meus Projetos
E deseja pesquisar um projeto pelo nome 
Quando selecionar o icone de pesquisa ao lado da coluna Nome do Projeto
Então será aberto um modal
Quando o usuário inserir: 'Projeto Teste'
E selecionar o botão "Reset"
Então o sistema deve cancelar a operação
E o modal deve ser fechado



@CRUDPROJ
Cenário: C09 - Filtrar Projeto - Tags
Dado que o usuário está na página Meus Projetos
E deseja pesquisar um projeto pela Tag
Quando selecionar o icone ao lado da coluna Tags
Então será aberto um modal com as opções de tags

Quando o usuário selecionar a Tag "Experimentação" 
E selecionar o botão "OK"
Então o sistema deverá exibir os projetos que possuem experimeto

Quando selecionar o icone ao lado da coluna Tags
Então novamente será aberto o modal com as opções de tags
Quando o usuário selecionar a Tag "Pré implantação" 
E selecionar o botão "OK"
Então o sistema deverá exibir os projetos que possuem Pré implantação

Quando selecionar o icone ao lado da coluna Tags
Então novamente será aberto o modal com as opções de tags
Quando o usuário selecionar a Tag "Implantado" 
E selecionar o botão "OK"
Então o sistema deverá exibir os projetos que possuem Experimento Implantado



@CRUDPROJ
Esquema do Cenário: C10 - Filtrar Projeto - Tags - Resetar
Dado que o usuário está na página Meus Projetos
Dado que o usuário está na página Meus Projetos
E deseja pesquisar um projeto pela Tag
Quando selecionar o icone ao lado da coluna Tags
Então será aberto um modal com as opções de tags

Quando o usuário selecionar a Tag "Experimentação" 
E selecionar o botão "Resetar"
Então o modal será resetado e fechado

Quando selecionar o icone ao lado da coluna Tags
Então novamente será aberto o modal com as opções de tags
Quando o usuário selecionar a Tag "Pré implantação" 
E selecionar o botão "Resetar"
Então o modal será resetado e fechado

Quando selecionar o icone ao lado da coluna Tags
Então novamente será aberto o modal com as opções de tags
Quando o usuário selecionar a Tag "Implantado" 
E selecionar o botão "Resetar"
Então o modal será resetado e fechado


# @CRUDPROJ
# Cenário: C11 - Excluir Projeto
# Dado que o usuário está na página Meus Projetos
# Quando clicar no botão Novo Projeto
# Então o sistema deve abrir um modal, com o nome Novo Projeto selecionado
# E o usuário limpar o campo nome
# E renomear o projeto para: 'TesteProj4'
# E informar a seguinte descrição: 'Teste - Operação: Excluir'
# Quando clicar no botão Criar projeto
# Então o novo projeto será criado 
# E o usuário será direcionado para a página do projeto
# Quando o usuário estiver na página do novo projeto
# E selecionar o botão Excluir 
# E o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Projeto?"
# E confirmar a operação clicando no botão Sim
# Então o projeto será excluído
# E o usuário será direcionado para a página Meus Projetos



@CRUDPROJ
Cenário:C12 - Excluir Projeto - Ação Excluir
Dado que o usuário está na página Meus Projetos
Quando selecionar um dos projetos da lista
E na coluna ação selecionar a opção Excluir
E o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Projeto?"
E o usuário confirmar a operação clicando no botão Sim
Então o projeto será excluído da lista de Projetos



@CRUDPROJ
Cenário:C13 - Excluir Projeto - Ação Excluir - Cancelar
Dado que o usuário está na página Meus Projetos
Quando selecionar um dos projetos da lista
E na coluna ação selecionar a opção Excluir
E o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Projeto?"
E o usuário clicar no botão Não
Então a operação será cancelada
E o projeto não será excluído e permanecerá na lista de projetos

# Dado que o usuário seleciona outro projeto
# E acessar a página do projeto selecionado
# E selecionar o botão Excluir 
# E o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Projeto?"
# E o usuário clicar no botão Não
# Então a operação será cancelada
# E o projeto não será excluído



@CRUDPROJ
Cenário:C14 - Excluir N Projetos
Dado que o usuário está na página Meus Projetos
E será apresentado sua lista de projetos existente
Quando selecionar vários projetos da lista
E clicar no botão Excluir Selecionados
E o sistema abrir uma pop-up com a seguinte mensagem "Excluir projetos selecionados?"
E o usuário selecionar o botão "Não"
Então a operação será cancelada
E nenhum dos projetos selecionados será excluído
Quando o usuários selecionar vários projetos da lista novamente 
E clicar no botão Excluir Selecionados
E selecionar o botão "Sim"
Então todos os projetos selecionados serão excluídos
E removidos da lista de projetos

