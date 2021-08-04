import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By

Dado(/que o browser seja acionado pelo usuário/) { ->

  browser.driver.manage().window().maximize()

}

Quando(/a plataforma PlatIAgro for conectada/){ ->

  to PageProj

}

Então(/com sucesso será exibida a tela inicial da página {string}/) { String pagProj ->
  at PageProj

  def pagMeusProj

  waitFor(30){
    pagMeusProj = page.titleMeusProjetos.text()
  }

  assert pagMeusProj == pagProj

}