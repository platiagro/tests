#language:pt

Funcionalidade: Projetos na PlatIAgro
Como usuário da plataforma, desejo criar um novo Projeto para iniciar um experimento.

Contexto: Acessar a página Meus Projetos na Plataforma
  Dado que o usuário abra o browser
  Quando acessar a plataforma PlatIAgro
  Então a tela inicial da página 'Meus projetos' será exibida com sucesso

@PROJETO
Cenário: C01 - Criar Projeto - Operação: Criar
 Dado que o usuário clique no botão Novo Projeto
 E o sistema abra um modal com o nome 'Novo Projeto' selecionado
 E limpe o campo nome do projeto
 E nomear o projeto com o nome inicial de: 'Teste'
 E informar a seguinte descrição: 'Teste - Funcionalidade: Criar projeto'
 Quando clicar no botão Criar
 E o novo projeto será criado
 E o usuário será direcionado para a página Detalhes do projeto
 E será apresentado os seguintes dados: 'Descrição', 'Última modificação' e 'Criado por'
 E nessa página poderá escolher se deseja iniciar um fluxo de 'Experimentação' ou 'Pré-implantação'
 E selecionar o card Experimento
 E o usuário será direcionado para a página do projeto onde poderá iniciar um novo fluxo de experimento: 'Experimentação'
 Então o usuário ao retornar para a página 'Meus projetos' deverá observar se o novo projeto foi adicionado à lista de projetos
 E deverá estar divididos em cinco colunas: 'Nome do Projeto', 'Descrição', 'Tags', 'Última modificação' e 'Ação'

@PROJETO
Cenário: C02 - Criar Projeto - Operação: Cancelar
 Dado que o usuário efetue o clique no botão Novo Projeto
 E o sistema abrir um modal com o nome 'Novo Projeto' selecionado
 Quando realizar o clique no botão Cancelar
 Então o modal deve ser resetado e fechado

@PROJETO
Cenário: C03 - Criar Projeto - Nome repetido
 Dado que o usuário realize o clique no botão Novo Projeto
 E o sistema demandar a abertura do modal com o nome 'Novo Projeto' selecionado
 E seja apagado o conteúdo do campo nome do projeto
 E nomeie o projeto com o mesmo nome do projeto criado anteriormente
 E na descrição inserir a seguinte informação: 'Teste - Nome Repetido'
 Quando for demandado o clique no botão Criar
 Então o sistema deverá informar que 'Já existe um projeto com este nome!'

@PROJETO
Cenário: C04 - Alterar nome do Projeto - Operação: Salvar Alteração
 Dado que o usuário detalhe o Projeto criado anteriormente
 E selecione o botão Editar, ao lado do nome do projeto
 E o sistema abrir um modal, com o atual nome do projeto selecionado
 Quando o usuário limpar o campo
 E renomear o projeto acrescentando ao final: 'Alter'
 E informar no campo descrição: 'Teste - Alterar Nome e Descrição'
 E clicar no botão para salvar a alteração: 'Projeto salvo!'
 Então o nome e a descrição do projeto serão atualizados

@PROJETO
Cenário: C05 - Pesquisar Nome do Projeto
 Dado que o usuário faça a seleção do ícone de pesquisa ao lado da coluna Nome do Projeto
 E que seja aberto um modal
 E inserir o nome de um projeto existente na lista
 Quando selecionar o botão Buscar
 Então o sistema deve apresentar o projeto que possui o nome inserido no campo de pesquisa

@PROJETO
Cenário: C06 - Pesquisar Nome do Projeto - Cancelar
 Dado que o usuário selecione o ícone de pesquisa ao lado da coluna Nome do Projeto
 E seja aberto um modal
 Quando inserir o nome do projeto alterado anteriormente
 E selecionar o botão Reset
 Então o sistema deve cancelar a operação fechando o modal

@PROJETO
Cenário: C07 - Filtrar Projeto - Tags
 Dado que o usuário faça a seleção do ícone ao lado da coluna Tags
 E que seja aberto um modal com as opções de tags: 'Experimentação', 'Pré-implantação' e 'Implantado'
 E demandar a seleção da Tag Experimentação
 Quando selecionar o botão OK
 Então o sistema deverá exibir os projetos que possuem 'Experimentação'

@PROJETO
Cenário: C08 - Filtrar Projeto - Tags - Resetar
 Dado que o usuário selecione o ícone ao lado da coluna Tags
 E seja aberto um modal com as opções de tags: 'Experimentação', 'Pré-implantação' e 'Implantado'
 E selecionar a Tag Experimentação
 Quando selecionar o botão Resetar
 Então o modal das Tags será fechado

@PROJETO
Cenário: C09 - Excluir Projeto - Página Detalhes do Projeto
 Dado que o usuário faça o clique no botão Novo Projeto
 E o sistema demandar a abertura de um modal com o nome 'Novo Projeto' selecionado
 E suceder em limpar o campo nome do projeto
 E inserir um nome para o projeto: 'TesteDelete'
 E na descrição informar: 'Teste - Operação: Excluir - Pela Página Detalhes do Projeto'
 E realizar o clique no botão Criar
 E o novo projeto será criado com sucesso
 E será direcionado para a página Detalhes do projeto
 E selecionar o botão Excluir
 E o sistema abrir uma pop-up com a seguinte mensagem: 'Você tem certeza que deseja excluir esse projeto?'
 Quando confirmar a operação clicando no botão Sim
 Então o projeto será excluído
 E o usuário será direcionado para a página 'Meus projetos'

@PROJETO
Cenário: C10 - Excluir Projeto - Detalhes - Cancelar
Dado que o usuário acesse a página Detalhes do projeto selecionado
E acionar o botão Excluir
E o sistema revelar uma pop-up com a seguinte mensagem: 'Você tem certeza que deseja excluir esse projeto?'
Quando o usuário efetuar o clique no botão Não
Então o projeto não será excluído

@PROJETO
Cenário: C11 - Excluir Projeto - Ação - Cancelar
 Dado que o usuário efetue a seleção de um dos projetos da lista
 E na coluna ação seletar a opção Excluir
 E o sistema apresentar uma pop-up com a seguinte mensagem: 'Você tem certeza que deseja excluir esse projeto?'
 Quando o usuário clicar no botão Não
 Então o projeto não será excluído e permanecerá na lista de projetos

@PROJETO
Cenário: C12 - Excluir Projeto - Ação Excluir
 Dado que o usuário selecione um dos projetos da lista
 E na coluna ação selecionar a opção Excluir
 E o sistema exibir uma pop-up com a seguinte mensagem: 'Você tem certeza que deseja excluir esse projeto?'
 Quando o usuário confirmar a operação clicando no botão Sim
 Então o projeto será excluído da lista de Projetos

@PROJETO
Cenário: C13 - Excluir N Projetos - Cancelar
 Dado que o usuário selecione vários projetos da lista
 E clicar no botão Excluir Selecionados
 E o sistema iniciar uma pop-up com a seguinte mensagem: 'Excluir projetos selecionados?'
 Quando o usuário selecionar o botão Não
 Então nenhum dos projetos selecionados será excluído

@PROJETO
Cenário: C14 - Excluir N Projetos - Efetivar Exclusão
 Dado que o usuário selecione vários projetos existentes na lista
 E na sequência clicar no botão Excluir Selecionados
 E o sistema encetar uma pop-up com a seguinte mensagem: 'Excluir projetos selecionados?'
 Quando o usuário requerer o clique no botão Sim
 Então todos os projetos selecionados serão excluídos
 E removidos da lista de projetos