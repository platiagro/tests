import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.interactions.Actions
import org.testng.Assert
import org.apache.commons.io.FileUtils

import java.awt.Robot
import java.awt.event.KeyEvent

Robot robot = new Robot();

Dado(/que o usuário selecione um projeto da lista de Projetos/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt")).get(10).substring(26).split("\\|")[0].trim();
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span/span[text()='"+nomeProj+"']")).click()
  }

  at PageExperimento

  waitFor(30) {
    page.cardExperimento.click()
  }

}

E(/na página do experimento selecionar o botão Salvar como template/) { ->
  at PageExperimento

  waitFor(30) {
    page.btnSaveTempl.click()
  }

  Thread.sleep(2000)

}

E(/um modal será aberto pelo sistema/) { ->

  def modal = $(By.className("ant-modal-content")).isDisplayed()
  assert modal == true

}

E(/o nome {string} deve estar destacado/) { String newTempl ->

  String novoTemplate = $(By.xpath("//*[@value='Novo Template']")).toString();
  assert novoTemplate.contains(newTempl)

}

E(/limpar o campo nome do template/) { ->
  at PageExperimento

  waitFor(30) {
    page.btnLimpTemplate.click()
  }

  Thread.sleep(1000)

}

E(/a mensagem {string} deve ser exibida abaixo do campo nome/) { String msg ->

  assert $(By.className("ant-form-item-explain")).isDisplayed()

  String mensagem = $(By.xpath("//*[@id='newTemplateForm']/div/div[2]/div[2]/div")).text();
  assert mensagem.contains(msg)

}

E(/inserir o seguinte nome: {string}/) { String nomeTemplate ->
  at PageExperimento

  waitFor(10) {
    page.campTemplate.value(nomeTemplate)
  }

  repo.add("Nome Template", nomeTemplate)

  //Armazena o nome do projeto gerado para ser utilizado por outros cenários
	reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt"), true);
	reg.write("+---------------------------------------------------------+\n"
			+ "| Nome do template criado: " + nomeTemplate + "               |\n"
			+ "+---------------------------------------------------------+\n");
	reg.close();

  Thread.sleep(1000)

}

Quando(/selecionar o botão Salvar/) { ->

  for (int i=0; i<=1; i++){
    robot.keyPress(KeyEvent.VK_TAB);
  }
  robot.keyPress(KeyEvent.VK_ENTER);

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();

}

Então(/o menu Templates ficará visível no Armazém de Tarefas/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[1]/div[1]/span/span[2]"))).isDisplayed();

}

E(/o template será salvo nesse menu/) { ->
  at PageExperimento

  waitFor(30) {
    page.menuTemplates.click()
  }

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/section/section/aside/div/div/ul/li[1]/ul/li/div/div[2]/span"))).isDisplayed();

  Thread.sleep(2000)

}