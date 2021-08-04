import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Random
import java.util.Date
import java.util.TimeZone

import helper.utility.NumberGerador

FileWriter reg;
Date now = new Date();
SimpleDateFormat fmtDate = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat fmtHour = new SimpleDateFormat("HH:mm");

String filePath = System.getProperty ('user.dir')
String caminho = '/src/cucumber/resources/files/Iris.csv'

Dado(/que o usuário possua um projeto com experimento associado/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  // Registra o cenário de teste
  fmtHour.setTimeZone(TimeZone.getTimeZone("GMT-3"));
  reg = new FileWriter(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_FluxoImplantado_dataBase/Registros.txt", false);
  reg.write("");
  reg.flush();
  reg = new FileWriter(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_FluxoImplantado_dataBase/Registros.txt", true);
  reg.write("Data: " + fmtDate.format(now.getTime()) + " - Horas: " + fmtHour.format(now.getTime()) + "\n\n"
	      + "===========================================================\n"
	      + "::::::::::::: Registros do Teste Automatizado :::::::::::::\n"
	      + "===========================================================\n\n"
	      + "+---------------------------------------------------------+\n"
	      + "| Funcionalidade: Fluxos Implantados na PlatIAgro         |\n"
	      + "+---------------------------------------------------------+\n");
  reg.close();

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
  }

  def nomeProj = "Teste " + NumberGerador.number()

  waitFor(10) {
    page.campnome.value(nomeProj)
  }

  repo.add("Nome Projeto", nomeProj)

  //Armazena o nome do projeto gerado para ser utilizado por outros cenários
  reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_FluxoImplantado_dataBase/Registros.txt"), true);
  reg.write("+---------------------------------------------------------+\n"
		  + "| Nome do projeto criado: " + nomeProj + "                   |\n"
		  + "+---------------------------------------------------------+\n");
  reg.close();

  waitFor(10) {
    page.campDesc.value("Teste - Implantar Fluxo de Experimento")
  }

  Thread.sleep(1000)

  WebElement element = browser.driver.findElement(By.className("ant-modal-footer"));
  JavascriptExecutor jse = (JavascriptExecutor)browser.driver;
  jse.executeScript("arguments[0].getElementsByTagName('button')[1].click();", element);

  at PageExperimento

  waitFor(30) {
    page.cardExperimento.click()
  }

  waitFor(30) {
    page.menuConjunto.click()
  }

  Thread.sleep(1000)

  WebElement source_I = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[2]/ul/li[2]/div/div[2]/span"));
  WebElement destination_I = browser.driver.findElement(By.cssSelector("#root > section > section > section > main > section > main > div.custom-flow > div.experiment-flow > div > div.OperatorsEmptyContainer.experiment-flow-empty-operators > img"));
  jse.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",source_I, destination_I);

  waitFor(10) {
    page.operadorUpArq.click()
  }

  waitFor(30) {
    page.inputFile.value(filePath + caminho) //upload do arquivo de entrada
  }

  Thread.sleep(3000)

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[1]/button[3]/span")).click()
  }

  waitFor(30) {
    page.menuEngAtributos.click()
  }

  Thread.sleep(1000)

  WebElement source_II = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[5]/ul/li[11]/div/div[2]/span"));
  WebElement destination_II = browser.driver.findElement(By.className("react-flow"));
  jse.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",source_II, destination_II);

  waitFor(30) {
    page.selManAtributos.click()
  }

  waitFor(30) {
    page.campoFeatFiltragem.click()
  }

  waitFor(30) {
    page.species.click()
  }

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[1]/button[3]/span")).click()
  }

  Thread.sleep(1000)

  WebElement sourceEle  = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div[1]/div/div/div[3]/div"));
  WebElement targetEle = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div[1]/div[1]"));
  Actions action = new Actions(browser.driver);
  action.dragAndDrop(sourceEle, targetEle).build().perform();

  waitFor(30) {
    page.btnExecut.click()
  }

  Thread.sleep(10000)

  WebDriverWait wait = new WebDriverWait(browser.driver, 120);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();
  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Treinamento concluído')]")));

}

E(/clique no botão Preparar para implantação/) { ->
  at PageExperimento

  waitFor(30) {
    page.btnImplantar.click()
  }

}

E(/no modal aberto selecionar o fluxo/) { ->

  waitFor(10) {
    $(By.xpath("//*[@id='form_in_modal']/div/div/div/div/label/span[1]")).click()
  }

  waitFor(10) {
    $(By.xpath("//*[contains(text(), 'OK')]")).click()
  }

}

E(/o sistema indicar que o experimento foi implantado: {string}/) { String msgSuccess ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();

  assert $(By.xpath("//*[contains(text(), '"+msgSuccess+"')]")).text()

}

E(/direcionar para a página de fluxos implantados: {string}/) { String pagImpl ->

  assert $(By.xpath("//*[@id='root']/section/section/div/div[1]/div/div/span[2]/div/button/span[text()='"+pagImpl+"']")).isDisplayed()

  Thread.sleep(2000)

}

E(/acionar o botão Implantar fluxo/) { ->
  at PageFluxoImp

  waitFor(30) {
    page.btnImpFluxo.click()
  }

}

E(/um modal ser aberto/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-modal-content"))).isDisplayed();

}

Quando(/clicar em Implantar/) { ->

  Thread.sleep(1000)

  WebElement element = browser.driver.findElement(By.className("ant-modal-footer"));
  JavascriptExecutor jse = (JavascriptExecutor)browser.driver;
  jse.executeScript("arguments[0].getElementsByTagName('button')[1].click();", element);

}

Então(/o status será definido como: {string}/) { String status ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 120);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-notice-content"))).isDisplayed();
  assert $(By.xpath("//*[contains(text(), 'Experimento implantado!')]")).text()
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='root']/section/section/section/main/section/div/div[2]/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/span/span[2]"), status));

}
