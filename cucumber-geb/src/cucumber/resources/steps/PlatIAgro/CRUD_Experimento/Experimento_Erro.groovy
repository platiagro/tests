import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.interactions.Actions
import org.testng.Assert
import org.apache.commons.io.FileUtils

import java.awt.Robot

import helper.utility.NumberGerador

/*import org.sikuli.script.Key
import org.sikuli.script.Match
import org.sikuli.script.Pattern
import org.sikuli.script.Screen
import org.sikuli.basics.Settings

Screen screen = new Screen();
Settings.ActionLogs = null != null;*/

String filePath = System.getProperty ('user.dir')
String caminho = '/src/cucumber/resources/files/'

Dado(/que o usuário demande a criação de um novo Projeto/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/button/span[2]")).click()
  }

  Thread.sleep(2000)

  waitFor(10) {
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    page.campnome.value(del)
  }

  def nomeProj = "Teste " + NumberGerador.number()

  waitFor(10) {
    page.campnome.value(nomeProj)
  }

  //Armazena o nome do projeto portador do fluxo de experimento com erro
	reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt"), true);
	reg.write("+---------------------------------------------------------+\n"
				  + "| Erro no fluxo de experimento : " + nomeProj + "            |\n"
				  + "+---------------------------------------------------------+\n");
	reg.close();

  waitFor(30) {
    page.btnConfirm.click()
  }

  at PageExperimento

  waitFor(30) {
    page.cardExperimento.click()
  }

  Thread.sleep(2000)

}

E(/um novo experimento seja criado, nomeado como: {string}/) { String nomeExp ->

  String expName = $(By.xpath("//*[@class='tab-title-custom'][contains(text(), 'Experimento 1')]")).toString();
  assert expName.contains(nomeExp)
   
}

E(/for selecionado o menu Conjunto de Dados/) { ->
  at PageExperimento

  waitFor(30) {
    page.menuConjunto.click()
  }

  Thread.sleep(1000)
   
}

E(/arrastado o operador Upload de arquivos para o fluxo/) { ->

  /*WebElement elementoBase = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[2]/ul/li[2]/div/div[2]/span"));
  Actions action = new Actions(browser.driver);
  action.clickAndHold(elementoBase).build().perform();
 
  Pattern image1 = new Pattern(System.getProperty("user.dir") + "/src/cucumber/resources/helper/images/Image1.png");
  Pattern image2 = new Pattern(System.getProperty("user.dir") + "/src/cucumber/resources/helper/images/Image2.png");
  Pattern image3 = new Pattern(System.getProperty("user.dir") + "/src/cucumber/resources/helper/images/Image3.png");

  screen.dragDrop(image1, image2);

  Match m1 = screen.exists(image2);
  Match m2 = screen.exists(image3);
	while (m1 != null && m2 == null) {
      action.clickAndHold(elementoBase).build().perform();
      screen.dragDrop(image1, image2);
      screen.wait(image3, 10);
      Match m3 = screen.exists(image3);
      if (m3 != null) {
        break;
      }
	}*/

  WebElement source = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[2]/ul/li[2]/div/div[2]/span"));
  WebElement destination = browser.driver.findElement(By.cssSelector("#root > section > section > section > main > section > main > div.custom-flow > div.experiment-flow > div > div.OperatorsEmptyContainer.experiment-flow-empty-operators > img"));
  JavascriptExecutor jse = (JavascriptExecutor)browser.driver;
  jse.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",source, destination);

}

E(/clicar no operador novamente/) { ->
  at PageExperimento

  waitFor(30) {
    page.operadorUpArq.click()
  }

  Thread.sleep(2000)
   
}

E(/no drawer de propriedades acionar o botão Importar/) { ->

  WebElement elementoBase = browser.driver.findElement(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/span/div[1]/span/div/button[1]/span[2]"));
  Actions action = new Actions(browser.driver);
  action.moveToElement(elementoBase).build().perform();

}

E(/informar o arquivo {string} para importar os dados de entrada/) { String arquivo ->

  waitFor(30) {
    page.inputFile.value(filePath + caminho + arquivo) //upload do arquivo de entrada
  }

  Thread.sleep(5000)

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[1]/button[3]/span")).click()
  }

}

E(/selecionar o menu Treinamento/) { ->
  at PageExperimento

  waitFor(30) {
    page.menuTreinamento.click()
  }
   
}

E(/adicionar a tarefa Regressão Linear ao fluxo/) { ->

  /*screen.type(Key.PAGE_DOWN);

  WebElement elementoBase = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[7]/ul/li[7]/div/div[2]/span"));
  Actions action = new Actions(browser.driver);
  action.clickAndHold(elementoBase).build().perform();

  Pattern image1 = new Pattern(System.getProperty("user.dir") + "/src/cucumber/resources/helper/images/Image7.png");
  Pattern image2 = new Pattern(System.getProperty("user.dir") + "/src/cucumber/resources/helper/images/Image5.png");
  Pattern image3 = new Pattern(System.getProperty("user.dir") + "/src/cucumber/resources/helper/images/Image8.png");

  screen.dragDrop(image1, image2);

  Match m1 = screen.exists(image3);
	while (m1 == null) {
      action.clickAndHold(elementoBase).build().perform();
      screen.dragDrop(image1, image2);
      Match m2 = screen.exists(image3);
      if (m2 != null) {
        break;
      }
	}*/

  Thread.sleep(1000)

  WebElement source = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[7]/ul/li[7]/div/div[2]/span"));
  WebElement destination = browser.driver.findElement(By.className("react-flow"));
  JavascriptExecutor jse = (JavascriptExecutor)browser.driver;
  jse.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",source, destination);

  Thread.sleep(1000)

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[1]/button[3]/span")).click()
  }
  
  at PageExperimento

  waitFor(30) {
    page.selRegLinear.click()
  }

}

E(/no drawer de propriedade da tarefa selecione no campo Atributo Alvo o atributo label/) { ->
  at PageExperimento

  waitFor(30) {
    page.campoAtrAlvo.click()
  }

  waitFor(30) {
    page.label.click()
  }

}

E(/no campo Features para incluir-remover no modelo selecionar o atributo text/) { ->
  at PageExperimento

  waitFor(30) {
    page.campoFeature.click()
  }

  waitFor(30) {
    page.text.click()
  }

}

E(/no campo Features para fazer codificação ordinal selecionar o atributo is_valid/) { ->
  at PageExperimento

  waitFor(30) {
    page.campoCodeOrd.click()
  }

  waitFor(30) {
    page.isValid.click()
  }

}

Quando(/clicar no botão Executar/) { ->

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[1]/button[3]/span")).click()
  }

  Thread.sleep(1000)

  WebElement sourceEle  = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div[1]/div/div/div[3]/div"));
  WebElement targetEle = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div[1]/div[1]"));
  Actions action = new Actions(browser.driver);
  action.dragAndDrop(sourceEle, targetEle).build().perform();

  at PageExperimento

  waitFor(30) {
    page.btnExecut.click()
  }

}

Então(/a execução não será finalizada, com a platforma sinalizadando a Tarefa com erro/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 120);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@data-icon, 'exclamation-circle')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[2]/div/span/sup"))).isDisplayed();

}

E(/o usuário poderá visualizar o motivo no Histórico de Erros e Mensagens/) { ->

  waitFor(30){
    page.histErrMsg.click()
  }

  Thread.sleep(2000)

  $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[3]/div[1]/div[2]/span[2]/span[2]")).click()

  $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[3]/div[1]/div[2]/span[3]/span[2]")).click()

  WebDriverWait wait = new WebDriverWait(browser.driver, 60);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > section > section > section > main > section > main > div.custom-flow > div.logs-panel > div.logs-panel-logs > div > div.log-list-item-icon > span > svg"))).isDisplayed();

}

E(/ao selecionar o botão Ver código no Jupyter o usuário poderá ver mais detallhes do erro na execução/) { ->
  at PageExperimento
  
  waitFor(30) {
    page.selRegLinear.click()
  }


  waitFor(30) {
    page.btnJupyter.click()
  }

  List<String> abas = new ArrayList<>(browser.driver.getWindowHandles());
  browser.driver.switchTo().window(abas.get(1));

  WebDriverWait wait = new WebDriverWait(browser.driver, 60);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div[2]/div[3]/div[4]/div[2]/div[1]/div[2]/div[2]/div[3]/p/span")));
  
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div[2]/div[3]/div[4]/div[2]/div[19]/div[2]/div[2]/div[3]/p/span")));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[3]/div[3]/div[2]/div[3]/div[4]/div[2]/div[19]/div[2]/div[2]/div[3]/p/span"), 'Execution using papermill encountered an exception here and stopped:'));
  
  Thread.sleep(2000)

}