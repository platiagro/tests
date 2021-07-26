import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.testng.Assert
import org.apache.commons.io.FileUtils

import org.sikuli.script.Key
import org.sikuli.script.Match
import org.sikuli.script.Pattern
import org.sikuli.script.Screen
import org.sikuli.basics.Settings

import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Random
import java.util.Date
import java.util.TimeZone

import helper.utility.NumberGerador

FileWriter reg;
Screen screen = new Screen();
Settings.ActionLogs = null != null;
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

  for (int i=0; i<=1; i++){
    screen.type(Key.TAB);
  }
  screen.type(Key.ENTER);

  Thread.sleep(1000)

  /*waitFor(30) {
    page.btnConfirm.click()
  }*/

}

E(/o novo projeto será registrado/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();

  String projNome = "Projeto " + repo.get("Nome Projeto") + " criado!"
  String displaySucess = $(By.xpath("//*[contains(text(), '"+projNome+"')]")).text()

  Assert.assertEquals(projNome, displaySucess);

}

E(/o usuário será direcionado para a página de detalhes do projeto/) { ->

  assert $(By.className("project-details")).isDisplayed()

  Thread.sleep(1000)
   
}

E(/clicar no card Experimento/) { ->
  at PageExperimento

  waitFor(30) {
    page.cardExperimento.click()
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
      /*def simulateDragDrop = '''
        function createCustomEvent(type) {
            var event = new CustomEvent("CustomEvent");
            event.initCustomEvent(type, true, true, null);
            event.dataTransfer = {
                data: { pos: {x:0, y:2}
                },
                setData: function(type, val) {
                    this.data[type] = val;
                },
                getData: function(type) {
                    return this.data[type];

                },
           
                dropEffect: 'move'
           
            };
            return event;
        }

        function dispatchEvent(node, type, event) {
            console.log(node); 
           
            console.log(event);
           
            if (node.dispatchEvent) {
                return node.dispatchEvent(event);
            }
            if (node.fireEvent) {
                return node.fireEvent("on" + type, event);
            }
        }

        function simulateDragDrop(sourceNode, destinationNode) {
            var EVENT_TYPES = { 
                DRAG_END: 'dragend', mousemove: 'mousemove',
                DRAG_START: 'dragstart',
                DROP: 'drop'
            };

            var event = createCustomEvent(EVENT_TYPES.DRAG_START);
            dispatchEvent(sourceNode, EVENT_TYPES.DRAG_START, event);
            
            console.log (event.dataTransfer);
            //event.dataTransfer.setData() = {x:0, y:2};

            var mousemoveEvent = document.createEvent('MouseEvent');
            mousemoveEvent.initMouseEvent(EVENT_TYPES.mousemove, true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null)
            dispatchEvent(sourceNode, EVENT_TYPES.mousemove, mousemoveEvent);
            
            var dropEvent = createCustomEvent(EVENT_TYPES.DROP);
            dropEvent.dataTransfer = event.dataTransfer;
            dispatchEvent(destinationNode, EVENT_TYPES.DROP, dropEvent);

            var dragEndEvent = createCustomEvent(EVENT_TYPES.DRAG_END);
            dragEndEvent.dataTransfer = event.dataTransfer;
            dispatchEvent(sourceNode, EVENT_TYPES.DRAG_END, dragEndEvent);
        }

        var source = document.getElementsByClassName('drag-icon')[1];
        var destination = document.getElementsByClassName('react-flow')[0];
        simulateDragDrop(source, destination);
      '''
      browser.driver.executeScript(simulateDragDrop)*/

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

E(/selecionar o operador novamente/) { ->
  at PageExperimento

  waitFor(30) {
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

  Thread.sleep(2000)

}