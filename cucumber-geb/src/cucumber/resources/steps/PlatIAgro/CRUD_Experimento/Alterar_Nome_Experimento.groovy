import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.apache.commons.io.FileUtils

import java.awt.Robot
import java.awt.event.KeyEvent

Robot robot = new Robot();

Dado(/que o usuário selecione um projeto presente na listagem/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt")).get(10).substring(26).split("\\|")[0].trim();
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span/span[text()='"+nomeProj+"']")).click()
  }

}

E(/selecione o card experimento/) { ->

  waitFor(30) {
    page.cardExp.click()
  }

  Thread.sleep(2000)

}

E(/clicar com o botão direito em cima do nome/) { ->

  WebElement abaNome = browser.driver.findElement(By.xpath("//*[@class='tab-title-custom'][contains(text(), 'Experimento 1')]"));
  Actions action = new Actions(browser.driver);
  action.contextClick(abaNome).build().perform();

}

E(/selecionar a opção Renomear/) { ->

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/section/main/section/footer/div/nav/span[1]/div/div/span[2]")).click()
  }

  Thread.sleep(2000)

}

E(/haverá a abertura de um modal/) { ->

  def modal = $(By.className("ant-popover-inner-content")).isDisplayed()
  assert modal == true

}

E(/o usuário deverá limpar o campo/) { ->

  robot.keyPress(KeyEvent.VK_CONTROL);
  robot.keyPress(KeyEvent.VK_A);
  robot.keyPress(KeyEvent.VK_DELETE);

}

E(/alterar o nome do experimento acrescentando ao final: {string}/) { String nameAlter ->

  def nomeExpAlter = "Experimento " + nameAlter

  waitFor(30) {
    $(By.className("ant-input")).value(nomeExpAlter)
  }

  repo.add("Nome Experimento Alterado", nomeExpAlter)

  //Armazena o nome do experimento alterado para controle
  reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt"), true);
  reg.write("+---------------------------------------------------------+\n"
		      + "| Nome do experimento alterado: " + nomeExpAlter + "         |\n"
		      + "+---------------------------------------------------------+\n");
  reg.close();

}

Quando(/clicar no botão OK/) { ->
  at PageExperimento

  waitFor(30) {
    page.btnOK.click()
  }

  Thread.sleep(2000)

}

Então(/o modal será resetado/) { ->

  def modal = $(By.className("ant-popover-inner-content")).isDisplayed()
  assert modal == false

}

E(/o nome do experimento será alterado com sucesso/) { ->

  String meuExperimentoAlterado = repo.get("Nome Experimento Alterado");
  String myExperimentAlter = $(By.xpath("/html/body/div[1]/section/section/section/main/section/footer/div/div/div[1]/div[1]/div/div[1]/div/div/div/div")).text();
  assert meuExperimentoAlterado.contains(myExperimentAlter)

  Thread.sleep(2000)

}