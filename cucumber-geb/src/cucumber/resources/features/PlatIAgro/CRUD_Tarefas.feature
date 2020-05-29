#language:pt

Funcionalidade: Criar Tarefa na PlatIAgro
Como usuário da plataforma, desejo criar uma nova tarefa para iniciar um projeto.


# Data: 06/05/2020
# Execução dos cenários realizado manualmente e automaticamente

Contexto: Acessar Plataforma
Dado que o usuário acessa a plataforma PlatIAgro
E está na tela de longin
Quando inserir o usuário:'user'
E inserir a senha:'000000'
E confirmar
Então será presentado a página inicial da plataforma

  

Cenário: C01 - Lista de Tarefas
Dado que o usuário está na página inicial da plataforma
Quando selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Então deverá observar que todas as tarefas existentes estarão listadas
E as informações das tarefas estarão divididas em três colunas: Nome da Tarefa, Descrição e Ação


@CRUDTAREFA
Cenário: C02 - Criar Tarefa
Dado que o usuário está na página inicial da plataforma
E selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Quando selecionar o botão Nova Tarefa
E o sistema abrir um modal com exemplos de tarefas e template em branco para a criação
E o usuário selecionar a opção Template em branco
E nomear a tarefa com: 'Teste Tarefa01'
Quando selecionar o botão Criar Notebooks
Então será aberto uma nova aba no navegador contento os Notebooks de implantação e os de treinamento



@CRUDTAREFA
Cenário: C03 - Editar Tarefa
Dado que o usuário está na página inicial da plataforma
E selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Quando selecionar a tarefa que deseja editar na lista de tarefas 
Então será aberto uma nova aba no navegador contento os Notebooks da tarefa selecionada para edição


@CRUDTAREFA
Cenário: C04 - Alterar nome e descrição da Tarefa
Dado que o usuário está na página inicial da plataforma
E selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
E clicar no botão Alterar Nome e Descrição
Então será aberto um modal 
E o usuário irá alterar o nome da tarefa para:'AltNome Tarefa'
E a descrição para:'Teste Alterar'
Quando selecionar o botão Confirmar
Então a alteração do nome e descrição da tarefa será executada


@CRUDTAREFA
Cenário: C05 - Excluir Tarefa
Dado que o usuário está na página inicial da plataforma
E selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Quando selecionar uma tarefa da lista de tarefas
E clicar no botão Excluir
E o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir essa Tarefa?"
E o usuário confirmar a operação clicando no botão Sim
Então a terefa será excluida da lista de tarefas







