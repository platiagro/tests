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

Screen screen = new Screen();
Settings.ActionLogs = null != null;

String filePath = System.getProperty ('user.dir')
String caminho = '/src/cucumber/resources/files/'

Dado(/que o usuário volte ao fluxo/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt")).get(10).substring(26).split("\\|")[0].trim();
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProj+"']")).click()
  }

  Thread.sleep(2000)

  at PageExperimento

  waitFor(30) {
    page.cardExperimento.click()
  }

}

E(/abra o menu Engenharia de Atributos/) { ->
  at PageExperimento

  waitFor(30) {
    page.menuEngAtributos.click()
  }

  Thread.sleep(2000)

}

E(/selecione a tarefa Seleção Manual de Atributos para adicionar ao fluxo/) { ->

  /*Thread.sleep(2000)
      def simulateDragDrop = '''
        function createCustomEvent(type) {
            var event = new CustomEvent("CustomEvent");
            event.initCustomEvent(type, true, true, null);
            event.dataTransfer = {
                data: {
                },
                setData: function(type, val) {
                    this.data[type] = val;
                },
                getData: function(type) {
                    return this.data[type];
                }
            };
            return event;
        }

        function dispatchEvent(node, type, event) {
            
            if (node.dispatchEvent) {
                return node.dispatchEvent(event);
            }
            
            if (node.fireEvent) {
                return node.fireEvent("on" + type, event);
            }
        }

        function simulateDragDrop(sourceNode, destinationNode) {
            var EVENT_TYPES = {
                DRAG_END: 'dragend',
                DRAG_START: 'dragstart',
                DROP: 'drop'
            };

            var event = createCustomEvent(EVENT_TYPES.DRAG_START);
            dispatchEvent(sourceNode, EVENT_TYPES.DRAG_START, event);

            var dropEvent = createCustomEvent(EVENT_TYPES.DROP);
            dropEvent.dataTransfer = event.dataTransfer;
            dispatchEvent(destinationNode, EVENT_TYPES.DROP, dropEvent);

            var dragEndEvent = createCustomEvent(EVENT_TYPES.DRAG_END);
            dragEndEvent.dataTransfer = event.dataTransfer;
            dispatchEvent(sourceNode, EVENT_TYPES.DRAG_END, dragEndEvent);
        }

         
        var source = document.getElementsByClassName('drag-icon')[8];
        var destination = document.getElementsByClassName('react-flow')[0]
        simulateDragDrop(source, destination);
      '''
      browser.driver.executeScript(simulateDragDrop)*/

  screen.type(Key.PAGE_DOWN);

  WebElement elementoBase = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[5]/ul/li[11]/div/div[2]/span"));
  Actions action = new Actions(browser.driver);
  action.clickAndHold(elementoBase).build().perform();

  Pattern image1 = new Pattern(System.getProperty("user.dir") + "/src/cucumber/resources/helper/images/Image4.png");
  Pattern image2 = new Pattern(System.getProperty("user.dir") + "/src/cucumber/resources/helper/images/Image5.png");
  Pattern image3 = new Pattern(System.getProperty("user.dir") + "/src/cucumber/resources/helper/images/Image6.png");

  screen.dragDrop(image1, image2);
  screen.waitVanish(image3);

  Match m1 = screen.exists(image3);
	while (m1 == null) {
    action.clickAndHold(elementoBase).build().perform();
    screen.dragDrop(image1, image2);
    Match m2 = screen.exists(image3);
    if (m2 != null) {
      break;
    }
	}

}

E(/clique na tarefa Seleção Manual de Atributos presente no fluxo/) { ->
  at PageExperimento

  waitFor(30) {
      page.selManAtributos.click()
  }

  Thread.sleep(2000)

}

E(/no drawer de propriedade da tarefa selecione no campo Features para Filtragem o item Species/) { ->
  at PageExperimento

  waitFor(30) {
    page.campoFeatFiltragem.click()
  }

  waitFor(30) {
    page.species.click()
  }

  Thread.sleep(2000)

}

E(/selecione o botão Executar/) { ->

  WebElement sourceEle  = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div[1]/div/div/div[3]/div"));
  WebElement targetEle = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div[1]/div[1]"));
  Actions action = new Actions(browser.driver);
  action.dragAndDrop(sourceEle, targetEle).build().perform();

  Thread.sleep(2000)

  at PageExperimento

  waitFor(60) {
    page.btnExecut.click()
  }

}

E(/o sistema enviar a seguinte mensagem: {string}/) { String msg ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).text()

  Thread.sleep(5000)

}

E(/confira se a função de salvar template estará desabilitada e o botão {string} sendo exibido/) { String interrupt ->

  // Validando a presença do atributo 'disabled'
  Boolean isButton = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[1]")).isEnabled()
  Assert.assertFalse(isButton)

  // Validando a presença do botão 'interromper'
  assert $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[2]/span[text()='"+interrupt+"']")).isDisplayed()

  Thread.sleep(5000)

}

E(/após a operação sendo concluída verificará que será sinalizada como {string}/) { String success ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 70);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();

  assert $(By.xpath("//*[contains(text(), '"+success+"')]")).text()

  Thread.sleep(2000)

}

E(/garantindo que os botões acima do fluxo de experimento serão habilitados/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 70);
  WebElement element = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[1]"));
  wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
  wait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();

}

Quando(/o usuário selecionar a tarefa Seleção Manual de Atributos/) { ->

  waitFor(30) {
    page.selManAtributos.click()
  }

}

E(/selecionar o botão Visualizar Resultados/) { ->

  waitFor(30) {
    page.btnVisuResult.click()
  }

  Thread.sleep(2000)

}

Então(/um modal será aberto/) { ->

  assert $(By.className("ant-modal-content")).isDisplayed()

  Thread.sleep(2000) 

}

E(/o usuário poderá visualizar o valor do Dataset e dos Parâmetros/) { ->

  waitFor(30) {
    page.abaDataset.click()
  }

  waitFor(30) {
    page.abaParametros.click()
  }

  Thread.sleep(2000)

}