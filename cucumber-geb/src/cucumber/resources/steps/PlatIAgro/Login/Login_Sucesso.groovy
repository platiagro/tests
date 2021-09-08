import pages.*

import static cucumber.api.groovy.PT.*
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

import org.apache.commons.io.FileUtils

import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Random
import java.util.Date
import java.util.TimeZone

FileWriter reg;
Date now = new Date();
SimpleDateFormat fmtDate = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat fmtHour = new SimpleDateFormat("HH:mm");

/*File file = new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/dataInput/ambiente.txt");

if (file.exists()) {
  file.delete();
}*/

Dado(/que o usuário inquira a abertura do browser/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  browser.driver.manage().window().maximize()

}

E(/acesse a plataforma PlatIAgro/) { ->

  // Registra o ambiente de teste
  /*fmtHour.setTimeZone(TimeZone.getTimeZone("GMT-3"));
  reg = new FileWriter(System.getProperty("user.dir") + "/src/cucumber/resources/helper/dataInput/ambiente.txt", false);
  reg.write("");
  reg.flush();
  reg = new FileWriter(System.getProperty("user.dir") + "/src/cucumber/resources/helper/dataInput/ambiente.txt", true);
  reg.write("Data: " + fmtDate.format(now.getTime()) + " - Horas: " + fmtHour.format(now.getTime()) + "\n\n"
	        + "===========================================================\n"
	        + ":::::::::::::::::: Registros do Ambiente ::::::::::::::::::\n"
	        + "===========================================================\n\n"
          + "+---------------------------------------------------------+\n"
          + "| Ambiente: platiagro@awsplatiagro17                      |\n"
          + "+---------------------------------------------------------+\n"
          + "+---------------------------------------------------------+\n"
          + "| URL: https://awsplatiagro17.aquarius.cpqd.com.br/       |\n"
          + "+---------------------------------------------------------+\n");
  reg.close();

  Thread.sleep(2000)*/

  to PageLogin

}

E(/seja apresentado um painel de {string}/) { String login ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("theme-panel-right"))).isDisplayed();
  wait.until(ExpectedConditions.titleIs('PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio'));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("theme-heading"), login));

  /*def title = browser.driver.getTitle();
  println " --> Título: " + title
  println ""*/

}

E(/preecha o campo Usuário com a credencial: {string}/) { String username ->
  at PageLogin

  waitFor(30){
    page.user.value(username)
  }

}

E(/também preencher o campo Senha informando: {string}/) { String password ->

  waitFor(30){
    page.senha.value(password)
  }

}

Quando(/realizar o clique no botão Entrar/){ ->

  waitFor(30){
    page.btnInput.click()
  }

}

Então(/a tela inicial da plataforma será exibida com sucesso/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-layout"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("user-info-component "))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("custom-edit-title"), 'Meus projetos'));

}