import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By

Dado(/que o browser seja aberto pelo usuário/) { ->

  browser.driver.manage().window().maximize()

}

Quando(/a plataforma PlatIAgro for acessada/){ ->

  to PageProj

}

Então(/será exibida com sucesso a tela inicial da página {string}/) { String pagProj ->
  at PageProj

  def pagMeusProj

  waitFor(30){
    pagMeusProj = page.titleMeusProjetos.text()
  }

  assert pagMeusProj == pagProj

}