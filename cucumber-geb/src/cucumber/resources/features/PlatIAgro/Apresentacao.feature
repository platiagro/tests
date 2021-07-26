#language:pt

Funcionalidade: Apresentação dos resultados até o momento

Contexto: Acessar Plataforma
Dado que o usuário acessa a Plataforma PlatIAgro
E está na tela inicial


@AP1
Cenário: C01 - Projeto
Dado que o usuário está na página Meus Projetos
Quando clicar no botão Novo Projeto
Então o sistema deve abrir um modal, com o nome Novo Projeto selecionado
# Quando o usuário limpar o campo nome do projeto
E nomear o projeto com:'Projeto'
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
E nomear o projeto com:'Projeto'
E informar a seguinte descrição:'Projeto'
E clicar no botão Salvar
Então o nome e a descrição do projeto serão atualizados
E o usuário deverá retornar para a página Meus Projetos
Dado que o usuário está na página Meus Projetos
E deseja pesquisar um projeto pelo nome
Quando selecionar o icone de pesquisa ao lado da coluna Nome do Projeto
Então será aberto um modal
Quando o usuário inserir:'Projeto'
E selecionar o botão Search
Então o sistema deve apresentar o projeto que possui o nome inserido no campo de pesquisa
E se não houver nenhum projeto com o nome informado o sitema deve apresentar a página em branco


@AP
Cenário: C02 - Criar Tarefa
Dado que o usuário está na página Tarefas
Quando selecionar o botão Nova Tarefa
E será aberto um modal onde o usuário poderá escolher um exemplo ou um template em branco para criar nova tarefa
E o nome default Nova tarefa deve estar destacado no campo nome
E o Template em branco também deve estar definido como default
Quando o usuário limpar o campo nome da tarefa
E nomear a Tarefa: 'Tarefa-Teste1'
E inserir a Descrição: 'Teste - Funcionalidade: Criar Tarefa'
E clicar no botão Criar Notebooks
Então o modal será resetado e fechado
E a tarefa será criada
E o usuário deverá observar que a tarefa criada foi adicionada na lista de tarefas de acordo com a ordenação alfabética

@AP
Cenário: C07- Copiar Tarefa
Dado que o usuário está na página Tarefas
E escolher uma das Tarefas da lista de tarefas para Copiar
Quando selecionar o botão Fazer uma Cópia, localizado na coluna Ação - Mais
Então um modal será aberto
E o campo template e descrição serão os mesmos da tarefa selecionada para cópia
E o campo nome estará preenchido com o nome da tarefa seguido por "cópia"
Quando o usuário selecionar o botão Criar Notebooks
Então a cópia da tarefa será criada

@AP
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


@AP
Cenário: C05 - Duplicar Experimento
Dado que o usuário está na página Meus Projetos
Quando selecionar um projeto da lista
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
