#language:pt

Funcionalidade: Login na PlatIAgro
Como usuário da plataforma, desejo efetuar o login para validar as credenciais de conexão.

@LOGIN
Cenário: C01 - Login com sucesso
 Dado que o usuário inquira a abertura do browser
 E acesse a plataforma PlatIAgro
 E seja apresentado um painel de 'Login'
 E preecha o campo Usuário com a credencial: 'platiagro'
 E também preencher o campo Senha informando: 'platiagro1234'
 Quando realizar o clique no botão Entrar
 Então a tela inicial da plataforma será exibida com sucesso

@LOGIN
Cenário: C02 - Logout com sucesso
 Dado que o usuário esteja logado na plataforma
 E clicar do dropdown do nome de usuário
 Quando realizar o clique no item Sair
 Então a plataforma irá retornar para o painel de 'Login'

@LOGIN
Cenário: C03 - Login com impedimento
 Dado que o usuário demande que o browser seja aberto
 E realize o acesso na plataforma PlatIAgro
 Quando realizar o clique no botão Entrar sem preencher qualquer credencial do usuário
 Então a plataforma continuará exibindo o painel de 'Login'

@LOGIN
Cenário: C04 - Login com erro
 Dado que o usuário efetue a abertura do browser
 E ingresse na plataforma PlatIAgro
 E seja exibido um painel de 'Login'
 E preecha os campos de autenticação com credenciais inexistentes
 Quando ocorrer o clique no botão Entrar
 Então será exibido pela plataforma uma mensagem de login com erro: 'Usuário ou senha inválidos.'