import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.interactions.Actions
import org.apache.commons.io.FileUtils

String filePath = System.getProperty ('user.dir')
String caminho = '/src/cucumber/resources/files/Iris.csv'

Dado(/que o usuário tenha um projeto com tarefas no fluxo da experimentação/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt")).get(25).substring(25).split("\\|")[0].trim();
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span/span[text()='"+nomeProj+"']")).click()
  }

  at PageExperimento

  waitFor(30) {
    page.cardExperimento.click()
  }
  
  waitFor(30) {
    $(By.xpath("//*[@class='ellipsis'][text()='Upload de arquivo']")).click()
  }

  Thread.sleep(1000)

  WebElement elementoBase = browser.driver.findElement(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/span/div[1]/span/div/button[1]/span[2]"));
  Actions action = new Actions(browser.driver);
  action.moveToElement(elementoBase).build().perform();
  
  waitFor(30) {
    page.inputFile.value(filePath + caminho) //upload do arquivo de entrada
  }

  Thread.sleep(2000)
  
  waitFor(30) {
      $(By.xpath("//*[@class='ellipsis'][text()='Seleção Manual de Atributos']")).click()
  }

  waitFor(30) {
    page.campoFeatFiltragem.click()
  }

  waitFor(30) {
    page.species.click()
  }

}

E(/o usuário selecionar o botão Executar/) { ->
  at PageExperimento

  waitFor(30) {
    page.btnExecut.click()
  }

}

E(/o sistema exibir a seguinte mensagem: {string}/) { String msg ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).text()

  Thread.sleep(5000)

}

Quando(/selecionar o botão Interromper/) { ->
  at PageExperimento

  waitFor(30) {
    page.btnInterromper.click()
  }

}

Então(/a mensagem {string} deve ser exibida no topo da tela/) { String msgIntExec ->
  
  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-notice-content"))).isDisplayed();

  assert $(By.xpath("//*[contains(text(), '"+msgIntExec+"')]")).text()

  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-message-notice-content")));

}

E(/será exibida na finalização do processo de interrupção a mensagem: {string}/) { String msgTreinInt ->
  
  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-notice-content"))).isDisplayed();

  assert $(By.xpath("//*[contains(text(), '"+msgTreinInt+"')]")).text()

  Thread.sleep(2000)

}