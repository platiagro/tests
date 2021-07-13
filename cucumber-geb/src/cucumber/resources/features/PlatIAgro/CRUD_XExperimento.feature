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
 E ao selecionar o botão Ver código no Jupyter o usuário poderá ver mais detallhes do erro na execução

@CRUDEXP
Cenário: C04 - Alterar Nome de um Experimento
 Dado que o usuário selecione um projeto presente na listagem
 E selecione o card experimento
 E clicar com o botão direito em cima do nome
 E selecionar a opção Renomear
 E haverá a abertura de um modal
 E o usuário deverá limpar o campo
 E alterar o nome do experimento acrescentando ao final: 'Alter'
 Quando clicar no botão OK
 Então o modal será resetado
 E o nome do experimento será alterado com sucesso

@CRUDEXP
Cenário: C05 - Duplicar Experimento
Dado que o usuário selecione um projeto da lista
E efetue o clique no card experimento
E clique com o botão direito na aba do experimento
E selecione a opção Duplicar
E um modal seja aberto
E insira o seguinte nome para a duplicata: 'Teste_Exp_Duplicado'
E realizar o clique no botão OK
E para o modal haverá o reset
E o Experimento será duplicado
Quando o usuário selecionar o botão Executar na aba da duplicata do experimento
Então o sistema enviará a seguinte mensagem: 'Treinamento iniciado!'
E o botão Salvar como Template será desabilitado e aparecerá a função para 'Interromper'
E após efetivação cada tarefa será sinalizada como 'Treinamento concluído'
E os botões acima do fluxo de experimento serão habilitados