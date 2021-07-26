#language:pt

Funcionalidade: Acessar a página Tarefas na plataforma PlatIAgro
 Eu como usuário desejo ter acesso a página Tarefas na plataforma PtatIAgro

 @startPlatIAgro
 Cenário: Página Tarefas na plataforma PlatIAgro acessada com sucesso
  Dado que o usuário demande a abertura do browser
  E conectar a plataforma PlatIAgro
  Quando acessar a página de Tarefas
  Então a tela inicial da página 'Tarefas' será exibida com êxito