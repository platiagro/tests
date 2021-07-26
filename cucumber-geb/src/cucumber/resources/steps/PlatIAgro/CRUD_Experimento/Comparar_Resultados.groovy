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

import org.sikuli.script.Key
import org.sikuli.script.Match
import org.sikuli.script.Screen
import org.sikuli.script.Pattern
import org.sikuli.basics.Settings

Screen screen = new Screen();
Settings.ActionLogs = null != null;

Dado(/que o usuário selecione um projeto com N Experimentos/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt")).get(10).substring(26).split("\\|")[0].trim();
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProj+"']")).click()
  }

  Thread.sleep(2000)

}

E(/na página onde há os experimentos do projeto selecionar o botão Comparar Resultados/) { ->
  at PageExperimento

  waitFor(30) {
    page.cardExperimento.click()
  }

  waitFor(30) {
    page.btnComp.click()
  }

}

E(/o sistema abrir a tela {string}/) { String compResul ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-modal-content"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#rcDialogTitle0 > div > div:nth-child(1) > span > strong"), compResul));

  Thread.sleep(2000)

}

E(/selecionar o botão Adicionar Resultado/) { ->
  at PageExperimento

  page.btnAddResult.click()

  Thread.sleep(1000)

  page.btnAddResult.click()

}

Quando(/selecionar os experimentos em conjunto com as tarefas para comparação/) { ->
  at PageExperimento

  waitFor(30) {
    page.btnSelectExp_I.click()
  }

  for (int i=0; i<=1; i++){
    screen.type(Key.DOWN);
  }
  Thread.sleep(1000)
  screen.type(Key.RIGHT);
  screen.type(Key.ENTER);

  Thread.sleep(2000)

  for (int i=0; i<=1; i++){
    screen.type(Key.TAB);
  }
  for (int i=0; i<=1; i++){
    screen.type(Key.DOWN);
  }
  screen.type(Key.ENTER);

  Thread.sleep(2000)

  waitFor(30) {
    page.btnSelectExp_II.click()
  }

  screen.type(Key.DOWN);
  Thread.sleep(1000)
  screen.type(Key.RIGHT);
  screen.type(Key.ENTER);

  Thread.sleep(2000)

  for (int i=0; i<=1; i++){
    screen.type(Key.TAB);
  }
  for (int i=0; i<=2; i++){
    screen.type(Key.DOWN);
  }
  screen.type(Key.ENTER);

  Thread.sleep(2000)

}

Então(/será exibido os resultados, as métricas e os parâmetros da tarefa selecionada/) { ->

  Pattern image1 = new Pattern(System.getProperty("user.dir") + "/src/cucumber/resources/helper/images/Image9.png");
  Pattern image2 = new Pattern(System.getProperty("user.dir") + "/src/cucumber/resources/helper/images/Image10.png");

  Match m1 = screen.exists (image1);
	Match m2 = screen.exists (image2);
	while (m1 != null || m2 != null){
		if (true){				
			break;					
		} else {
      return false
		}
	}

}