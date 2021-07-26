import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By

Dado(/que o usuário demande a abertura do browser/) { ->

  browser.driver.manage().window().maximize()

}

E(/conectar a plataforma PlatIAgro/){ ->

  to PageTarefa

}

Quando(/acessar a página de Tarefas/){ ->

  waitFor(10){
    page.menuTarefa.click()
  }

}

Então(/a tela inicial da página {string} será exibida com êxito/) { String pagTarefas ->
  at PageTarefa

  def pagTasks

  waitFor(30){
    pagTasks = page.titleTasks.text()
  }

  assert pagTasks == pagTarefas

}