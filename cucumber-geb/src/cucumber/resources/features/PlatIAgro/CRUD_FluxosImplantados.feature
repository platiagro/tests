#language:pt

Funcionalidade: Implatar Fluxo de Experimento na PlatIAgro
Como usuário da plataforma, desejo preparar para implantação um Experimento já executado.


# Data: 03/11/2020
# Execução dos cenários realizado manualmente e automaticamente


Contexto: Acessar Plataforma
 Dado que o usuário acessa a plataforma PlatIAgro
 E está na tela inicial
# E está na tela de longin
# Quando inserir o usuário:'user'
# E inserir a senha:'000000'
# E confirmar
# Então será apresentado a página "Meus Projetos", com a lista de projetos existentes daquele usuário


@F
Cenário: C01 - Praparar para Implantação - Testar Fluxo arquivo csv
 Dado que o usuário está na página Meus Projetos
 Quando selecionar um projeto
 Então o usuário será direcionado a página do projeto
 E deverá observar que o projeto possuí Experimentos executados
 E esses experimentos possuem arquivo Iris.csv
 Quando selecionar o botão "Preparar para Implantação"
 Então o usuário será direcionado a página Fluxos implantados
 E a lista de Fluxos Implantados ficará visível
 E o nome da implantação deve conter o nome do projeto e do experimento do fluxo implantado

 Quando a implantação for finalizada 
 E o status definido com Succeeded
 E o usuário selecionar o botão Testar o fluxo
 E selecionar um arquivo csv
 Então um modal será aberto 
 E os dados do arquivo serão apresentados 

 E para fazer o download do resultado, o usuário deverá selecionar o botão Fazer Download
 Então um arquivo do resultado será baixado
 E para copiar os resultados, o usuário deverá selecionar o botão Cópia
 Então uma mensagem de sucesso será exibido na tela

 Quando o arquivo selecionado não for compatível com o fluxo implantado
 Então será aberto o modal com uma mensagem de erro
 E o usuário poderá acesar o log para ter  mais detalhes sobre o erro


@FLUXOIMP
Cenário: C02 - Praparar para Implantação - Testar Fluxo - Imagem
 Dado que o usuário está na página Meus Projetos
 Quando selecionar um projeto
 Então o usuário será direcionado a página do projeto
 E deverá observar que o projeto possuí Experimentos executados
 E esses experimentos possuem Tarefa para testar arquivo png
 Quando selecionar o botão "Preparar para Implantação"
 Então o usuário será direcionado a página Fluxos implantados
 E a lista de Fluxos Implantados ficará visível
 E o nome da implantação deve conter o nome do projeto e do experimento do fluxo implantado

 Quando a implantação for finalizada 
 E o status definido com Succeeded
 E o usuário selecionar o botão Testar o fluxo
 E selecionar um arquivo jpg, jpeg ou png
 Então um modal será aberto 
 E a imagem selecionada será exibida


@FLUXOIMP
Cenário: C03 - Fluxos Implantados - Deletar Fluxo
 Dado que o usuário está na página Fluxos Implantados
 E deseja deletar um dos fluxos implantados presente na lista
 Quando selecionar o botão Deletar, localizado na coluna Ação
 Então um popover com a seguinte mensagem será exibido "Você tem certeza que deseja excluir essa implantação?"
 Quando o usuário confirmar a operação, a implantação será deletada 
 E o botão Preparar para a implantação será habilitado novamente na página do experimento

 Quando o usuário optar por não excluir a implantação
 Então o popover será resetado 
 E o botão Preparar para a implantação continuará desabilitado na página do experimento



@FLUXOIMP
Cenário: C04 - Fluxos Implantados - Visualizar Logs
 Dado que o usuário está na página Fluxos Implantados
 E deseja visualizar os logs da implantação
 Quando selecionar o botão Logs, localizado na coluna Ação
 Então será aberto a tela Logs 
 E as informações estarão divididas em três colunas: Data, Nível, Mensagem 


@FLUXOIMP
Cenário: C05 - Praparar para Implantação - Como usar Fluxo implantado
 Dado que o usuário está na página Meus Projetos
 Quando selecionar um projeto
 Então o usuário será direcionado a página do projeto
 E deverá observar que o projeto possuí Experimentos executados
 E esses experimentos possuem arquivo csv
 Quando selecionar o botão "Preparar para Implantação"
 Então o usuário será direcionado a página Fluxos implantados
 E a lista de Fluxos Implantados ficará visível
 E o nome da implantação deve conter o nome do projeto e do experimento do fluxo implantado

 Quando a implantação for finalizada 
 E o status definido com Succeeded
 E o usuário deseja ter informações de como usar o fluxo implantado

 Quando selecionar o botão Como usar Fluxo Implantado
 Então será aberto um modal com as dicas do que o usuário deve fazer para usar a implantação
 


 

