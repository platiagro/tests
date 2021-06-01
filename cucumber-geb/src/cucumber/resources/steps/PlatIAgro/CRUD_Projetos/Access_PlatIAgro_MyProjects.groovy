import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By

Dado(/que o usuário abra o browser/) { ->

  browser.driver.manage().window().maximize()

}

Quando(/acessar a plataforma PlatIAgro/){ ->

  to PageProj

}

Então(/a tela inicial da página {string} será exibida com sucesso/) { String pagProj ->

  def pagMeusProj

  waitFor(30){
    pagMeusProj = page.titleMeusProjetos.text()
  }

  assert pagMeusProj == pagProj

}