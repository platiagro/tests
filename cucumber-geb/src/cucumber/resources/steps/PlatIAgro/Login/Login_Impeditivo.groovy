import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

Dado(/que o usuário demande que o browser seja aberto/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  browser.driver.manage().window().maximize()

}

E(/realize o acesso na plataforma PlatIAgro/) { ->

  to PageLogin

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("theme-panel-right"))).isDisplayed();
  wait.until(ExpectedConditions.titleIs('PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio'));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("theme-heading"), 'Login'));

}

Quando(/realizar o clique no botão Entrar sem preencher qualquer credencial do usuário/) { ->
  at PageLogin

  waitFor(30){
    page.btnInput.click()
  }

}

Então(/a plataforma continuará exibindo o painel de {string}/) { String login ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("theme-panel-right"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("theme-heading"), login));

}