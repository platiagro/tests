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
import org.testng.Assert
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
String caminho = '/src/cucumber/resources/files/'

Dado(/que o usuário demande o clique no botão Novo Projeto/) { ->

  for (int i=0; i<2; i++){
    println " "
	}

  // Registra o cenário de teste
	fmtHour.setTimeZone(TimeZone.getTimeZone("GMT-3"));
	reg = new FileWriter(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt", false);
	reg.write("");
	reg.flush();
	reg = new FileWriter(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt", true);
	reg.write("Data: " + fmtDate.format(now.getTime()) + " - Horas: " + fmtHour.format(now.getTime()) + "\n\n"
	        + "===========================================================\n"
	        + "::::::::::::: Registros do Teste Automatizado :::::::::::::\n"
	        + "===========================================================\n\n"
	        + "+---------------------------------------------------------+\n"
	        + "| Funcionalidade: Criar Experimento na PlatIAgro          |\n"
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
    Thread.sleep(1000)
    WebDriverWait wait = new WebDriverWait(browser.driver, 30);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-message-notice-content")));
  }

}

E(/o sistema abra um modal, com o nome {string} selecionado/) { String nameProj ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-modal-content"))).isDisplayed();

  String nomeProj = $(By.xpath("//*[@value='Novo Projeto']")).toString();
  assert nomeProj.contains(nameProj)

}

E(/o usuário limpar o campo nome do projeto/) { ->

  waitFor(10) {
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    page.campnome.value(del)
  }

}

E(/nomear o projeto inicialmente com: {string}/) { String nomeEd ->

  def nomeProj = nomeEd + " " + NumberGerador.number()

  waitFor(10) {
    page.campnome.value(nomeProj)
  }

  repo.add("Nome Projeto", nomeProj)

  //Armazena o nome do projeto gerado para ser utilizado por outros cenários
	reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt"), true);
	reg.write("+---------------------------------------------------------+\n"
			    + "| Nome do projeto criado: " + nomeProj + "                   |\n"
			    + "+---------------------------------------------------------+\n");
	reg.close();

}

E(/inserir a seguinte informação na descrição: {string}/) { String desc ->

  waitFor(30) {
    page.campDesc.value(desc)
  }
  
}

E(/efetuar o clique no botão Criar/) { ->
  
  WebElement element = browser.driver.findElement(By.className("ant-modal-footer"));
  JavascriptExecutor jse = (JavascriptExecutor)browser.driver;
  //String assets = (String) jse.executeScript("return arguments[0].getElementsByTagName('button')[1].textContent;", element);
  jse.executeScript("arguments[0].getElementsByTagName('button')[1].click();", element);

}

E(/o novo projeto será registrado/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();

  String projNome = "Projeto " + repo.get("Nome Projeto") + " criado!"
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[contains(text(), '"+projNome+"')]"), projNome));

  /*String projNome = "Projeto " + repo.get("Nome Projeto") + " criado!"
  String displaySucess = $(By.xpath("//*[contains(text(), '"+projNome+"')]")).text()

  Assert.assertEquals(projNome, displaySucess);*/

}

E(/o usuário será direcionado para a página de detalhes do projeto/) { ->

  assert $(By.className("project-details")).isDisplayed()

  Thread.sleep(1000)
   
}

E(/clicar no card Experimento/) { ->

  waitFor(30) {
    page.cardExp.click()
  }

  Thread.sleep(2000)

  String search = browser.driver.findElement(By.xpath("//*[@id='root']/section/section/section/aside/div/div/ul/li[1]/div[1]/span/span[2]")).getAttribute("innerHTML");
  if (search.equals("Templates")) {
    at PageExperimento

    waitFor(30) {
      page.selectTemplate.click()
    }

    Thread.sleep(2000)
  
    WebElement template = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[1]/ul/li/div/div[2]/span"));
    Actions action = new Actions(browser.driver);
    action.contextClick(template).build().perform();

    waitFor(30) {
      page.remover.click()
    }
    Thread.sleep(1000)
    WebDriverWait wait = new WebDriverWait(browser.driver, 30);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-message-notice-content")));
  } else {
    WebDriverWait wait = new WebDriverWait(browser.driver, 30);
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='tab-title-custom']"), 'Experimento 1'));
  }
   
}

E(/verificar se um novo experimento será criado, nomeado como: {string}/) { String nomeExp ->

  String expName = $(By.xpath("//*[@class='tab-title-custom'][contains(text(), 'Experimento 1')]")).toString();
  assert expName.contains(nomeExp)
   
}

E(/os botões acima da tela do fluxo de experimentação estarão desabilitados/) { ->

  // Validando a presença do atributo 'disabled'
  assert browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[1]")).getAttribute("disabled")

  assert browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[2]")).getAttribute("disabled")
  
  // Utilizando 'isEnabled' para validar se o elemento está habilitado
  Boolean isButton_I = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[1]")).isEnabled()
  assert isButton_I == false
  Assert.assertFalse(isButton_I)

  Boolean isButton_II = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[2]")).isEnabled()
  assert isButton_II == false
  Assert.assertFalse(isButton_II)

  Thread.sleep(1000)
   
}

Quando(/o usuário selecionar o Menu Conjunto de Dados/) { ->
  at PageExperimento

  waitFor(30) {
    page.menuConjunto.click()
  }
   
}

E(/selecionar e arrastar o operador Upload de arquivos para o fluxo/) { ->

  Thread.sleep(1000)
  
  WebElement source = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[2]/ul/li[2]/div/div[2]/span"));
  WebElement destination = browser.driver.findElement(By.cssSelector("#root > section > section > section > main > section > main > div.custom-flow > div.experiment-flow > div > div.OperatorsEmptyContainer.experiment-flow-empty-operators > img"));
  JavascriptExecutor jse = (JavascriptExecutor)browser.driver;
  jse.executeScript("function createEvent(typeOfEvent) {\n" +"var event =document.createEvent(\"CustomEvent\");\n" +"event.initCustomEvent(typeOfEvent,true, true, null);\n" +"event.dataTransfer = {\n" +"data: {},\n" +"setData: function (key, value) {\n" +"this.data[key] = value;\n" +"},\n" +"getData: function (key) {\n" +"return this.data[key];\n" +"}\n" +"};\n" +"return event;\n" +"}\n" +"\n" +"function dispatchEvent(element, event,transferData) {\n" +"if (transferData !== undefined) {\n" +"event.dataTransfer = transferData;\n" +"}\n" +"if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n" +"} else if (element.fireEvent) {\n" +"element.fireEvent(\"on\" + event.type, event);\n" +"}\n" +"}\n" +"\n" +"function simulateHTML5DragAndDrop(element, destination) {\n" +"var dragStartEvent =createEvent('dragstart');\n" +"dispatchEvent(element, dragStartEvent);\n" +"var dropEvent = createEvent('drop');\n" +"dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n" +"var dragEndEvent = createEvent('dragend');\n" +"dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" +"}\n" +"\n" +"var source = arguments[0];\n" +"var destination = arguments[1];\n" +"simulateHTML5DragAndDrop(source,destination);",source, destination);

}

E(/selecionar o operador novamente/) { ->
  at PageExperimento

  waitFor(10) {
    page.operadorUpArq.click()
  }

  Thread.sleep(2000)
   
}

E(/no drawer de propriedades selecionar o botão Importar/) { ->

  WebElement elementoBase = browser.driver.findElement(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/span/div[1]/span/div/button[1]/span[2]"));
  Actions action = new Actions(browser.driver);
  action.moveToElement(elementoBase).build().perform();

  Thread.sleep(2000)

}

E(/o usuário irá informar o arquivo {string} para importar os dados de entrada/) { String arquivo ->

  waitFor(30) {
    page.inputFile.value(filePath + caminho + arquivo) //upload do arquivo de entrada
  }

  Thread.sleep(5000)

}

E(/selecionar o botão Visualizar Dados/) { ->

  waitFor(30) {
    page.btnVisualizar.click()
  }

  Thread.sleep(2000)

}

Então(/a tela de visualização de dados vai ser aberta/) { ->

  assert $(By.className("ant-modal-content")).isDisplayed() 
  
  assert $(By.xpath("//*[contains(text(), 'Visualizar dados')]")).toString()

}