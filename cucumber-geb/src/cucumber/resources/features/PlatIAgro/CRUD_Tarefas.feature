#language:pt

Funcionalidade: Criar Tarefa na PlatIAgro
Como usuário da plataforma, desejo criar uma nova tarefa para iniciar um projeto.



Contexto: Acessar Plataforma
Dado que o usuário acessa a Plataforma PlatIAgro
E está na tela inicial



@CRUDTAREFA
Cenário: C01 - Lista de Tarefas
Dado que o usuário está na página Tarefas
#E deverá observar que todas as tarefas existentes estarão listadas em ordem alfabética
Então as informações das tarefas estarão divididas em três colunas: Nome da Tarefa, Origem,Descrição e Ação



@CRUDTAREFA1
Cenário: C02 - Criar Tarefa
Dado que o usuário está na página Tarefas
E selecionar o botão Nova Tarefa
E será aberto um modal onde o usuário poderá escolher um exemplo ou um template em branco para criar nova tarefa
#E os exemplos de tarefas serão apresentados com uma breve descrição
E o nome default Nova tarefa deve estar destacado no campo nome
E o Template em branco também deve estar definido como default
Quando o usuário limpar o campo nome da tarefa
E nomear a Tarefa: 'Tarefa-TesteJ'
E inserir a Descrição: 'Teste - Funcionalidade: Criar Tarefa'
E clicar no botão Criar Notebooks
E o modal será resetado e fechado
Então a tarefa será criada
E o usuário deverá observar que a tarefa criada foi adicionada na lista de tarefas de acordo com a ordenação alfabética₢
#E ao abrir a tarefa deve observar que os botões: "Notebook de experimentação" e "Notebook de pré-implantação" estarão disponiveis
#E ao selecionar esses botões será aberto os Notebooks com o código fonte da tarefa



@CRUDTAREFA
Cenário: C03 - Criar Tarefa - Nome Repetido
Dado que o usuário está na página Tarefas
E selecionar o botão Nova Tarefa
E será aberto um modal onde o usuário poderá escolher um exemplo ou um template em branco para criar nova tarefa
#E os exemplos de tarefas serão apresentados com uma breve descrição
E o nome default Nova tarefa deve estar destacado no campo nome
E o Template em branco também deve estar definido como default
E o usuário limpar o campo nome da tarefa
E nomear a Tarefa: 'Regressor MLP'
E inserir a Descrição: 'Teste - Nome Repetido'
Quando clicar no botão Criar Notebooks
E a operação deve ser cancelada
Então o sistema deverá informar que já existe uma tarefa com aquele nome
E nenhuma tarefa deve ser criada



@CRUDTAREFA
Cenário: C04 - Criar Tarefa Operação: Cancelar
Dado que o usuário está na página Tarefas
E selecionar o botão Nova Tarefa
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
E selecionar o botão Nova Tarefa
E será aberto um modal onde o usuário poderá escolher um exemplo ou um template em branco para criar nova tarefa
E o nome default Nova tarefa deve estar destacado no campo nome
E o Template em branco também deve estar definido como default
E o usuário limpar o campo nome da tarefa
E nomear a Tarefa: 'AltNome Tarefa'
E inserir a Descrição: 'Teste - Editar'
E clicar no botão Criar Notebooks
E o modal será resetado e fechado
E tarefa será criada
E o usuário deverá observar que a tarefa criada foi adicionada a lista de Tarefas
Quando selecionar a Tarefa criada
E será aberto um modal onde o usuário poderá editar o nome e a descrição da Tarefa
E limpar o campo nome
E informar um novo nome para a Tarefa: 'Tarefa_Teste2'
E uma nova descrição: 'Teste - Alterar Nome e Descrição'
E confirmar a operação
E o modal será fechado
E uma mensagem de sucesso será exibida na tela
Então o usuário poderá observar que o nome e descrição da tarefa foram editados



@CRUDTAREFA
Cenário: C06- Alterar nome e descrição da Tarefa - Cancelar
Dado que o usuário está na página Tarefas
E escolher uma das Tarefas da lista de tarefas para editar
Quando limpar o campo nome
E nomear a Tarefa: 'Tarefa_Teste 3'
E inserir a Descrição: 'Alterar Nome e Descrição - CANCELAR'
E clicar no botão Cancelar
Então o modal será fechado
E o nome e descrição da Tarefa não devem ser alterados



@CRUDTAREFA
Cenário: C07- Copiar Tarefa
Dado que o usuário está na página Tarefas
E escolher uma das Tarefas da lista de tarefas para Copiar
E selecionar o botão Fazer uma Cópia, localizado na coluna Ação - Mais
E um modal será aberto
E o campo template e descrição serão os mesmos da tarefa selecionada para cópia
E o campo nome estará preenchido com o nome da tarefa seguido por "cópia"
Quando o usuário selecionar o botão Criar Notebooks
Então a cópia da tarefa será criada



@CRUDTAREFA
Esquema do Cenário:C08 - Filtrar Tarefa - Pesquisar nome
Dado que o usuário está na página Tarefas
E deseja pesquisar um Tarefa pelo nome
E selecionar o icone de pesquisa ao lado da coluna Nome da Tarefa
E será aberto um modal
Quando o usuário inserir o nome da tarefa: '<task>'
E clicar no botão Search
Então o sistema deve apresentar a Tarefa que possui o nome inserido no campo de pesquisa
E se não houver nenhuma Tarefa com o nome informado o sitema deve apresentar a página em branco
E o usuário deverá selecionar o botão "Reset" para a lista de Tarefas ser apresentada novamente

Exemplos:
| task                 |
| Scaler Robusto       |
| Simulated Annealing  |
| Feature Tools        |
| Transformation Graph |




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




