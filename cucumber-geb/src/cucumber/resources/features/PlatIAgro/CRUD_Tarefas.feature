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
Então será apresentado a página "Meus Projetos", com a lista de projetos existentes daquele usuário

  

Cenário: C01 - Lista de Tarefas
Dado que o usuário está na página "Meus Projetos"
Quando selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Então deverá observar que todas as tarefas existentes estarão listadas em ordem alfabética 
E as informações das tarefas estarão divididas em três colunas: Nome da Tarefa, Origem,Descrição e Ação
E se o usuário não possuir nenhuma tarefa existente a página será apresentada em branco


@CRUDTAREFA
Cenário: C02 - Criar Tarefa
Dado que o usuário está na página "Meus Projetos"
Quando selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Quando selecionar o botão Nova Tarefa
E será aberto um modal onde o usuário poderá escolher um exemplo ou um template em branco para criar nova tarefa
E os exemplos de tarefas serão apresentados com uma breve descrição
E o nome default "Nova tarefa" deve estar destacado no campo nome
Quando o usuário selecionar a opção Template em branco
E limpar o campo nome
E nomear a tarefa com: 'Teste Tarefa01'
E informar a seguinte descrição: 'Teste - Funcionalidade: Criar Tarefa'
E clicar no botão Criar Notebooks
Então o modal será resetado e fechado
E tarefa será criada
E o usuário deverá observar que a tarefa criada foi adicionada na lista de tarefas de acordo com a ordenação alfabética
E ao abrir a tarefa deve observar que os botões: "Notebook de experimentação" e "Notebook de pré-implantação" estarão disponiveis 
E ao selecionar esses botões será aberto os Notebooks com o código fonte da tarefa



@CRUDTAREFA
Cenário: C03 - Criar Tarefa - Nome Repetido
Dado que o usuário está na página "Meus Projetos"
Quando selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Quando selecionar o botão Nova Tarefa
E será aberto um modal onde o usuário poderá escolher um exemplo ou um template em branco para criar nova tarefa
E os exemplos de tarefas serão apresentados com uma breve descrição
E o nome default "Nova tarefa" deve estar destacado no campo nome
Então o usuário não deve nomear a tarefa com: 'Teste Tarefa01'
E não deve informar a descrição para a tarefa
Quando clicar no botão Criar Notebooks
Então a operação deve ser cancelada
E o sistema deverá informar que já existe uma tarefa com o nome informado

@CRUDTAREFA
Cenário: C04 - Criar Tarefa Operação: Cancelar
Dado que o usuário está na página "Meus Projetos"
Quando selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Quando selecionar o botão Nova Tarefa
E será aberto um modal onde o usuário poderá escolher um exemplo ou um template em branco para criar nova tarefa
E os exemplos de tarefas serão apresentados com uma breve descrição
E o nome default "Nova Tarefa" deve estar destacado no campo nome
Quando o usuário selecionar a opção Template em branco
E limpar o campo nome
E nomear a tarefa com: 'Teste Tarefa'
E informar a seguinte descrição: 'Teste - Cancelar'
E clicar no botão Cancelar
Então o modal será resetado e fechado
E nenhuma tarefa será criada


@CRUDTAREFA
Cenário: C05- Alterar nome e descrição da Tarefa
Dado que o usuário está na página "Meus Projetos"
Quando selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
E o usuário selecionar a tarefa que deseja editar
Então será aberta a página da tarefa
Quando selecionar o botão editar - ícone lápis
E limpar o campo nome
E nomear a tarefa com:'AltNome Tarefa'
E informar a seguinte descrição: 'Teste - Editar':
E poderá alterar os seguintes campos: Categoria, Dados de Entrada, Dados de Saída e Tags de busca
Quando o usuário selecionar o botão "Alterações Salvas"
Então o sitema apresentará ao usuário todas as alterações salvas daquela tarefa


@CRUDTAREFA
Cenário: C07 - Excluir Tarefa
Dado que o usuário está na página "Meus Projetos"
Quando selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Quando selecionar uma tarefa da lista de tarefas
E na coluna Ação clicar no botão Excluir 
E o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir essa Tarefa?"
E o usuário confirmar a operação clicando no botão Sim
Então a terefa será excluida da lista de tarefas


@CRUDTAREFA
Cenário: C08 - Excluir Tarefa - Cancelar
Dado que o usuário está na página "Meus Projetos"
Quando selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Quando selecionar uma tarefa da lista de tarefas
E na coluna Ação clicar no botão Excluir 
E o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir essa Tarefa?"
E o usuário clicar no botão Não
Então a operação será cancelada 
E nenhuma tarefa será excluída




