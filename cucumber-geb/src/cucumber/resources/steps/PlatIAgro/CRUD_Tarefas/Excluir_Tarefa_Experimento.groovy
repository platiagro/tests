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

import helper.utility.NumberGerador

Dado(/que o usuário selecione para exclusão uma Tarefa da lista que esteja relacionada a um projeto com experimento/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/aside/div[1]/ul/li[1]/span[1]")).click()
  }

  Thread.sleep(1000)

  List<WebElement> search = browser.driver.findElements(By.className("myProjectsEmptyPlaceholder"));
  int check = search.size();
  if (check!=0) {
    waitFor(30) {
      $(By.xpath("//*[@id='root']/section/section/div[2]/button/span[2]")).click()
    }
  } else {
    waitFor(10) {
      $(By.xpath("/html/body/div[1]/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[1]/div/label/span/input")).click()
    }
    waitFor(10) {
      $(By.xpath("//*[@id='root']/section/section/div[2]/button[2]/span[2]")).click()
    }
    waitFor(10) {
      $(By.xpath("//*[contains(text(), 'Sim')]")).click()
    }
    waitFor(10) {
      $(By.xpath("//*[@id='root']/section/section/div[2]/button/span[2]")).click()
    }
    Thread.sleep(1000)
    WebDriverWait wait = new WebDriverWait(browser.driver, 30);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-message-notice-content")));
  }

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-modal-content"))).isDisplayed();

  waitFor(10) {
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    $(By.xpath("//*[@id='name']")).value(del)
  }

  def nomeProj = "Teste Tarefa " + NumberGerador.number()

  waitFor(10) {
    $(By.xpath("//*[@id='name']")).value(nomeProj)
  }

  WebElement element = browser.driver.findElement(By.className("ant-modal-footer"));
  JavascriptExecutor jse = (JavascriptExecutor)browser.driver;
  jse.executeScript("arguments[0].getElementsByTagName('button')[1].click();", element);

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();

  waitFor(10) {
    $(By.xpath("/html/body/div[1]/section/section/section/main/section/div/div[1]/div[1]/button/div[1]/div/img")).click()
  }

  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='tab-title-custom']"), 'Experimento 1'));

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/section/aside/div/div/ul/li[3]/div/span/span[2]")).click()
  }
                                                              
  WebElement source = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[3]/ul/li[3]/div/div[2]/span"));
  WebElement destination = browser.driver.findElement(By.className("react-flow"));
  wait.until(ExpectedConditions.elementToBeClickable(source));
  jse.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",source, destination);

  waitFor(10){
    page.menuTarefa.click()
  }

  waitFor(10) {
    $(By.xpath("//*[contains(@title, '4')]")).click()
  }

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-table-content"))).isDisplayed();

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[9]/td[4]/div/div[3]/button")).click()
  }

  waitFor(10){
    $(By.xpath("//*[contains(text(), 'Excluir')]")).click()
  }

}

E(/a plataforma apresentar uma pop-up com a seguinte mensagem: {string}/) { String msg ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-popconfirm"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[contains(text(), 'Você tem certeza que deseja excluir essa tarefa?')]"), msg));

  assert $(By.className("ant-popconfirm")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

}

Quando(/for confirmada a operação de exclusão/) { ->

  WebElement element = browser.driver.findElement(By.className("ant-popover-buttons"));
  JavascriptExecutor jse = (JavascriptExecutor)browser.driver;
  jse.executeScript("arguments[0].getElementsByTagName('button')[1].click();", element);

}

Então (/a operação será cancelada, informando que a Tarefa está em uso: {string}/) { String msgImpediment ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-notice-content"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '"+msgImpediment+"')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span/span[text()='Tarefa em branco - 1']"))).isDisplayed();

  def task = $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span/span[text()='Tarefa em branco - 1']")).isDisplayed()                          
  assert task != false

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/aside/div[1]/ul/li[1]/span[1]")).click()
  }
  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[6]/button/span")).click()
  }
  waitFor(10) {
    $(By.xpath("//*[contains(text(), 'Sim')]")).click()
  }

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("myProjectsEmptyPlaceholder")));

}