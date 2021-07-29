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

Dado(/que o usuário selecione um projeto da lista/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt")).get(10).substring(26).split("\\|")[0].trim();
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span/span[text()='"+nomeProj+"']")).click()
  }

}

E(/efetue o clique no card experimento/) { ->

  waitFor(30) {
    page.cardExp.click()
  }

  Thread.sleep(2000)

}

E(/clique com o botão direito na aba do experimento/) { ->

  WebElement abaNome = browser.driver.findElement(By.xpath("//*[@class='tab-title-custom'][contains(text(), 'Experimento Alter')]"));
  Actions action = new Actions(browser.driver);
  action.contextClick(abaNome).build().perform();

}

E(/selecione a opção Duplicar/) { ->

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/section/main/section/footer/div/nav/span[2]/div/div/span[2]")).click()
  }

  Thread.sleep(2000)

}

E(/um modal seja aberto/) { ->

  def modal = $(By.className("ant-popover-inner-content")).isDisplayed()
  assert modal == true

}

E(/insira o seguinte nome para a duplicata: {string}/) { String nameDupl ->

  waitFor(30) {
    $(By.className("ant-input")).value(nameDupl)
  }

  repo.add("Nome Experimento Duplicado", nameDupl)

  //Armazena o nome do experimento duplicado para controle
  reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt"), true);
  reg.write("+---------------------------------------------------------+\n"
		  + "| Nome do experimento duplicado: " + nameDupl + "      |\n"
		  + "+---------------------------------------------------------+\n");
  reg.close();

}

E(/realizar o clique no botão OK/) { ->
  at PageExperimento

  waitFor(30) {
    page.btnOK.click()
  }

  Thread.sleep(2000)

}

E(/para o modal haverá o reset/) { ->

  def modal = $(By.className("ant-popover-inner-content")).isDisplayed()
  assert modal == false

}

E(/o Experimento será duplicado/) { ->

  String meuExperimentoDuplicado = repo.get("Nome Experimento Duplicado");
  String myExperimentDuplicate = $(By.xpath("/html/body/div[1]/section/section/section/main/section/footer/div/div/div[1]/div[1]/div/div[2]/div/div/div/div")).text();
  assert meuExperimentoDuplicado.contains(myExperimentDuplicate)

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-message-notice-content")));

}

Quando(/o usuário selecionar o botão Executar na aba da duplicata do experimento/) { ->

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[1]/button[3]/span")).click()
  }
  
  at PageExperimento

  waitFor(30) {
    page.btnExecut.click()
  }

}

Então(/o sistema enviará a seguinte mensagem: {string}/) { String msg ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).text()

  Thread.sleep(5000)

}

E(/o botão Salvar como Template será desabilitado e aparecerá a função para {string}/) { String interrupt ->

  // Validando a presença do atributo "disabled" para o botão 'Salvar como Template'
  Boolean isButton = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[1]")).isEnabled()
  Assert.assertFalse(isButton)

  // Validando a presença do botão 'interromper'
  assert $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[2]/span[text()='"+interrupt+"']")).isDisplayed()

  Thread.sleep(5000)

}

E(/após efetivação cada tarefa será sinalizada como {string}/) { String success ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 70);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();

  assert $(By.xpath("//*[contains(text(), '"+success+"')]")).text()

  Thread.sleep(2000)

}

E(/os botões acima do fluxo de experimento serão habilitados/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 70);
  WebElement element = browser.driver.findElement(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[1]"));
  wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
  wait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();

}