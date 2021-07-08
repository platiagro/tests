#language:pt

Funcionalidade: Criar Experimento na PlatIAgro
Como usuário da plataforma, desejo criar um novo Experimento.

Contexto: Acessar a página Meus Projetos na Plataforma
  Dado que o browser seja aberto pelo usuário
  Quando a plataforma PlatIAgro for acessada
  Então será exibida com sucesso a tela inicial da página 'Meus projetos'

@CRUDEXP
Cenário: C01 - Visualização de Dados do Upload
 Dado que o usuário demande o clique no botão Novo Projeto
 E o sistema abra um modal, com o nome 'Novo Projeto' selecionado
 E o usuário limpar o campo nome do projeto
 E nomear o projeto inicialmente com: 'Teste'
 E efetuar o clique no botão Criar
 E o novo projeto será registrado
 E o usuário será direcionado para a página de detalhes do projeto
 E clicar no card Experimento
 E verificar se um novo experimento será criado, nomeado como: 'Experimento 1'
 E os botões acima da tela do fluxo de experimentação estarão desabilitados
 Quando o usuário selecionar o Menu Conjunto de Dados
 E selecionar e arrastar o operador Upload de arquivos para o fluxo
 E selecionar o operador novamente
 E no drawer de propriedades selecionar o botão Importar
 E o usuário irá informar o arquivo 'Iris.csv' para importar os dados de entrada
 E selecionar o botão Visualizar Dados
 Então a tela de visualização de dados vai ser aberta

@CRUDEXP
Cenário: C02 - Criar um Experimento com Sucesso
 Dado que o usuário volte ao fluxo
 E abra o menu Engenharia de Atributos
 E selecione a tarefa Seleção Manual de Atributos para adicionar ao fluxo
 E clique na tarefa Seleção Manual de Atributos presente no fluxo
 E no drawer de propriedade da tarefa selecione no campo Features para Filtragem o item Species
 E selecione o botão Executar
 E o sistema enviar a seguinte mensagem: 'Treinamento iniciado!'
 E confira se a função de salvar template estará desabilitada e o botão 'Interromper' sendo exibido
 E após a operação sendo concluída verificará que será sinalizada como 'Treinamento concluído'
 E garantindo que os botões acima do fluxo de experimento serão habilitados
 Quando o usuário selecionar a tarefa Seleção Manual de Atributos
 E selecionar o botão Visualizar Resultados
 Então um modal será aberto
 E o usuário poderá visualizar o valor do Dataset e dos Parâmetros

@CRUDEXP
Cenário: C03 - Criar um Experimento com Erro
 Dado que o usuário demande a criação de um novo Projeto
 E um novo experimento seja criado, nomeado como: 'Experimento 1'
 E for selecionado o menu Conjunto de Dados
 E arrastado o operador Upload de arquivos para o fluxo
 E clicar no operador novamente
 E no drawer de propriedades acionar o botão Importar
 E informar o arquivo 'imdb.csv' para importar os dados de entrada
 E selecionar o menu Treinamento
 E adicionar a tarefa Regressão Linear ao fluxo
 E no drawer de propriedade da tarefa selecione no campo Atributo Alvo o atributo label
 E no campo Features para incluir-remover no modelo selecionar o atributo text
 E no campo Features para fazer codificação ordinal selecionar o atributo is_valid
 Quando clicar no botão Executar
 Então a execução não será finalizada, com a platforma sinalizadando a Tarefa com erro
 E o usuário poderá visualizar o motivo no Histórico de Erros e Mensagens
 #E ao selecionar o botão Ver código no Jupyter o usuário poderá ver mais detallhes do erro na execução