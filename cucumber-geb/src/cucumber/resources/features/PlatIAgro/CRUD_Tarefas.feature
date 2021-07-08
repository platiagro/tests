#language:pt

Funcionalidade: Criar Tarefa na PlatIAgro
Como usuário da plataforma, desejo criar uma nova tarefa para iniciar um projeto.

Contexto: Acessar a página Tarefas na Plataforma
  Dado que o usuário demande a abertura do browser
  E conectar a plataforma PlatIAgro
  Quando acessar a página de Tarefas
  Então a tela inicial da página 'Tarefas' será exibida com êxito

@CRUDTAREFA
Cenário: C01 - Criar Tarefa
 Dado que o usuário selecione o botão Nova Tarefa
 E seja aberto um modal onde o Template em branco deve estar definido como default
 E haverá a opção de escolher um exemplo
 E nomear a Tarefa com o nome inicial de: 'Tarefa - Teste'
 E inserir a Descrição: 'Teste - Funcionalidade: Criar Tarefa'
 Quando clicar no botão Criar Notebooks
 Então o sistema exibirá a seguinte mensagem: 'Tarefa criada com sucesso.'
 E o modal será resetado e fechado
 E irá abrir uma nova tela do JupyterLab: 'Aguarde, o JupyterLab está sendo preparado...'
 E a tarefa criada será adicionada na lista de tarefas de acordo com a ordenação alfabética
 E as informações das tarefas estarão divididas em quatro colunas: 'Nome da Tarefa', 'Descrição', 'Origem' e 'Ação'

@CRUDTAREFA
Cenário: C02 - Criar Tarefa - Nome Repetido
 Dado que o usuário clique no botão Nova Tarefa
 E abra um modal para escolher um exemplo ou um template em branco para criar nova tarefa
 E nomear a Tarefa: 'Regressor MLP'
 E inserir a seguinte descrição: 'Teste - Nome Repetido'
 Quando realizar o clique no botão Criar Notebooks
 Então o sistema deverá exibir a mensagem impeditiva: 'Já existe uma tarefa com este nome!'

@CRUDTAREFA
Cenário: C03 - Criar Tarefa Operação: Cancelar
Dado que o usuário acione o botão Nova Tarefa
E um modal seja aberto onde o Template em branco deve estar definido como default
E entrar com o nome para a Tarefa: 'Tarefa Teste'
E inserir a descrição: 'Teste - Operação: Cancelar'
Quando clicar no botão Cancelar
Então o sistema fará com que o modal seja resetado e fechado
E nenhuma tarefa será criada

@CRUDTAREFA
Cenário: C04- Alterar nome e descrição da Tarefa - Cancelar
Dado que o usuário escolha uma das Tarefas da lista para editar
E limpar o campo nome
E renomear a Tarefa: 'Tarefa Teste'
E inserir uma nova descrição: 'Alterar Nome e Descrição - CANCELAR'
Quando efetuar o clique no botão Cancelar
Então o sistema deve fechar modal
E o nome e a descrição da tarefa não devem ser alterados

@CRUDTAREFA
Cenário: C05 - Alterar nome e descrição da Tarefa
 Dado que o usuário selecione a Tarefa criada anteriormente
 E um modal seja aberto, com o atual nome da tarefa selecionada
 E limpe o campo nome da tarefa
 E alterar o nome da Tarefa, acrescentando ao final: 'Alter'
 E informar uma nova descrição: 'Teste - Alterar Nome e Descrição'
 Quando confirmar a operação
 Então o modal será fechado
 E uma mensagem de sucesso será exibida na tela: 'Alteração realizada com sucesso.'
 E o nome e a descrição da tarefa alterados serão atualizados

@CRUDTAREFA
Cenário: C06- Copiar Tarefa
 Dado que o usuário faça uma Cópia, de uma das Tarefas na lista, localizado na coluna Ação - Mais
 E será aberto um modal
 E os valores nos campos template e descrição serão os mesmos da tarefa selecionada para cópia
 E no campo nome estará preenchido com o nome da tarefa seguido por 'cópia'
 Quando o usuário selecionar o botão Criar Notebooks
 Então terá a cópia da 'Tarefa criada com sucesso.'
 E abrirá uma nova tela do JupyterLab: 'Aguarde, o JupyterLab está sendo preparado...'
 E a cópia da tarefa criada será adicionada na lista de tarefas de acordo com a ordenação alfabética

@CRUDTAREFA
Cenário: C07 - Filtrar Tarefa - Pesquisar nome
 Dado que o usuário selecione o ícone de pesquisa ao lado da coluna Nome da Tarefa
 E o modal para pesquisa seja aberto
 E insira o nome da tarefa existente
 Quando clicar no botão Search
 Então o sistema deve apresentar a Tarefa que possui o nome inserido no campo de pesquisa

@CRUDTAREFA
Cenário: C08 - Filtrar Tarefa - Pesquisar nome inexistente
 Dado que o usuário acione o ícone de pesquisa ao lado da coluna Nome da Tarefa
 E o modal para pesquisa tenha a sua abertura realizada
 E insira um nome de uma tarefa inexistente
 Quando efetuar o clique no botão Search
 Então o sitema deve apresentar a página em branco: 'Não há dados'
 E deverá selecionar o botão Reset para a lista de Tarefas ser apresentada novamente

@CRUDTAREFA
 Cenário: C09 - Excluir Tarefa - Cancelar
 Dado que o usuário, na coluna Ação da lista, clique em Excluir uma Tarefa
 E o sistema deve abrir uma pop-up com a seguinte mensagem: 'Você tem certeza que deseja excluir essa tarefa?'
 Quando selecionar o botão Não
 Então a operação será cancelada
 E nenhuma tarefa será excluída

@CRUDTAREFA
 Cenário: C10 - Excluir Tarefa
 Dado que o usuário clique em Excluir, na coluna Ação, de uma Tarefa constante na lista
 E o sistema deve abrir uma pop-up exibindo a mensagem: 'Você tem certeza que deseja excluir essa tarefa?'
 Quando o usuário confirmar a operação
 Então a tarefa será excluída da lista

#@CRUDTAREFA
 #Cenário: C11 - Excluir Tarefa - Relacionada a um Experimento
 #Dado que o usuário selecione uma Tarefa da lista que esteja relacionada a um projeto
 #E na coluna Ação clicar nos botões Mais e Excluir
 #E o sistema apresentar uma pop-up com a seguinte mensagem 'Você tem certeza que deseja excluir essa tarefa?'
 #Quando for confirmada a operação de exclusão
 #Então a operação será cancelada
 #E o sistema deverá informar que aquela Tarefa está em uso