#language:pt

Funcionalidade: Implantar Fluxo de Experimento na PlatIAgro
Como usuário da plataforma, desejo preparar para implantação um Experimento já executado.

Contexto: Acessar a página Meus Projetos na Plataforma
  Dado que o browser seja acionado pelo usuário
  Quando a plataforma PlatIAgro for conectada
  Então com sucesso será exibida a tela inicial da página 'Meus projetos'

@FLUXOIMP
Cenário: C01 - Praparar para Implantação - Testar Fluxo arquivo csv
 Dado que o usuário possua um projeto com experimento associado
 E clique no botão Preparar para implantação
 E no modal aberto selecionar o fluxo
 E o sistema indicar que o experimento foi implantado: 'Experimento implantado!'
 E direcionar para a página de fluxos implantados: 'Pré-implantação'
 E acionar o botão Implantar fluxo
 E um modal ser aberto
 Quando clicar em Implantar
 Então o status será definido como: 'Sucesso'

@FLUXOIMPX
Cenário: C02 - Implantação - Download do resultado
 Dado o usuário selecione o botão Testar o fluxo
 E selecionar um arquivo csv
 E um modal será aberto
 E os dados do arquivo serão apresentados
 Quando o usuário selecionar o botão Fazer Download
 Então um arquivo do resultado será baixado

@FLUXOIMPX
Cenário: C03 - Implantação - Copiar os resultados
 Dado que o usuário selecione o botão Cópia
 E uma mensagem de sucesso seja exibida na tela
 E o arquivo selecionado não for compatível com o fluxo implantado
 Então será aberto o modal com uma mensagem de erro
 E o usuário poderá acesar o log para ter  mais detalhes sobre o erro

@FLUXOIMPX
Cenário: C04 - Implantação - Testar Fluxo - Imagem
 Dado que o usuário possua um projeto com experimento que contenha tarefa com arquivo png
 E selecione o botão Preparar para implantação
 E a implantação for finalizada com o status definido com: 'Sucesso'
 Quando o usuário selecionar o botão Testar o fluxo
 E selecionar um arquivo jpg, jpeg ou png
 Então um modal será aberto
 E a imagem selecionada será exibida

@FLUXOIMPX
Cenário: C05 - Fluxos Implantados - Deletar Fluxo - Resetar
 Dado que o usuário esteja na página de Fluxos Implantados
 Quando demandar o clique no botão Excluir, localizado na coluna Ações
 E exibir um popover com a seguinte mensagem: 'Você tem certeza que deseja excluir esta implantação?'
 E o usuário optar por não excluir a implantação
 Então o popover será resetado
 E o botão Preparar para a implantação continuará desabilitado na página do experimento

@FLUXOIMPX
Cenário: C06 - Fluxos Implantados - Deletar Fluxo
 Dado que o usuário está na página de Fluxos Implantados
 Quando selecionar o botão Excluir, localizado na coluna Ações
 E um popover com a seguinte mensagem for exibido: 'Você tem certeza que deseja excluir esta implantação?'
 E o usuário confirmar a operação
 Então a implantação será deletada
 E o botão Preparar para a implantação será habilitado novamente na página do experimento

@FLUXOIMPX
Cenário: C07 - Fluxos Implantados - Visualizar Logs
 Dado que haja fluxo implantado com sucesso pelo usuário
 Quando selecionar o botão Ver Logs, localizado na coluna Ações
 Então será aberto uma drawer de Logs
 E as informações estarão divididas em três colunas: 'Data', 'Nível' e 'Mensagem'

@FLUXOIMPX
Cenário: C08 - Implantação - Como usar Fluxo implantado
 Dado que o usuário está na página Fluxos Implantados
 Quando selecionar o botão Como usar fluxo Implantado?
 Então será aberto um modal com as dicas do que o usuário deve fazer para usar a implantação






