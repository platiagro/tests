import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

Dado(/que o usuário abra o browser/) { ->

  browser.driver.manage().window().maximize()

}

Quando(/acessar a plataforma PlatIAgro/){ ->
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

Então(/a tela inicial da página {string} será exibida com sucesso/) { String pagProj ->
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