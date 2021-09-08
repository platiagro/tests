import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

Dado(/que o usuário efetue a abertura do browser/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  browser.driver.manage().window().maximize()

}

E(/ingresse na plataforma PlatIAgro/) { ->

  to PageLogin  

}

E(/seja exibido um painel de {string}/) { String login ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("theme-panel-right"))).isDisplayed();
  wait.until(ExpectedConditions.titleIs('PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio'));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("theme-heading"), login));

}

E(/preecha os campos de autenticação com credenciais inexistentes/) { ->
  at PageLogin

  waitFor(30){
    page.user.value("tstuser")
  }

  waitFor(30){
    page.senha.value("tsterro")
  }

}

Quando(/ocorrer o clique no botão Entrar/){ ->

  waitFor(30){
    page.btnInput.click()
  }

}

Então(/será exibido pela plataforma uma mensagem de login com erro: {string}/) { String loginErro ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-error"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("dex-error-box"), loginErro));

}