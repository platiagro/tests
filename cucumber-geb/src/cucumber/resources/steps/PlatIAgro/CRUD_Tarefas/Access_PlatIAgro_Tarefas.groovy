import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By

Dado(/que o usuário demande a abertura do browser/) { ->

  browser.driver.manage().window().maximize()

}

E(/conectar a plataforma PlatIAgro/){ ->
  to PageLogin

  waitFor(30){
    page.user.value('platiagro')
  }

  waitFor(30){
    page.senha.value('platiagro1234')
  }

  waitFor(30){
    page.btnInput.click()
  }

}

Quando(/acessar a página de Tarefas/){ ->
  page.switchTo(PageTarefa)
  at PageTarefa

  waitFor(10){
    page.menuTarefa.click()
  }

}

Então(/a tela inicial da página {string} será exibida com êxito/) { String pagTarefas ->

  def pagTasks

  waitFor(30){
    pagTasks = page.titleTasks.text()
  }

  assert pagTasks == pagTarefas

}