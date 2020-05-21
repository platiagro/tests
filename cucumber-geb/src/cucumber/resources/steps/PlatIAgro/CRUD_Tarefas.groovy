import pages.*
import geb.*
import db.*
import cucumber.api.PendingException

import org.openqa.selenium.By
import static cucumber.api.groovy.PT.*

//Contexto
Dado(~/que o usuário acessa a plataforma PlatIAgro/){->
 assert true
}

E(~/é apresentado a página inicial da plataforma/){->
 assert true
}

Então(~/o usuário irá selecionar a aba Tarefas do Menu/){->
  at PlatPage
   waitFor(60){
       page.tarefaMenu.click()
   } Thread.sleep(5000) 
}

//C01

Dado(/que o usuário acessa a tela inicial da plataforma/){->
 assert true
}

E(/selecionar a aba Tarefas do Menu/){->
 assert true
}

Quando(~/o sistema direcionar o usuário para a página de Tarefas/){->
 assert true
}

Então(~/deverá observar que todas as tarefas existentes estarão listadas/){->
 assert true
}

E(/as informações das tarefas estarão divididas em três colunas: Nome da Tarefa, Descrição e Ação/){->
 assert true
}
