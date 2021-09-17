import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

Dado(/que o usuário acesse a página Detalhes do projeto selecionado/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(30) {
    def nomeProj = $(By.cssSelector("#root > section > section > div.contentPage > div > div > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > button > span > span")).text()
    repo.add("Nome Projeto", nomeProj)

    $(By.cssSelector("#root > section > section > div.contentPage > div > div > div > div > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(2) > button > span > span")).click()
  }

  Thread.sleep(2000)

}

E(/acionar o botão Excluir/) { ->

  waitFor(10) {
    page.btndeleteProj.click()
  }

}

E(/o sistema revelar uma pop-up com a seguinte mensagem: {string}/) { String msg ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-popover-content"))).isDisplayed();

  assert $(By.className("ant-popover-content")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

}

Quando(/o usuário efetuar o clique no botão Não/) { ->

  waitFor(10) {
    page.deleteNo.click()
  }

}

Então (/o projeto não será excluído/) { ->

  def nomeProj = repo.get("Nome Projeto");
  def projDelete = $(By.xpath("//*[@id='root']/section/section/div/div/div/span/div/div/h3[text()='"+nomeProj+"']")).isDisplayed()

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(text(), '"+nomeProj+"')]"), nomeProj));

  assert projDelete == true

}