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
E as informações das tarefas estarão divididas em três colunas: Nome da Tarefa, Descrição e Ação


@CRUDTAREFA
Cenário: C02 - Criar Tarefa
Dado que o usuário está na página "Meus Projetos"
Quando selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Quando selecionar o botão Nova Tarefa
E será aberto um modal com exemplos de tarefas e template em branco para a criação
E o nome default "AutoML Classifier" deve estar destacado no campo nome
Quando o usuário selecionar a opção Template em branco
E limpar o campo nome
E nomear a tarefa com: 'Teste Tarefa01'
E informar a seguinte descrição: 'Teste - Funcionalidade: Criar Tarefa'
E clicar no botão Criar Notebooks
Então o modal será resetado e fechado
E tarefa será criada
E o usuário deverá observar que a tarefa criada foi adicionada na lista de tarefas de acordo com a ordenação alfabética


@CRUDTAREFA
Cenário: C03 - Criar Tarefa - Nome Repetido
Dado que o usuário está na página "Meus Projetos"
Quando selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Quando selecionar o botão Nova Tarefa
E será aberto um modal com exemplos de tarefas e template em branco para a criação
E o nome default "AutoML Classifier" deve estar destacado no campo nome
Então o usuário não deve alterar o nome da tarefa
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
E será aberto um modal com exemplos de tarefas e template em branco para a criação
E o nome default "AutoML Classifier" deve estar destacado no campo nome
Quando o usuário selecionar a opção Template em branco
E limpar o campo nome
E nomear a tarefa com: 'Teste Tarefa'
E informar a seguinte descrição: 'Teste - Cancelar'
E clicar no botão Cancelar
Então o modal será resetado e fechado
E nenhuma tarefa será criada


@CRUDTAREFA
Cenário: C05 - Editar Tarefa
Dado que o usuário está na página "Meus Projetos"
Quando selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
Quando selecionar a tarefa que deseja editar na lista de tarefas 
Então será aberto uma nova aba no navegador contento os Notebooks da tarefa selecionada para edição


@CRUDTAREFA
Cenário: C06 - Alterar nome e descrição da Tarefa
Dado que o usuário está na página "Meus Projetos"
Quando selecionar o menu Tarefas
E o sistema o direcionar para a página de Tarefas
E clicar no botão Alterar Nome e Descrição
Então será aberto um modal com o nome atual da tarefa em destaque
Quando o usuário limpar o campo nome
E nomear a tarefa com:'AltNome Tarefa'
E informar a seguinte descrição: 'Teste - Editar':
Quando selecionar o botão Confirmar
Então o modal será fechado
E o nome e descrição da tarefa serão atualizados
E o usuário deverá observar que a tarefa atualizada está posicionada corretamente na lista de tarefas de acordo com a ordenação alfabética



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




