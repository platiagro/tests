#language:pt

Funcionalidade: Criar Experimento na PlatIAgro
Como usuário da plataforma, desejo criar um novo Experimento.



Contexto: Acessar Plataforma
Dado que o usuário acessa a Plataforma PlatIAgro
E está na tela inicial



@1
Cenário: C01 - Visualização de Dados
Dado que o usuário está na página Meus Projetos
E clicar no botão Novo Projeto
E o sistema deve abrir um modal, com o nome Novo Projeto selecionado
E o usuário limpar o campo nome do projeto
E nomear o projeto com:'Teste J '
E clicar no botão Criar
E o novo projeto será criado
E o usuário será direcionado para a página Detalhes do projeto
E um novo experimento será criado, nomeado como Experimento 1
E selecionar o card Experimento
E os botões acima da tela do fluxo de experimentação estarão desabilitados
Quando o usuário selecionar o Menu Conjunto de Dados
E selecionar e arrastar o operador Upload de arquivos para o fluxo
E selecionar o operador novamente
E no drawer de propriedades selecionar o botão Importar
E poderá escolher arquivos .csv, .zip e imagem para importar os dados
E o usuário irá informar o arquivo 'Iris.csv' para importar os dados de entrada
E selecionar o botão Visualizar Dados
Então a tela de visualização de dados vai ser aberta

#CONTINUAÇÃO DO C01 - Criar um Experimento com Sucesso
Dado que o usuário irá voltar ao fluxo
E selecionar o Menu Treinamento
E selecionar a tarefa Regressão Logística
E a Tarefa será adicionada ao fluxo
E selecionar a tarefa Regressão Logística presente no fluxo
E no drawer de propriedades da tarefa selecionar o campo Atributo Alvo
E será exibido os atributos do arquivo de entrada
E o usuário irá selecionar o atributo Species
E no campo Modo de seleção das features, o usuário irá selecionar a opção Incluir
E no campo Features para incluir-remover no modelo selecionar o atributo SepalLengthCm
E no campo Features para fazer codificação ordinal selecionar o atributo PetalWidthCm
E o usuário não irá alterar os demais campos da Tarefa
E o usuário irá selecionar o botão Executar
E o sistema iráenviar a seguinte mensagem "Treinamento iniciado!"
E cada tarefa será sinalizada como "Tarefa Pendente"
E os botões "Salvar como Template" e "Executar" serão desabilitados
E o botão "Interromper" será exibido
Quando a operação for concluída com sucesso
E cada tarefa será sinalizada como "Tarefa executada com sucesso"
E os botões acima do fluxo de experimento serão habilitados
E o usuário selecionar a tarefa "Regressão Logística"
E selecionar o botão Visualizar Resultados
E um modal será aberto
Então o usuário poderá visualizar os gráficos do Resultados, o valor das Métricas e dos Parâmetros




@2
Cenário: C02 - Criar um Experimento com Erro
Dado que o usuário está na página Meus Projetos
E ao clicar no botão Novo Projeto
Quando o sistema deve abrir um modal, com o nome Novo Projeto selecionado
E o usuário limpar o campo nome do projeto
E nomear o projeto com:'TesteExp 2'
E informar a seguinte descrição: 'Automação_Teste: Executar Experimento com erro'
E clicar no botão Criar
Então o novo projeto será criado

#CONTINUAÇÃO DO C02
Dado que o usuário será direcionado para a página do projeto
E um novo experimento será criado, nomeado como "Experimento 1"
E os botões acima da tela do fluxo de experimentação estarão desabilitados, exceto o botão Excluir
E o usuário selecionar o operador Conjunto de Dados, presente no fluxo de experimento
E no drawer de propriedades selecionar o botão "Importar"
E poderá escolher arquivos .csv e .zip para importar os dados
E o usuário irá informar o arquivo 'imdb.csv' para importar os dados de entrada
E selecionar o botão Visualizar Dados
E a tela de visualização de dados for aberta
E o usuário irá voltar ao fluxo
Quando selecionar o Menu Treinamento
E selecionar a tarefa "Regressão Linear"
E a Tarefa será adicionada ao fluxo
E selecionar a tarefa Regressão Linear presente no fluxo
E no drawer de propriedades da tarefa selecionar o campo "Atributo Alvo"
E será exibido os atributos do arquivo de entrada
E o usuário irá selecionar o atributo "label"
E no campo Modo de seleção das features, deixar o campo com o valor default
E no campo Features para incluir-remover no modelo selecionar o atributo "text"
E no campo Features para fazer codificação ordinal selecionar o atributo "is_valid"
E o usuário selecionar o botão Executar
E o sistema enviar a seguinte mensagem "Treinamento iniciado!"
E cada tarefa será sinalizada como "Tarefa Pendente"
E os botões "Salvar como Template" e "Executar" serão desabilitados
E o botão "Interromper" será exibido
E a execução não será finalizada
E a Tarefa será sinalizada com erro
E o usuário selecionar a Tarefa
E será exibido no drawer de propriedades da tarefa, o campo Erro na Execução
E o usuário poderá visualizar o motivo do erro
E selecionar o botão "Ver código no Jupyter"
Então o usuário será direcionado a página JupyterLab
E poderá ver mais detallhes do erro na execução



@3
Cenário: C03 - Criar um Experimento com o Nome Repetido
Dado que o usuário está na página Meus Projetos
E selecionar um projeto da lista de Projetos
E o usuário será direcionado a página do projeto
E selecionar o botão "Novo experimento", ícone "+" posicionado ao lado da aba do Experimento 1
E o modal Novo Experimento será aberto
E o nome "Novo Experimento" deve estar destacado
E o usuário clicar no botão limpar
E o campo nome do experimento deve ser limpo
E a mensagem "Por favor insira um nome para o experimento!" deve ser exibida abaixo do campo nome
E o usuário inserir o nome: 'Experimento 1'
Quando selecionar o botão Criar
E a operação deve ser cancelada
E o sistema deverá informar que já existe um Experimento com o nome informado nesse Projeto
E o usuário deverá limpar o campo nome
E informar um novo nome para o experimento, como: 'Experimento Teste'
E selecionar o botão Criar
Então um novo experimento deve ser criado
E uma mensagem de sucesso com o nome do experimento deve ser exibida no topo da tela



#Esse cenário é apenas para teste - deve ser incluido nos cenários 1,2 e 8
@3.1
Cenário: C03.1 - Conectar Tarefas no Fluxo de Experimento
Dado que o usuário está na página Meus Projetos
E selecionar um projeto da lista de Projetos
E o usuário será direcionado a página do projeto
Quando selecionar o card Experimento
E que o projeto contém tarefas no fluxo
Então o usuário selecionar a Tarefa para puxar o conector
E conectar uma tarefa na outra



@4
Cenário: C04 - Alterar Nome de um Experimento
Dado que o usuário está na página Meus Projetos
E selecionar um projeto da lista de Projetos
E o usuário será direcionado a página do projeto
Quando selecionar a aba de um experimento
E clicar no botão direito
E selecionar a opção "Renomear"
E um modal será aberto
E o usuário deverá limpar o campo
E inserir um novo nome para o experimento: 'AltName_Exp'
E clicar no botão OK
Então o nome do experimento será alterado
E o modal será resetado



@5
Cenário: C05 - Duplicar Experimento
Dado que o usuário está na página Meus Projetos
E selecionar um projeto da lista
E o usuário será direcionado a página do projeto
E selecionar a aba de um experimento
E clicar no botão direito
E selecionar a opção Duplicar
E um modal será aberto
E o usuário deverá inserir o nome: 'Dup_Teste' para a duplicata
E clicar no botão OK
E o Experimento será duplicado
E o modal será resetado
E que o usuário está na aba da duplicata do experimento
Quando o usuário selecionar o botão Executar
E o sistema enviar a seguinte mensagem Treinamento iniciado!
E cada tarefa será sinalizada como Tarefa Pendente
E os botões Salvar como Template e Executar serão desabilitados
E o botão "Interromper" será exibido
E a operação for concluída com sucesso
Então cada tarefa será sinalizada como "Tarefa executada com sucesso"
E os botões acima do fluxo de experimento serão habilitados



@6
Cenário: C06 - Comparar Resultados
Dado que o usuário está na página Meus Projetos
E selecionar um projeto com N Experimentos
E o usuário será direcionado a página do projeto
E selecionar o botão Comparar Resultados
E o sistema abrir a tela "Comparar resultados"
E selecionar o botão Adicionar Resultado
E selecionar os experimentos que deseja comparar
E deverá ser apresentado o histórico de execução de cada experimento selecionado
Quando o usuário selecionar uma das opções do histórico de execução
E selecionar uma tarefa
Então será exibido os resultados, as métricas e os parâmetros da tarefa selecionada



@7
Cenário: C07 - Salvar Como Template
Dado que o usuário está na página Meus Projetos
E selecionar um projeto da lista de Projetos
E esse Projeto possui experimentos associados
E o usuário será direcionado a página do projeto
E o usuário selecionar o botão "Salvar como template"
E o modal Novo Template será aberto
E o nome "Novo template" deve estar destacado
E o usuário limpar o campo nome do template
E a mensagem "Por favor insira um nome para o template!" deve ser exibida abaixo do campo nome
E inserir: 'Template - Teste'
E selecionar o botão "Salvar"
E o Menu Templates ficará visível no Armazém de Tarefas
E o template será salvo nesse menu
E o usuário selecionar o botão "Novo experimento"
E nomear o experimento como: 'Experimento Teste - Template'
E clicar no botão "Criar"
E um novo experimento deve ser criado
E selecionar o template salvo anteriormente
E as tarefas do template serão adicionadas ao fluxo
E o usuário poderá iniciar seu novo experimento
E que o usuário deseja criar um novo Projeto para testar o template
Quando clicar no botão Novo Projeto
E nomear o projeto com:'TesteExp 3'
E informar a seguinte descrição:'Template - Teste'
E clicar no botão Criar
E o usuário será direcionado a página do Projeto
E o usuário selecionar o Menu Templates
E selecionar o template salvo anteriormente
Então as tarefas do template serão adicionadas ao fluxo
E o usuário poderá iniciar seu novo experimento



@8
Cenário: C08 - Interromper Execução
Dado que o usuário está na página Meus Projetos
E clicar no botão Novo Projeto
E o sistema deve abrir um modal, com o nome Novo Projeto selecionado
E o campo nome do experimento deve ser limpo
E nomear o projeto com:'TesteExp 4'
E informar a seguinte descrição:'Teste - Interromper Execução'
E clicar no botão Criar
E o novo projeto será criado
E o usuário será direcionado para a página do projeto
E um novo experimento será criado, nomeado como "Experimento 1"
E os botões acima da tela do fluxo de experimentação estarão desabilitados, exceto o botão Excluir
Quando o usuário selecionar o operador Conjunto de Dados, presente no fluxo de experimento
E no drawer de propriedades selecionar o botão "Importar"
E poderá escolher arquivos .csv e .zip para importar os dados
E o usuário irá informar o arquivo 'imdb.csv' para importar os dados de entrada
E selecionar o Menu Treinamento
E selecionar a tarefa "Classificador AutoML"
E a Tarefa será adicionada ao fluxo
E selecionar a tarefa Classificador AutoML presente no fluxo
E no drawer de propriedades da tarefa selecionar o campo "Atributo Alvo"
E será exibido os atributos do arquivo de entrada
E o usuário irá selecionar o atributo "label"
E no campo Modo de seleção das features, deixar o campo com o valor default
E no campo Features para incluir-remover no modelo selecionar o atributo "text"
E no campo Features para fazer codificação one-hot selecionar o atributo "is_valid"
E deixar os demais campos com o valor default
E o usuário selecionar o botão Executar
E o sistema enviar a seguinte mensagem "Treinamento iniciado!"
E cada tarefa será sinalizada como "Tarefa Pendente"
E os botões "Salvar como Template" e "Executar" serão desabilitados
E o botão "Interromper" será exibido
E selecionar o botão Interromper
E a mensagem "Interrompendo execução..." deve ser exibida no topo da tela
E o processo de interrupção for finalizado
E a mensagem "Treinamento interrompido!" for exibido no topo da tela
Então as tarefas no fluxo de experimento deverão ser sinalizadas como "Tarefa Interrompida"
E ao selecionar as tarefas o usuário poderá editar suas propriedades
E executar o experimento novamente



@9
Cenário: C09 - Preparar para Implantação
Dado que o usuário está na página Meus Projetos
E selecionar um projeto da lista de Projetos
E esse Projeto possui experimentos associados
E o usuário será direcionado a página do projeto
Quando selecionar o botão "Preparar para Implantação"
E o usuário será direcionado a página Fluxos implantados
E o usuário voltar para a página do Projeto
E deverá observar que o botão Preparar para Implantação estará em modo de execução
E quando a implantação for finalizada
Então o botão de implantação será desabilitado



@10
Cenário: C10 - Excluir Tarefa e Experimento
Dado selecionar um projeto da lista de Projetos
E esse Projeto possui experimentos associados
E o usuário será direcionado a página do projeto
E selecionar a Tarefa presente no fluxo de experimento
E selecionar o botão Excluir Tarefa
E o sistema irá abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir essa tarefa?"
E o usuário selecionar o botão Sim
E a tarefa será retirada do fluxo de experimento
E o usuário poderá adicionar outra Tarefa ao fluxo
Quando o usuário selecionar o botão Excluir, ao lado do nome do Experimento
E uma pop-up com a seguinte mensagem "Excluir Experimento?" for exibida
E selecionar o botão Sim
E o experimento será excluído
E o usuário selecionar o botão excluir
E clicar no botão Não
E o pop-up será fechado
E o experimento não será excluído
E se o usuário excluir todos os Experimentos do Projeto
Então a página do Projeto ficará vazia


