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

import helper.utility.NumberGerador

/*import org.sikuli.script.Match
import org.sikuli.script.Pattern
import org.sikuli.script.Screen
import org.sikuli.basics.Settings

Screen screen = new Screen();
Settings.ActionLogs = null != null;*/

Dado(/que o usuário deseje criar um novo Projeto/) { ->

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

  //Armazena o nome do projeto com template
	reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt"), true);
	reg.write("+---------------------------------------------------------+\n"
				  + "| Projeto com template : " + nomeProj + "                    |\n"
				  + "+---------------------------------------------------------+\n");
	reg.close();

  waitFor(30) {
    page.btnConfirm.click()
  }

}

E(/selecione o botão Novo experimento/) { ->
  at PageExperimento

  waitFor(30) {
    page.newExperimento.click()
  }
   
}

E(/nomeie o experimento como: {string}/) { String nomeExp ->

  waitFor(10) {
    page.clearCampoExp.click()
  }

  waitFor(10) {
    page.campTemplate.value(nomeExp)
  }

  repo.add("Nome Experimento", nomeExp)

  //Armazena o nome do projeto gerado para ser utilizado por outros cenários
	reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt"), true);
	reg.write("+---------------------------------------------------------+\n"
			    + "| Experimento com template: " + nomeExp + "  |\n"
			    + "+---------------------------------------------------------+\n");
	reg.close();
   
}

E(/demandar o clique no botão Criar/) { ->
  at PageExperimento

  waitFor(30) {
    page.btnCriar.click()
  }

  Thread.sleep(1000)
   
}

E(/verificar que o novo experimento foi criado/) { ->
  
  String meuExperimentoTemplate = repo.get("Nome Experimento");
  String myExperimentTempl = $(By.xpath("//*[@class='tab-title-custom'][text()='"+meuExperimentoTemplate+"']")).text();
  assert meuExperimentoTemplate.contains(myExperimentTempl)
   
}

Quando(/selecionar o template salvo anteriormente para adicionar ao fluxo/) { ->
  at PageExperimento

  waitFor(30) {
    page.selectTemplate.click()
  }

  Thread.sleep(1000)
  
  /*WebElement elementoBase = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[1]/ul/li/div/div[2]/span"));
  Actions action = new Actions(browser.driver);
  action.clickAndHold(elementoBase).build().perform();
 
  Pattern image1 = new Pattern(System.getProperty("user.dir") + "/src/cucumber/resources/helper/images/Image11.png");
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

  WebElement source = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[1]/ul/li/div/div[2]/span"));
  WebElement destination = browser.driver.findElement(By.cssSelector("#root > section > section > section > main > section > main > div.custom-flow > div.experiment-flow > div > div.OperatorsEmptyContainer.experiment-flow-empty-operators > img"));
  JavascriptExecutor jse = (JavascriptExecutor)browser.driver;
  jse.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",source, destination);
   
}

Então(/o usuário poderá iniciar seu novo experimento/) { ->

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[1]/button[3]/span")).click()
  }
  
  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  WebElement element = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[2]/span[2]"));
  wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
  wait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();
   
}