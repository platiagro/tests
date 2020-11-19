#language:pt

Funcionalidade: Apresentação dos resultados até o momento

Contexto: Acessar Plataforma
Dado que o usuário acessa a plataforma PlatIAgro
E está na tela inicial


@AP
Cenário: C01 - Projeto 
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
E o usuário deverá retornar para a página Meus Projetos 

Dado que o usuário está na página Meus Projetos
E deseja pesquisar um projeto pelo nome 
Quando selecionar o icone de pesquisa ao lado da coluna Nome do Projeto
Então será aberto um modal
Quando o usuário inserir:'Teste'
E selecionar o botão Search
Então o sistema deve apresentar o projeto que possui o nome inserido no campo de pesquisa
E se não houver nenhum projeto com o nome informado o sitema deve apresentar a página em branco

#Criar Tarefa
Dado que o usuário está na página Tarefas
Quando selecionar o botão Nova Tarefa
E será aberto um modal onde o usuário poderá escolher um exemplo ou um template em branco para criar nova tarefa
#E os exemplos de tarefas serão apresentados com uma breve descrição
E o nome default Nova tarefa deve estar destacado no campo nome
E o Template em branco também deve estar definido como default
Quando o usuário limpar o campo nome da tarefa
E nomear a Tarefa: 'Tarefa-Teste'
E inserir a Descrição: 'Teste - Funcionalidade: Criar Tarefa'
E clicar no botão Criar Notebooks
Então o modal será resetado e fechado
E a tarefa será criada
E o usuário deverá observar que a tarefa criada foi adicionada na lista de tarefas de acordo com a ordenação alfabética
Dado que o usuário está na página Tarefas
E escolher uma das Tarefas da lista de tarefas para Copiar
Quando selecionar o botão Fazer uma Cópia, localizado na coluna Ação - Mais
Então um modal será aberto
E o campo template e descrição serão os mesmos da tarefa selecionada para cópia
E o campo nome estará preenchido com o nome da tarefa seguido por "cópia"
Quando o usuário selecionar o botão Criar Notebooks
Então a cópia da tarefa será criada
Dado que o usuário está na página Tarefas
E seleciona uma Tarefa da lista de tarefas
E na coluna Ação clicar no botão Excluir 
Quando o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir essa Tarefa?"
E o usuário confirmar a operação
Então a terefa será excluida da lista

@AP3
Cenário: C03 - Experimento
Dado que o usuário está na página Meus Projetos
Quando selecionar um projeto da lista de Projetos
Então o usuário será direcionado a página do projeto
Quando selecionar o card Experimento
Dado que o projeto contém tarefas no fluxo
Quando o usuário selecionar a Tarefa para puxar o conector 
E conectar uma tarefa na outra

Quando selecionar o operador novamente
E no drawer de propriedades selecionar o botão Importar
Então o usuário irá informar o arquivo 'Iris.csv' para importar os dados de entrada
Quando selecionar o botão Visualizar Dados
E a tela de visualização de dados for aberta
Quando selecionar a tarefa Regressão Logística presente no fluxo
 E no drawer de propriedades da tarefa selecionar o campo Atributo Alvo
 E será exibido os atributos do arquivo de entrada
 Então o usuário irá selecionar o atributo Species
 E no campo Modo de seleção das features, o usuário irá selecionar a opção Incluir
 E no campo Features para incluir-remover no modelo selecionar o atributo SepalLengthCm
 E no campo Features para fazer codificação ordinal selecionar o atributo PetalWidthCm
 Então o usuário não irá alterar os demais campos da Tarefa
 Quando o usuário selecionar o botão Executar
 E o sistema enviar a seguinte mensagem "Treinamento iniciado!"
 Então cada tarefa será sinalizada como "Tarefa Pendente"
 Quando a operação for concluída com sucesso
 Então cada tarefa será sinalizada como "Tarefa executada com sucesso"
 E os botões acima do fluxo de experimento serão habilitados
 Quando o usuário selecionar a tarefa "Regressão Logística"
 E selecionar o botão Visualizar Resultados
 Então um modal será aberto 
 E o usuário poderá visualizar os gráficos do Resultados, o valor das Métricas e dos Parâmetros 

 Quando selecionar a aba de um experimento
 E clicar no botão direito
 E selecionar a opção "Renomear"
 Então um modal será aberto 
 E o usuário deverá limpar o campo 
 E inserir um novo nome para o experimento: 'AltName_Exp'
 Quando clicar no botão OK
 Então o nome do experimento será alterado 
 E o modal será resetado

 Quando selecionar o botão "Preparar para Implantação"
 Então o usuário será direcionado a página Fluxos implantados
 Quando o usuário voltar para a página do Projeto
 Então deverá observar que o botão Preparar para Implantação estará em modo de execução
 E quando a implantação for finalizada
 Então o botão de implantação será desabilitado


 Dado que o usuário está na página Meus Projetos
 Quando selecionar um projeto com N Experimentos
 Então o usuário será direcionado a página do projeto
 Quando selecionar o botão Comparar Resultados
 E o sistema abrir a tela "Comparar resultados"
 E selecionar o botão Adicionar Resultado
 E selecionar os experimentos que deseja comparar
 Então deverá ser apresentado o histórico de execução de cada experimento selecionado
 Quando o usuário selecionar uma das opções do histórico de execução
 E selecionar uma tarefa
 Então será exibido os resultados, as métricas e os parâmetros da tarefa selecionada



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

