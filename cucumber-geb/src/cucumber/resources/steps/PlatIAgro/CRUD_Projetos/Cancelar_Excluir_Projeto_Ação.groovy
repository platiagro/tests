import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

Dado(/que o usuário efetue a seleção de um dos projetos da lista/) { ->
  at PageProj

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/label/span/input")).click()
  }

  def nomeProj = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[2]/button/span/span")).text()
  repo.add("Nome Projeto", nomeProj)

}

E(/na coluna ação seletar a opção Excluir/) { ->

  def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(13).substring(22).split("\\|")[0].trim();

  waitFor(10) {
    $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[6]/button/span")).click()
  }

}

E(/o sistema apresentar uma pop-up com a seguinte mensagem: {string}/) { String msg ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-popover-content"))).isDisplayed();

  assert $(By.className("ant-popover-content")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

}

Quando(/o usuário clicar no botão Não/) { ->

  waitFor(10) {
    page.deleteNo.click()
  }

}

Então (/o projeto não será excluído e permanecerá na lista de projetos/) { ->

  def nomeProj = repo.get("Nome Projeto");
  def projDelete = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span/span[text()='"+nomeProj+"']")).isDisplayed()

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(text(), '"+nomeProj+"')]"), nomeProj));
                           
  assert projDelete == true

}