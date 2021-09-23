import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

Dado(/que o usuário, na coluna Ação da lista, clique em Excluir uma Tarefa/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    $(By.xpath("//*[contains(@title, '5')]")).click()
  }

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-table-content"))).isDisplayed();

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[4]/div/div[3]/button")).click()
  }

  waitFor(10){
    $(By.xpath("//*[contains(text(), 'Excluir')]")).click()
  }

}

E(/o sistema deve abrir uma pop-up com a seguinte mensagem: {string}/) { String msg ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-popconfirm"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[contains(text(), 'Você tem certeza que deseja excluir essa tarefa?')]"), msg));

  assert $(By.className("ant-popconfirm")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

}

Quando(/selecionar o botão Não/) { ->

  waitFor(10) {
    page.btnNo.click()
  }

}

Então (/a operação será cancelada/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-popconfirm")));

  def tarDelete = $(By.className("ant-popconfirm")).isDisplayed()                             
  assert tarDelete != true

}

E(/nenhuma tarefa será excluída/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/div/button/span/span[text()='Tarefa em branco - 1']"))).isDisplayed();

  assert $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/div/button/span/span[text()='Tarefa em branco - 1']")).isDisplayed()

}