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

@CRUDEXP
Cenário: C06 - Comparar Resultados
 Dado que o usuário selecione um projeto com N Experimentos
 E na página onde há os experimentos do projeto selecionar o botão Comparar Resultados
 E o sistema abrir a tela 'Comparar resultados'
 E selecionar o botão Adicionar Resultado
 Quando selecionar os experimentos em conjunto com as tarefas para comparação
 Então será exibido os resultados, as métricas e os parâmetros da tarefa selecionada

@CRUDEXP
Cenário: C07 - Salvar Como Template
 Dado que o usuário selecione um projeto da lista de Projetos
 E na página do experimento selecionar o botão Salvar como template
 E um modal será aberto pelo sistema
 E o nome 'Novo Template' deve estar destacado
 E limpar o campo nome do template
 E a mensagem 'Por favor insira um nome para o template!' deve ser exibida abaixo do campo nome
 E inserir o seguinte nome: 'Template - Teste'
 Quando selecionar o botão Salvar
 Então o menu Templates ficará visível no Armazém de Tarefas
 E o template será salvo nesse menu

@CRUDEXP
Cenário: C08 - Adicionar Template ao Fluxo
 Dado que o usuário deseje criar um novo Projeto
 E selecione o botão Novo experimento
 E nomeie o experimento como: 'Teste - Experimento Template'
 E demandar o clique no botão Criar
 E verificar que o novo experimento foi criado
 Quando selecionar o template salvo anteriormente para adicionar ao fluxo
 Então o usuário poderá iniciar seu novo experimento

@CRUDEXP
Cenário: C09 - Interromper Execução
 Dado que o usuário tenha um projeto com tarefas no fluxo da experimentação
 E o usuário selecionar o botão Executar
 E o sistema exibir a seguinte mensagem: 'Treinamento iniciado!'
 Quando selecionar o botão Interromper
 Então a mensagem 'Interrompendo execução...' deve ser exibida no topo da tela
 E será exibida na finalização do processo de interrupção a mensagem: 'Treinamento interrompido!'

@CRUDEXP
Cenário: C10 - Preparar para Implantação
 Dado que o usuário selecione um projeto com experimentos associados
 E selecione o botão Preparar para a implantação
 E na sequência será aberto um modal com seguinte título: 'Preparar para a implantação'
 E selecionar os fluxos
 Quando clicar em OK após a seleção
 Então o sistema irá indicar que os experimentos foram implantados: 'Experimento implantado!'
 E será direcionado para a página de fluxos implantados: 'Pré-implantação'

@CRUDEXP
Cenário: C11 - Excluir Tarefa
Dado que seja selecionado um projeto na listagem que possua experimento associado
Quando selecionar a Tarefa presente no fluxo de experimento para remover
Então a tarefa será removida do fluxo de experimento com o sistema apresentando: 'Operador removido com sucesso!'

@CRUDEXP
Cenário: C12 - Resetar a Exclusão do Experimento
Dado que o usuário selecione a função Excluir, ao lado do nome do Experimento
E uma pop-up com a seguinte mensagem 'Excluir o experimento?' for exibida
Quando for selecionado o botão Não
Então o pop-up será fechado
E o experimento não será excluído

@CRUDEXP
Cenário: C13 - Excluir Experimento
Dado que o usuário faça a seleção da função Excluir, ao lado do nome do Experimento
E uma pop-up com a seguinte mensagem for exibida: 'Excluir o experimento?'
Quando for selecionado o botão Sim
Então será fechado o pop-up
E o experimento será excluído

@CRUDEXP
Cenário: C14 - Excluir Template
Dado que o usuário selecione no armazém de tarefas o template salvo
Quando for requisitada a remoção do template
Então será removida do menu com o sistema apresentando: 'Template excluído com sucesso!'