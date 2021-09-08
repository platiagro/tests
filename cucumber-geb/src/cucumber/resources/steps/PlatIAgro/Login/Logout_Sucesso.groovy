import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

Dado(/que o usuário esteja logado na plataforma/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  browser.driver.manage().window().maximize()

  to PageLogin

  Thread.sleep(2000)

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("theme-panel-right"))).isDisplayed();
  wait.until(ExpectedConditions.titleIs('PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio'));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("theme-heading"), 'Login'));

  at PageLogin

  waitFor(30){
    page.user.value("platiagro")
  }

  waitFor(30){
    page.senha.value("platiagro1234")
  }

  waitFor(30){
    page.btnInput.click()
  }

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-layout"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("user-info-component "))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("custom-edit-title"), 'Meus projetos'));

}


E(/clicar do dropdown do nome de usuário/) { ->

  waitFor(30){
    page.dropUser.click()
  }

}

Quando(/realizar o clique no item Sair/) { ->

  waitFor(30){
    page.dropItemSair.click()
  }

}

Então(/a plataforma irá retornar para o painel de {string}/) { String login ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("theme-panel-right"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("theme-heading"), login));

}