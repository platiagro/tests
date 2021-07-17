import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
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

Dado(/que o usuário clique no botão Novo Projeto/) { ->

  for (int i=0; i<2; i++){
    println " "
	}

  // Registra o cenário de teste
	fmtHour.setTimeZone(TimeZone.getTimeZone("GMT-3"));
	reg = new FileWriter(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt", false);
	reg.write("");
	reg.flush();
	reg = new FileWriter(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt", true);
	reg.write("Data: " + fmtDate.format(now.getTime()) + " - Horas: " + fmtHour.format(now.getTime()) + "\n\n"
	        + "===========================================================\n"
	        + "::::::::::::: Registros do Teste Automatizado :::::::::::::\n"
	        + "===========================================================\n\n"
	        + "+---------------------------------------------------------+\n"
	        + "| Funcionalidade: Criar Projeto na PlatIAgro              |\n"
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
    WebDriverWait wait = new WebDriverWait(browser.driver, 30);
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-message-notice-content")));
  }

}

E(/o sistema abra um modal com o nome {string} selecionado/) { String nameProj ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-modal-content"))).isDisplayed();

  String nomeProj = $(By.xpath("//*[@value='Novo Projeto']")).toString();
  assert nomeProj.contains(nameProj)

}

E(/limpe o campo nome do projeto/) { ->

  waitFor(10) {
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    page.campnome.value(del)
  }

}

E(/nomear o projeto com o nome inicial de: {string}/) { String nomeEd ->

  def nomeProj = nomeEd + " " + NumberGerador.number()

  waitFor(10) {
    page.campnome.value(nomeProj)
  }

  repo.add("Nome Projeto", nomeProj)

  //Armazena o nome do projeto gerado para ser utilizado por outros cenários
	reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt"), true);
	reg.write("+---------------------------------------------------------+\n"
				  + "| Projeto de teste 1: " + nomeProj + "                       |\n"
				  + "+---------------------------------------------------------+\n");
	reg.close();

}

E(/informar a seguinte descrição: {string}/) { String desc ->

  waitFor(30) {
    page.campDesc.value(desc)
  }

  repo.add("Descrição", desc)
  
}

Quando(/clicar no botão Criar/) { ->

  waitFor(30) {
    page.btnConfirm.click()
  }

}

E(/o novo projeto será criado/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();

  String projNome = "Projeto " + repo.get("Nome Projeto") + " criado!"
  String displaySucess = $(By.xpath("//*[contains(text(), '"+projNome+"')]")).text()

  Assert.assertEquals(projNome, displaySucess);

}

E(/o usuário será direcionado para a página Detalhes do projeto/) { ->

  assert $(By.className("project-details")).isDisplayed()
   
}

E(/será apresentado os seguintes dados: {string}, {string} e {string}/) { String desc, String lastMod, String created ->
  
  String description = $(By.xpath("//*[@id='root']/section/section/section/aside/div/div/div[1]/strong")).text().trim();
  assert description.contains(desc)

  String descProj = repo.get("Descrição")
  String projDesc = $(By.xpath("//*[@id='root']/section/section/section/aside/div/div/div[1]/p")).text();
  Assert.assertEquals(descProj, projDesc);


  String lastModification = $(By.xpath("//*[@id='root']/section/section/section/aside/div/div/div[2]/strong")).text().trim();
  assert lastModification.contains(lastMod)

  String createdBy = $(By.xpath("//*[@id='root']/section/section/section/aside/div/div/div[3]/strong")).text().trim();
  assert createdBy.contains(created)

}

E(/nessa página poderá escolher se deseja iniciar um fluxo de {string} ou {string}/) { String exper, String implant ->
  
  String experimentation = $(By.xpath("//*[@id='root']/section/section/section/main/section/div/div[1]/div[1]/div/div/span[1]")).text();
  assert experimentation.contains(exper)

  String preImplantation = $(By.xpath("//*[@id='root']/section/section/section/main/section/div/div[1]/div[2]/div/div/span[1]")).text();
  assert preImplantation.contains(implant)

}

E(/selecionar o card Experimento/) { ->

  waitFor(30) {
    page.cardExp.click()
  }

  Thread.sleep(2000)

}

E(/o usuário será direcionado para a página do projeto onde poderá iniciar um novo fluxo de experimento: {string}/) { String experiment -> 
  
  assert $(By.xpath("//*[@id='root']/section/section/div/div/div/span[2]/div/button/span[text()='"+experiment+"']")).isDisplayed()

}

Então(/o usuário ao retornar para a página {string} deverá observar se o novo projeto foi adicionado à lista de projetos/) { String myProj ->

  browser.driver.get("https://awsplatiagro02.aquarius.cpqd.com.br/projetos");

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='root']/section/section/div[1]/div/div/span/div/div/h3"), myProj));

  def projNome = repo.get("Nome Projeto")
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span"), projNome));

  for (int i=2; i<=5 ; i++){
     waitFor(30) {
      $(By.xpath("//*[@id='root']/section/section/div[2]/button/span[2]")).click()
    }

    waitFor(10) {
      String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
      page.campnome.value(del)
    }

    def nomeProj = "Teste " + NumberGerador.number()

    waitFor(10) {
      page.campnome.value(nomeProj)
    }

    //Armazena o nome do projeto gerado para conferência na exclusão
	  reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt"), true);
	  reg.write("+---------------------------------------------------------+\n"
			      + "| Projeto de teste " + i + ": " + nomeProj + "                       |\n"
			      + "+---------------------------------------------------------+\n");
	  reg.close();

    waitFor(10) {
      page.campDesc.value("Teste - Funcionalidade: Criar projeto")
    }

    waitFor(10) {
      page.btnConfirm.click()
    }

    Thread.sleep(2000)

    assert $(By.className("ant-message-success")).isDisplayed()

    Thread.sleep(1000)

    browser.driver.get("https://awsplatiagro02.aquarius.cpqd.com.br/projetos");
  }

}

E(/deverá estar divididos em cinco colunas: {string}, {string}, {string}, {string} e {string}/) { String nomeProjeto, String descricion, String tags, String modLast, String action -> 
  
  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[2]/div/span[1]/strong[text()='"+nomeProjeto+"']")).isDisplayed()

  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[3]/strong[text()='"+descricion+"']")).isDisplayed()

  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[4]/div/span[1]/strong[text()='"+tags+"']")).isDisplayed()

  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[5]/div/div/span[1]/strong[text()='"+modLast+"']")).isDisplayed()

  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[6]/strong[text()='"+action+"']")).isDisplayed()

  Thread.sleep(2000)

}