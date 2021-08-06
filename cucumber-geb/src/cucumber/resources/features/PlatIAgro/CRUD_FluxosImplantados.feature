#language:pt

Funcionalidade: Implantar Fluxo de Experimento na PlatIAgro
Como usuário da plataforma, desejo preparar para implantação um Experimento já executado.

Contexto: Acessar a página Meus Projetos na Plataforma
  Dado que o browser seja acionado pelo usuário
  Quando a plataforma PlatIAgro for conectada
  Então com sucesso será exibida a tela inicial da página 'Meus projetos'

@FLUXOIMP
Cenário: C01 - Praparar para Implantação
 Dado que o usuário possua um projeto com experimento associado
 E clique no botão Preparar para implantação
 E no modal aberto selecionar o fluxo
 E o sistema indicar que o experimento foi implantado: 'Experimento implantado!'
 E direcionar para a página de fluxos implantados: 'Pré-implantação'
 E acionar o botão Implantar fluxo
 E um modal ser aberto
 Quando clicar em Implantar
 Então o status será definido como: 'Sucesso'

@FLUXOIMP
Cenário: C02 - Implantação - Testar Fluxo - CSV
 Dado que o usuário tenha um experimento com arquivo csv implantado
 Quando houver a selecão do botão Testar Fluxo
 Então será apresentado um modal com o seguinte título: 'Visualizar Resultados do Teste do Fluxo'
 E as seguintes colunas descritivas exibidas: 'Id', 'SepalLengthCm', 'SepalWidthCm', 'PetalLengthCm' e 'PetalWidthCm'

@FLUXOIMP
Cenário: C03 - Implantação - Download do resultado
 Dado o usuário selecione o botão Testar Fluxo
 Quando selecionar o botão Fazer Download
 Então um arquivo do resultado será baixado com êxito

@FLUXOIMP
Cenário: C04 - Implantação - Como usar Fluxo implantado
 Dado que o usuário está na página Fluxos Implantados
 Quando selecionar o botão Como usar fluxo Implantado?
 Então será aberto um modal com as dicas do que o usuário deve fazer para usar a implantação

@FLUXOIMP
Cenário: C05 - Fluxo Implantado - Visualizar Logs
 Dado que haja fluxo implantado com sucesso pelo usuário
 Quando selecionar o botão Ver Logs, localizado na coluna Ações
 Então será aberto uma drawer de Logs
 E as informações estarão divididas em três colunas: 'Data', 'Nível' e 'Mensagem'

@FLUXOIMP
Cenário: C06 - Fluxo Implantado - Deletar Fluxo - Resetar
 Dado que o usuário esteja na página de Fluxos Implantados
 Quando demandar o clique no botão Excluir, localizado na coluna Ações
 E exibir um popover com a seguinte mensagem: 'Você tem certeza que deseja excluir esta implantação?'
 E o usuário optar por não excluir a implantação
 Então o popover será resetado
 E os dados referente a implantação continuarão sendo exibidos

@FLUXOIMP
Cenário: C07 - Fluxo Implantado - Deletar Fluxo
 Dado que o usuário acesse um fluxo implantado
 Quando selecionar o botão Excluir, localizado na coluna Ações
 E um popover com a seguinte mensagem for exibido: 'Você tem certeza que deseja excluir esta implantação?'
 E o usuário confirmar a operação de exclusão
 Então o sistema irá sinalizar com o seguinte display: 'Fluxo excluído!'
 E a implantação será deletada