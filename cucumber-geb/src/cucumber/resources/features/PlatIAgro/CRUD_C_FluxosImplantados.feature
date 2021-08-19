#language:pt

Funcionalidade: Implantar Fluxo de Experimento na PlatIAgro
Como usuário da plataforma, desejo preparar para implantação um Experimento já executado.

Contexto: Acessar a página Meus Projetos na Plataforma
  Dado que o browser seja acionado pelo usuário
  Quando a plataforma PlatIAgro for conectada
  Então com sucesso será exibida a tela inicial da página 'Meus projetos'

@IMPLANTAR
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

@IMPLANTAR
Cenário: C02 - Implantação - Testar Fluxo - CSV
 Dado que o usuário tenha um experimento com arquivo csv implantado
 Quando houver a selecão do botão Testar Fluxo
 Então será apresentado um modal com o seguinte título: 'Visualizar Resultados do Teste do Fluxo'
 E as seguintes colunas descritivas exibidas: 'Id', 'SepalLengthCm', 'SepalWidthCm', 'PetalLengthCm' e 'PetalWidthCm'

@IMPLANTAR
Cenário: C03 - Implantação - Download do resultado
 Dado que o usuário selecione o botão Testar Fluxo
 Quando selecionar o botão Fazer Download
 Então um arquivo do resultado será baixado com êxito

@IMPLANTAR
Cenário: C04 - Implantação - Monitoramento
 Dado que o usuário clique no botão para adicionar um monitoramento
 E um modal seja aberto para seleção
 E escolha um tipo de monitoramento
 Quando clicar no botão Adicionar Monitoramento
 Então no painel de monitoramento é exibido o tipo selecionado anteriormente
 E ao clicar no botão Ver Monitoramentos um drawer será exibido

@IMPLANTAR
Cenário: C05 - Implantação - Como usar Fluxo implantado
 Dado que o usuário está na página Fluxos Implantados
 Quando selecionar o botão Como usar fluxo Implantado?
 Então será aberto um modal com as dicas do que o usuário deve fazer para usar a implantação

@IMPLANTAR
Cenário: C06 - Fluxo Implantado - Visualizar Logs
 Dado que haja fluxo implantado com sucesso pelo usuário
 Quando selecionar o botão Ver Logs, localizado na coluna Ações
 Então será aberto uma drawer de Logs
 E as informações estarão divididas em três colunas: 'Data', 'Nível' e 'Mensagem'

@IMPLANTAR
Cenário: C07 - Fluxo Implantado - Deletar Fluxo - Resetar
 Dado que o usuário esteja na página de Fluxos Implantados
 Quando demandar o clique no botão Excluir, localizado na coluna Ações
 E exibir um popover com a seguinte mensagem: 'Você tem certeza que deseja excluir esta implantação?'
 E o usuário optar por não excluir a implantação
 Então o popover será resetado
 E os dados referente a implantação continuarão sendo exibidos

@IMPLANTAR
Cenário: C08 - Fluxo Implantado - Deletar Fluxo
 Dado que o usuário acesse um fluxo implantado
 Quando selecionar o botão Excluir, localizado na coluna Ações
 E um popover com a seguinte mensagem for exibido: 'Você tem certeza que deseja excluir esta implantação?'
 E o usuário confirmar a operação de exclusão
 Então o sistema irá sinalizar com o seguinte display: 'Fluxo excluído!'
 E a implantação será deletada