import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

Dado(/que o usuário clique em Excluir, na coluna Ação, de uma Tarefa constante na lista/) { ->

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

E(/o sistema deve abrir uma pop-up exibindo a mensagem: {string}/) { String msg ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-popconfirm"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[contains(text(), 'Você tem certeza que deseja excluir essa tarefa?')]"), msg));

  assert $(By.className("ant-popconfirm")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

}

Quando(/o usuário confirmar a operação/) { ->

  waitFor(10) {
    page.btnSim.click()
  }

}

Então (/a tarefa será excluída da lista/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);

  def nomeTarefa = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(10).substring(30).split("\\|")[0].trim();

  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span/span[text()='"+nomeTarefa+"']")));

  def projDelete = $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span/span[text()='"+nomeTarefa+"']")).isDisplayed()                             
  assert projDelete == false            

  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-message-notice-content")));

  for (int i=0; i<=1; i++){
    waitFor(10) {
      $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[4]/div/div[3]/button")).click()
    }

    waitFor(10){
      $(By.xpath("//*[contains(text(), 'Excluir')]")).click()
    }

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-popconfirm"))).isDisplayed();

    WebElement element = browser.driver.findElement(By.className("ant-popover-buttons"));
    JavascriptExecutor jse = (JavascriptExecutor)browser.driver;
    jse.executeScript("arguments[0].getElementsByTagName('button')[1].click();", element);


    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-message-notice-content")));
  }

}