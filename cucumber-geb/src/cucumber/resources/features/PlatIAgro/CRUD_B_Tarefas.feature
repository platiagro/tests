#language:pt

Funcionalidade: Tarefa na PlatIAgro
Como usuário da plataforma, desejo criar uma nova tarefa para iniciar um projeto.

Contexto: Acessar a página Tarefas na Plataforma
  Dado que o usuário demande a abertura do browser
  E conectar a plataforma PlatIAgro
  Quando acessar a página de Tarefas
  Então a tela inicial da página 'Tarefas' será exibida com êxito

@CRUDTAREFA
Cenário: C01 - Criar Tarefa - Em Branco - Default
 Dado que o usuário selecione o botão Nova Tarefa
 Quando criar tarefa a partir de um template em branco
 Então a plataforma exibirá o seguinte display: 'Tarefa criada com sucesso.'
 E o nome default da tarefa será: 'Tarefa em branco - 1'
 E os seguintes campos estarão presentes para entrada de dados: 'Descrição', 'Categoria', 'Dados de Entrada', 'Dados de Saída', 'Tags de Busca' e 'Documentação'
 E a tarefa criada será adicionada na lista de tarefas de acordo com a ordenação alfabética
 E as informações das tarefas estarão divididas em quatro colunas: 'Nome da Tarefa', 'Descrição', 'Origem' e 'Ação'

@CRUDTAREFA
Cenário: C02- Alterar nome da Tarefa - Cancelar
 Dado que o usuário escolha uma das Tarefas da lista para editar
 E clique no ícone para editar
 E limpar o campo nome
 E renomear a Tarefa: 'Tarefa Teste'
 Quando efetuar o clique no botão Cancelar Edição
 Então o nome da tarefa não deve ser alterado

@CRUDTAREFA
Cenário: C03 - Alterar nome da Tarefa - Efetivar
 Dado que o usuário selecione a Tarefa criada anteriormente
 E acione o clique no ícone para editar
 E limpe o campo nome da tarefa
 E alterar o nome da Tarefa: 'Tarefa Teste'
 Quando confirmar a operação
 Então uma mensagem de sucesso será exibida na tela: 'Alteração realizada com sucesso.'
 E o nome da tarefa alterada será atualizada

@CRUDTAREFA
Cenário: C04 - Alterar a descrição, categoria, dados de entrada e saída, tags de busca e documentação - Tarefa
 Dado que o usuário detalhe uma Tarefa existente
 E altere a descrição com a seguinte informação: 'Teste - Alteração da descrição'
 E insira uma nova categoria: 'Conjunto de dados'
 E em dados de entrada registrar: 'Arquivo .csv com dados tabulares (um atributo por coluna), sem cabeçalho'
 E para dados de saída registrar: 'Conjunto de dados em formato de matriz, com uma amostra por linha'
 E escolha a palavra-chave para a tag de busca: 'TST'
 E adicione a documentação: 'Teste - Adição da documentação'
 Quando clicar fora dos campos descritivos
 Então será exibida na tela uma mensagem de sucesso: 'Alteração realizada com sucesso.'
 E as alterações nos detalhes da tarefa serão efetivados

@CRUDTAREFA_TST
Cenário: C05 - Criar Tarefa - Nome Repetido
 Dado que o usuário clique no botão Nova Tarefa
 E demande a criação da tarefa a partir de um template em branco
 E nomeie a Tarefa com uma designação existente: 'Regressor MLP'
 Quando realizar o clique no botão Salvar
 Então o sistema deverá exibir a mensagem impeditiva: 'Já existe uma tarefa com este nome!'

@CRUDTAREFA
Cenário: C06- Copiar Tarefa
 Dado que o usuário acione o botão Mais, localizado na coluna Ação, de uma das Tarefas na lista
 E um popover seja aberto
 Quando demandar o ato de fazer uma cópia
 Então a plataforma exibirá na página de detalhes a mensagem: 'Tarefa criada com sucesso.'
 E no campo nome da Tarefa estará preenchido com a designação default
 E o valor do campo da descrição será o mesmo da tarefa selecionada para cópia
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