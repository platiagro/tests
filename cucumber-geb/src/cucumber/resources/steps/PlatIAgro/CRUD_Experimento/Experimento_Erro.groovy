import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.interactions.Actions
import org.testng.Assert
import org.apache.commons.io.FileUtils

import org.sikuli.script.Key
import org.sikuli.script.Match
import org.sikuli.script.Pattern
import org.sikuli.script.Screen
import org.sikuli.basics.Settings

import helper.utility.NumberGerador

Screen screen = new Screen();
Settings.ActionLogs = null != null;

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

  Thread.sleep(2000)

  at PageExperimento

  waitFor(30) {
    page.cardExperimento.click()
  }

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

  WebElement elementoBase = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[2]/ul/li[2]/div/div[2]/span"));
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
	}

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

  Thread.sleep(2000)

}

E(/informar o arquivo {string} para importar os dados de entrada/) { String arquivo ->

  waitFor(30) {
    page.inputFile.value(filePath + caminho + arquivo) //upload do arquivo de entrada
  }

  Thread.sleep(5000)

}

E(/selecionar o menu Treinamento/) { ->
  at PageExperimento

  waitFor(30) {
    page.menuTreinamento.click()
  }

  Thread.sleep(2000)
   
}

E(/adicionar a tarefa Regressão Linear ao fluxo/) { ->

  screen.type(Key.PAGE_DOWN);

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
	}

    at PageExperimento

    waitFor(30) {
      page.selRegLinear.click()
    }

    Thread.sleep(2000)

}

E(/no drawer de propriedade da tarefa selecione no campo Atributo Alvo o atributo label/) { ->
  at PageExperimento

  waitFor(30) {
    page.campoAtrAlvo.click()
  }

  screen.type(Key.ENTER);

  Thread.sleep(2000)

}

E(/no campo Features para incluir-remover no modelo selecionar o atributo text/) { ->
  at PageExperimento

  waitFor(30) {
    page.campoFeature.click()
  }

  screen.type(Key.DOWN);
  screen.type(Key.ENTER);

  Thread.sleep(2000)

}

E(/no campo Features para fazer codificação ordinal selecionar o atributo is_valid/) { ->
  at PageExperimento

  waitFor(30) {
    page.campoCodeOrd.click()
  }
  
  for (int i=0; i<=1; i++){
    screen.type(Key.DOWN);
  }
  screen.type(Key.ENTER);

  Thread.sleep(2000)

}

Quando(/clicar no botão Executar/) { ->

  WebElement sourceEle  = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div[1]/div/div/div[3]/div"));
  WebElement targetEle = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div[1]/div[1]"));
  Actions action = new Actions(browser.driver);
  action.dragAndDrop(sourceEle, targetEle).build().perform();

  Thread.sleep(2000)

  at PageExperimento

  waitFor(30) {
    page.btnExecut.click()
  }

  Thread.sleep(50000)

}

Então(/a execução não será finalizada, com a platforma sinalizadando a Tarefa com erro/) { ->

  //screen.type(Key.F5, Key.CTRL);

  WebDriverWait wait = new WebDriverWait(browser.driver, 60);
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
    $(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div[2]/div")).click()
  }

  waitFor(30) {
    page.btnJupyter.click()
  }

  List<String> abas = new ArrayList<>(browser.driver.getWindowHandles());
  browser.driver.switchTo().window(abas.get(1));

  WebDriverWait wait = new WebDriverWait(browser.driver, 60);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div[2]/div[3]/div[4]/div[2]/div[1]/div[2]/div[2]/div[3]/p/span")));

  for (int i=0; i<=17; i++){
    screen.type(Key.DOWN);
  }
  
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[3]/div[2]/div[3]/div[4]/div[2]/div[19]/div[2]/div[2]/div[3]/p/span")));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[3]/div[3]/div[2]/div[3]/div[4]/div[2]/div[19]/div[2]/div[2]/div[3]/p/span"), 'Execution using papermill encountered an exception here and stopped:'));
  
  Thread.sleep(2000)

}