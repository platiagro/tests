#language:pt

Funcionalidade: Criar Tarefa na PlatIAgro
Como usuário da plataforma, desejo criar uma nova tarefa para iniciar um projeto.


# Data: 06/05/2020
# Execução dos cenários realizado manualmente e automaticamente

Contexto: Acessar Plataforma
Dado que o usuário acessa a plataforma PlatIAgro
E está na tela inicial

# E está na tela de longin
# Quando inserir o usuário:'user'
# E inserir a senha:'000000'
# E confirmar
# Então será apresentado a página "Meus Projetos", com a lista de projetos existentes daquele usuário

  
@CRUDTAREFA
Cenário: C01 - Lista de Tarefas
Dado que o usuário está na página Tarefas
Então deverá observar que todas as tarefas existentes estarão listadas em ordem alfabética 
E as informações das tarefas estarão divididas em três colunas: Nome da Tarefa, Origem,Descrição e Ação


@CRUDTAREFA
Cenário: C02 - Criar Tarefa
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
#E ao abrir a tarefa deve observar que os botões: "Notebook de experimentação" e "Notebook de pré-implantação" estarão disponiveis 
#E ao selecionar esses botões será aberto os Notebooks com o código fonte da tarefa



@CRUDTAREFA
Cenário: C03 - Criar Tarefa - Nome Repetido
Dado que o usuário está na página Tarefas
Quando selecionar o botão Nova Tarefa
E será aberto um modal onde o usuário poderá escolher um exemplo ou um template em branco para criar nova tarefa
#E os exemplos de tarefas serão apresentados com uma breve descrição
E o nome default Nova tarefa deve estar destacado no campo nome
E o Template em branco também deve estar definido como default
Quando o usuário limpar o campo nome da tarefa
E nomear a Tarefa: 'Regressor MLP'
E inserir a Descrição: 'Teste - Nome Repetido'
Quando clicar no botão Criar Notebooks
Então a operação deve ser cancelada
E o sistema deverá informar que já existe uma tarefa com aquele nome
E nenhuma tarefa deve ser criada


@CRUDTAREFA
Cenário: C04 - Criar Tarefa Operação: Cancelar
Dado que o usuário está na página Tarefas
Quando selecionar o botão Nova Tarefa
E será aberto um modal onde o usuário poderá escolher um exemplo ou um template em branco para criar nova tarefa
#E os exemplos de tarefas serão apresentados com uma breve descrição
E o nome default Nova tarefa deve estar destacado no campo nome
E o Template em branco também deve estar definido como default
Quando o usuário limpar o campo nome da tarefa
E nomear a Tarefa: 'Tarefa Teste'
E inserir a Descrição: 'Teste - Operação: Cancelar'
E clicar no botão Cancelar
Então o modal será resetado e fechado
E nenhuma tarefa será criada


@CRUDTAREFA
Cenário: C05- Alterar nome e descrição da Tarefa
Dado que o usuário está na página Tarefas
Quando selecionar o botão Nova Tarefa
E será aberto um modal onde o usuário poderá escolher um exemplo ou um template em branco para criar nova tarefa
E o nome default Nova tarefa deve estar destacado no campo nome
E o Template em branco também deve estar definido como default
Quando o usuário limpar o campo nome da tarefa
E nomear a Tarefa: 'AltNome Tarefa'
E inserir a Descrição: 'Teste - Editar'
E clicar no botão Criar Notebooks
Então o modal será resetado e fechado
E tarefa será criada
E o usuário deverá observar que a tarefa criada foi adicionada a lista de Tarefas

Quando selecionar a Tarefa criada
Então será aberto um modal onde o usuário poderá editar o nome e a descrição da Tarefa
Quando limpar o campo nome
E informar um novo nome para a Tarefa: 'Tarefa_Teste2'
E uma nova descrição: 'Teste - Alterar Nome e Descrição'
E confirmar a operação
Então o modal será fechado
E uma mensagem de sucesso será exibida na tela
E o usuário poderá observar que o nome e descrição da tarefa foram editados


@CRUDTAREFA
Cenário: C06- Alterar nome e descrição da Tarefa - Cancelar
Dado que o usuário está na página Tarefas
E escolhe uma das Tarefas da lista de tarefas para editar
Quando limpar o campo nome
E nomear a Tarefa: 'Tarefa_Teste 3'
E inserir a Descrição: 'Alterar Nome e Descrição - CANCELAR'
E clicar no botão Cancelar
Então o modal será fechado
E o nome e descrição da Tarefa não devem ser alterados


@CRUDTAREFA
Esquema do Cenário:C07 - Filtrar Projeto - Pesquisar nome
Dado que o usuário está na página Tarefas
E deseja pesquisar um Tarefa pelo nome 
Quando selecionar o icone de pesquisa ao lado da coluna Nome da Tarefa
Então será aberto um modal
Quando o usuário inserir o nome da tarefa: '<taskname>'
E clicar no botão Search
Então o sistema deve apresentar a Tarefa que possui o nome inserido no campo de pesquisa
E se não houver nenhum projeto com o nome informado o sitema deve apresentar a página em branco

Exemplos:
|taskname           |
|Scaler Robusto     |
|Simulated Annealing|
|Feature Tools      |


@CRUDTAREFA
Esquema do Cenário:C08 - Filtrar Projeto - Pesquisar nome - Resetar
Dado que o usuário está na página Tarefas
E deseja pesquisar um Tarefa pelo nome 
Quando selecionar o icone de pesquisa ao lado da coluna Nome da Tarefa
Então será aberto um modal
Quando o usuário inserir: '<taskname>'
E selecionar o botão Reset
Então o sistema deve cancelar a operação
E o modal deve ser fechado

Exemplos:
|taskname           |
|Classificador MLP  |
|Análise Descritiva |
|Feature Tools      |



@CRUDTAREFA
Cenário: C09 - Excluir Tarefa
Dado que o usuário está na página Tarefas
E seleciona uma Tarefa da lista de tarefas
E na coluna Ação clicar no botão Excluir 
Quando o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir essa Tarefa?"
E o usuário confirmar a operação
Então a terefa será excluida da lista


@CRUDTAREFA
Cenário: C10 - Excluir Tarefa - Cancelar
Dado que o usuário está na página Tarefas
E seleciona uma Tarefa da lista de tarefas
E na coluna Ação clicar no botão Excluir 
Quando o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir essa Tarefa?"
E selecionar o botão Não
Então a operação será cancelada 
E nenhuma tarefa será excluída


@CRUDTAREFA
Cenário: C11 - Excluir Tarefa - Relacionada a um Experimento
Dado que o usuário está na página Tarefas
E seleciona uma Tarefa da lista que esteja relacionada a um projeto
E na coluna Ação clicar nos botões Mais e Excluir 
Quando o sistema abrir uma pop-up com a seguinte mensagem "Você tem certez  a que deseja excluir essa Tarefa?"
E o usuário confirmar a operação
Então a operação será cancelada 
E o sistema deverá informar que aquela Tarefa está em uso




