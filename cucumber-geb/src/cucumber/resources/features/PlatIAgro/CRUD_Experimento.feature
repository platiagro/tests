#language:pt

Funcionalidade: Criar Experimento na PlatIAgro
Como usuário da plataforma, desejo criar um novo Experimento.


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


@E
Cenário: C01 - Criar e Executar Experimento
Dado que o usuário está na página Meus Projetos
Quando clicar no botão Novo Projeto
Então o sistema deve abrir um modal, com o nome Novo Projeto selecionado
# Quando o usuário limpar o campo nome do projeto
E nomear o projeto com:'TesteExp'
# E informar a seguinte descrição:'Automação_Teste: Executar Fluxo de Experimento'
Quando clicar no botão Criar
Então o novo projeto será criado 
E o usuário será direcionado para a página do projeto
E um novo experimento será criado, nomeado como Experimento 1
E os botões acima da tela do fluxo de experimentação estarão desabilitados, exceto o botão Excluir

Quando o usuário selecionar o Menu Conjunto de Dados
E selecionar e arrastar o operador Upload de arquivos para o fluxo
# Quando selecionar o operador novamente
# E no drawer de propriedades selecionar o botão Importar
# E poderá escolher arquivos .csv, .zip e imagem para importar os dados
# Então o usuário irá informar o arquivo 'Iris.csv' para importar os dados de entrada

# Quando selecionar o botão Visualizar Dados
# E a tela de visualização de dados for aberta
# # E importar um arquivo TXT
# # E selecionar um atributo alvo
# Então o usuário irá voltar ao fluxo
# # E os botões "Salvar Template" e "Executar" estarão habilitados

# Quando selecionar o Menu Engenharia de atributos
# E selecionar a tarefa Imputação de Valores Faltantes
# Então a Tarefa será adicionada ao fluxo

# Quando selecionar o Menu Treinamento
# E selecionar a tarefa Regressão Logística
# Então a Tarefa será adicionada ao fluxo

# Quando o usuário selecionar a tarefa Imputação de Valores Faltantes
# E no drawer de propriedades da tarefa selecionar o campo Atributo Alvo
# E será exibido os atributos do arquivo de entrada
# Então o usuário irá selecionar o atributo Species
# E no último campo de preenchimento de valores nulos, o usuário irá inserir: 'Teste'

# Quando selecionar a tarefa Regressão Logística presente no fluxo
# E no drawer de propriedades da tarefa selecionar o campo Atributo Alvo
# E será exibido os atributos do arquivo de entrada
# Então o usuário irá selecionar o atributo Species
# E no campo Modo de seleção das features, o usuário irá selecionar a opção Incluir
# E no campo Features para incluir-remover no modelo selecionar o atributo SepalLengthCm
# E no campo Features para fazer codificação ordinal selecionar o atributo PetalWidthCm
# Então o usuário não irá alterar os demais campos da Tarefa

# Quando o usuário selecionar o botão Executar
# E o sistema enviar a seguinte mensagem "Treinamento iniciado!"
# Então cada tarefa será sinalizada como "Tarefa Pendente"
# E os botões "Salvar como Template" e "Executar" serão desabilitados
# E o botão "Interromper" será exibido

# Quando a operação for concluída com sucesso
# Então cada tarefa será sinalizada como "Tarefa executada com sucesso"
# E os botões acima do fluxo de experimento serão habilitados

# Quando o usuário selecionar a tarefa "Regressão Logística"
# E selecionar o botão Visualizar Resultados
# Então um modal será aberto 
# E o usuário poderá visualizar os gráficos do Resultados, o valor das Métricas e dos Parâmetros 



@EXPERIMENTO
Cenário: C02 - Executar Experimento com erro
Dado que o usuário está na página Meus Projetos
Quando clicar no botão Novo Projeto
Então o sistema deve abrir um modal, com o nome Novo Projeto selecionado
# Quando o usuário limpar o campo nome do projeto
E nomear o projeto com:'TesteExp 2'
E informar a seguinte descrição:'Automação_Teste: Executar Experimento com erro'
Quando clicar no botão Criar
Então o novo projeto será criado 
E o usuário será direcionado para a página do projeto
E um novo experimento será criado, nomeado como "Experimento 1"
E os botões acima da tela do fluxo de experimentação estarão desabilitados, exceto o botão Excluir

Quando o usuário selecionar o operador Conjunto de Dados, presente no fluxo de experimento
E no drawer de propriedades selecionar o botão "Importar"
E poderá escolher arquivos .csv e .zip para importar os dados
Então o usuário irá informar o arquivo 'imdb.csv' para importar os dados de entrada

Quando selecionar o botão Visualizar Dados
E a tela de visualização de dados for aberta
# E importar um arquivo TXT
# E selecionar um atributo alvo
Então o usuário irá voltar ao fluxo
# E os botões "Salvar Template" e "Executar" estarão habilitados

Quando selecionar o Menu Treinamento
E selecionar a tarefa "Regressão Linear"
Então a Tarefa será adicionada ao fluxo

Quando selecionar a tarefa Regressão Linear presente no fluxo
E no drawer de propriedades da tarefa selecionar o campo "Atributo Alvo"
E será exibido os atributos do arquivo de entrada
Então o usuário irá selecionar o atributo "label"
E no campo Modo de seleção das features, deixar o campo com o valor default
E no campo Features para incluir-remover no modelo selecionar o atributo "text"
E no campo Features para fazer codificação ordinal selecionar o atributo "is_valid"

Quando o usuário selecionar o botão Executar
E o sistema enviar a seguinte mensagem "Treinamento iniciado!"
Então cada tarefa será sinalizada como "Tarefa Pendente"
E os botões "Salvar como Template" e "Executar" serão desabilitados
E o botão "Interromper" será exibido
Então a execução não será finalizada
E a Tarefa será sinalizada com erro

Quando o usuário selecionar a Tarefa
Então será exibido no drawer de propriedades da tarefa, o campo Erro na Execução
E o usuário poderá visualizar o motivo do erro

Quando selecionar o botão "Ver código no Jupyter"
Então o usuário será direcionado a página JupyterLab
# E poderá ver mais detallhes do erro na execução



@EXPERIMENTO
Cenário: C03 - Criar Experimento - Nome Repetido
Dado que o usuário está na página Meus Projetos
Quando selecionar um projeto da lista de Projetos
Então o usuário será direcionado a página do projeto

Quando selecionar o botão "Novo experimento", ícone "+" posicionado ao lado da aba do Experimento 1
Então o modal Novo Experimento será aberto
E o nome "Novo Experimento" deve estar destacado 

Quando o usuário clicar no botão limpar
E o campo nome do experimento for limpo
Então a mensagem "Por favor insira um nome para o experimento!" deve ser exibida abaixo do campo nome

Quando o usuário inserir o nome: 'Experimento 1'
E selecionar o botão Criar
Então a operação deve ser cancelada 
E o sistema deverá informar que já existe um Experimento com o nome informado nesse Projeto

Então o usuário deverá limpar o campo nome
E informar um novo nome para o experimento, como: 'Experimento Teste'
E selecionar o botão Criar
Então um novo experimento deve ser criado
E uma mensagem de sucesso com o nome do experimento deve ser exibida no topo da tela



@A
Cenário: C03.1 - Conectar Tarefas no fluxo de Experimento
Dado que o usuário está na página Meus Projetos
Quando selecionar um projeto da lista de Projetos
Então o usuário será direcionado a página do projeto

 Dado que o projeto contém tarefas no fluxo
 Quando o usuário selecionar a Tarefa para puxar o conector 
 E conectar uma tarefa na outra



@EXPERIMENTO
Cenário: C04 - Alterar Nome de um Experimento
Dado que o usuário está na página Meus Projetos
Quando selecionar um projeto da lista de Projetos
Então o usuário será direcionado a página do projeto

Quando selecionar a aba de um experimento
E clicar no botão direito
E selecionar a opção "Renomear"
Então um modal será aberto 
E o usuário deverá limpar o campo 
E inserir um novo nome para o experimento: 'AltName_Exp'
Quando clicar no botão OK
Então o nome do experimento será alterado 
E o modal será resetado


@tst
Cenário: C05 - Duplicar Experimento
Dado que o usuário está na página Meus Projetos
Quando selec.ionar um projeto da lista
Então o usuário será direcionado a página do projeto

Quando selecionar a aba de um experimento
E clicar no botão direito
E selecionar a opção Duplicar
Então um modal será aberto 
E o usuário deverá inserir o nome: 'Dup_Teste' para a duplicata 
Quando clicar no botão OK
Então o Experimento será duplicado 
E o modal será resetado

    Dado que o usuário está na aba da duplicata do experimento
    Quando o usuário selecionar o botão Executar
    E o sistema enviar a seguinte mensagem Treinamento iniciado!
    Então cada tarefa será sinalizada como Tarefa Pendente
    E os botões Salvar como Template e Executar serão desabilitados
    E o botão "Interromper" será exibido

    Quando a operação for concluída com sucesso
    Então cada tarefa será sinalizada como "Tarefa executada com sucesso"
    E os botões acima do fluxo de experimento serão habilitados


@EXPERIMENTO
Cenário: C06 - Salvar Como Template
Dado que o usuário está na página Meus Projetos
Quando selecionar um projeto da lista de Projetos
E esse Projeto possui experimentos associados
Então o usuário será direcionado a página do projeto

Quando o usuário selecionar o botão "Salvar como template"
Então o modal Novo Template será aberto
E o nome "Novo template" deve estar destacado

Quando o usuário limpar o campo nome do template
Então a mensagem "Por favor insira um nome para o template!" deve ser exibida abaixo do campo nome

Quando inserir: 'Template - Teste'
E selecionar o botão "Salvar"
Então o Menu Templates ficará visível no Armazém de Tarefas
E o template será salvo nesse menu

Quando o usuário selecionar o botão "Novo experimento"
E nomear o experimento como: 'Experimento Teste - Template'
E clicar no botão "Criar"
Então um novo experimento deve ser criado

Quando selecionar o template salvo anteriormente 
Então as tarefas do template serão adicionadas ao fluxo
E o usuário poderá iniciar seu novo experimento

Dado que o usuário deseja criar um novo Projeto para testar o template
Quando clicar no botão Novo Projeto
E nomear o projeto com:'TesteExp 3'
E informar a seguinte descrição:'Template - Teste'
Quando clicar no botão Criar
Então o usuário será direcionado a página do Projeto

Quando o usuário selecionar o Menu Templates
E selecionar o template salvo anteriormente 
Então as tarefas do template serão adicionadas ao fluxo
E o usuário poderá iniciar seu novo experimento



@EXPERIMENTO
Cenário: C07 - Interromper Execução
Dado que o usuário está na página Meus Projetos
Quando clicar no botão Novo Projeto
Então o sistema deve abrir um modal, com o nome Novo Projeto selecionado
# Quando o usuário limpar o campo nome do projeto
E nomear o projeto com:'TesteExp 4'
E informar a seguinte descrição:'Teste - Interromper Execução'
Quando clicar no botão Criar
Então o novo projeto será criado 
E o usuário será direcionado para a página do projeto
E um novo experimento será criado, nomeado como "Experimento 1"
E os botões acima da tela do fluxo de experimentação estarão desabilitados, exceto o botão Excluir

Quando o usuário selecionar o operador Conjunto de Dados, presente no fluxo de experimento
E no drawer de propriedades selecionar o botão "Importar"
E poderá escolher arquivos .csv e .zip para importar os dados
Então o usuário irá informar o arquivo 'imdb.csv' para importar os dados de entrada

Quando selecionar o Menu Treinamento
E selecionar a tarefa "Classificador AutoML"
Então a Tarefa será adicionada ao fluxo

Quando selecionar a tarefa Classificador AutoML presente no fluxo
E no drawer de propriedades da tarefa selecionar o campo "Atributo Alvo"
E será exibido os atributos do arquivo de entrada
Então o usuário irá selecionar o atributo "label"
E no campo Modo de seleção das features, deixar o campo com o valor default
E no campo Features para incluir-remover no modelo selecionar o atributo "text"
E no campo Features para fazer codificação one-hot selecionar o atributo "is_valid"
E deixar os demais campos com o valor default

Quando o usuário selecionar o botão Executar
E o sistema enviar a seguinte mensagem "Treinamento iniciado!"
Então cada tarefa será sinalizada como "Tarefa Pendente"
E os botões "Salvar como Template" e "Executar" serão desabilitados
E o botão "Interromper" será exibido

Quando selecionar o botão Interromper
Então a mensagem "Interrompendo execução..." deve ser exibida no topo da tela

Quando o processo de interrupção for finalizado
E a mensagem "Treinamento interrompido!" for exibido no topo da tela
Então as tarefas no fluxo de experimento deverão ser sinalizadas como "Tarefa Interrompida"
E ao selecionar as tarefas o usuário poderá editar suas propriedades
E executar o experimento novamente



@EXPERIMENTO
Cenário: C08 - Preparar para Implantação
Dado que o usuário está na página Meus Projetos
Quando selecionar um projeto da lista de Projetos
E esse Projeto possui experimentos associados
Então o usuário será direcionado a página do projeto

Quando selecionar o botão "Preparar para Implantação"
Então o usuário será direcionado a página Fluxos implantados

Quando o usuário voltar para a página do Projeto
Então deverá observar que o botão Preparar para Implantação estará em modo de execução
E quando a implantação for finalizada
Então o botão de implantação será desabilitado



@EXPERIMENTO
Cenário: C09 - Excluir Tarefa e Experimento
Quando selecionar um projeto da lista de Projetos
E esse Projeto possui experimentos associados
Então o usuário será direcionado a página do projeto

Quando selecionar a Tarefa presente no fluxo de experimento
E selecionar o botão Excluir Tarefa
Então o sistema irá abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir essa tarefa?"
Quando o usuário selecionar o botão Sim
Então a tarefa será retirada do fluxo de experimento
E o usuário poderá adicionar outra Tarefa ao fluxo

Quando o usuário selecionar o botão Excluir, ao lado do nome do Experimento
E uma pop-up com a seguinte mensagem "Excluir Experimento?" for exibida
E selecionar o botão Sim
Então o experimento será excluído

Quando o usuário selecionar o botão excluir
E clicar no botão Não
Então o pop-up será fechado 
E o experimento não será excluído

E se o usuário excluir todos os Experimentos do Projeto
Então a página do Projeto ficará vazia

# Aparentemente o XPATH das abas de experimento mudam, a cada experimento criado


 