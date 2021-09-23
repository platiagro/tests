import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

Dado(/que o browser seja aberto pelo usuário/) { ->

  browser.driver.manage().window().maximize()

}

Quando(/a plataforma PlatIAgro for acessada/){ ->
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

Então(/será exibida com sucesso a tela inicial da página {string}/) { String pagProj ->
  page.switchTo(PageProj)
  at PageProj

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("custom-edit-title"), pagProj));

  def pagMeusProj

  waitFor(30){
    pagMeusProj = page.titleMeusProjetos.text()
  }

  assert pagMeusProj == pagProj

}