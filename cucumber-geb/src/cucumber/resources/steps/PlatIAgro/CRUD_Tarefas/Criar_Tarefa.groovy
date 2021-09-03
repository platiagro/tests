import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
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

Dado(/que o usuário selecione o botão Nova Tarefa/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  // Registra o cenário de teste
	fmtHour.setTimeZone(TimeZone.getTimeZone("GMT-3"));
	reg = new FileWriter(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt", false);
	reg.write("");
	reg.flush();
	reg = new FileWriter(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt", true);
	reg.write("Data: " + fmtDate.format(now.getTime()) + " - Horas: " + fmtHour.format(now.getTime()) + "\n\n"
	        + "===========================================================\n"
	        + "::::::::::::: Registros do Teste Automatizado :::::::::::::\n"
	        + "===========================================================\n\n"
	        + "+---------------------------------------------------------+\n"
	        + "| Funcionalidade: Criar Tarefa na PlatIAgro               |\n"
	        + "+---------------------------------------------------------+\n");
	reg.close();

  waitFor(30) {
    page.btnTarefa.click()
  }

}

Quando(/criar tarefa a partir de um template em branco/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("task-template-item-title"), 'Em Branco'));

  at PageTarefa

  waitFor(30) {
    page.btnCreateTask.click()
  }

}

Então(/a plataforma exibirá o seguinte display: {string}/) { String msgSuccess ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Criando Nova Tarefa')]")));
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-notice-content"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(), 'Tarefa criada com sucesso.')]"), msgSuccess));

}

E(/o nome default da tarefa será: {string}/) { String nameTask ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/section/section/div/div[1]/div/div/span/div/h3/span"), nameTask));

  def taskName = $(By.xpath("/html/body/div[1]/section/section/div/div[1]/div/div/span/div/h3/span")).text()
  repo.add("Nome Tarefa", taskName)

  //Armazena o nome da tarefa gerado por default para ser utilizado por outros cenários
	reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt"), true);
	reg.write("+---------------------------------------------------------+\n"
			    + "| Nome da tarefa por default: " + taskName + "        |\n"
			    + "+---------------------------------------------------------+\n");
	reg.close();

}

E(/os seguintes campos estarão presentes para entrada de dados: {string}, {string}, {string}, {string}, {string} e {string}/) { String description, String category, String inputData, String outputData, String searchTags, String documentation ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='task-details-page-content-form-field-label'][text()='"+description+"']"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='DESCRIPTION'][contains(@placeholder, 'Adicionar Descrição')]"))).isDisplayed();

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='task-details-page-content-form-field-label'][text()='"+category+"']"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ant-select-selection-item'][contains(@title, 'Minhas Tarefas')]"))).isDisplayed();

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div[1]/div[3]/label/span[text()='"+inputData+"']"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='INPUT_DATA'][contains(@placeholder, 'Adicionar dados de entrada')]"))).isDisplayed();

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div[1]/div[4]/label/span[text()='"+outputData+"']"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='OUTPUT_DATA'][contains(@placeholder, 'Adicionar dados de saída')]"))).isDisplayed();

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div[1]/div[5]/label/span[text()='"+searchTags+"']"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@value, 'DEFAULT')]"))).isDisplayed();

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='task-details-page-content-form-field-label'][text()='"+documentation+"']"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='DOCUMENTATION'][contains(@placeholder, 'Adicionar documentação')]"))).isDisplayed();

}

E(/a tarefa criada será adicionada na lista de tarefas de acordo com a ordenação alfabética/) { ->

  waitFor(30) {
    $(By.className("ant-page-header-back-button")).click()
  }

  waitFor(30) {
    $(By.xpath("//*[contains(@title, '4')]")).click()
  }

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  def tarefaNome = repo.get("Nome Tarefa")
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span/span[text()='"+tarefaNome+"']"))).isDisplayed();

  assert $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span/span[text()='"+tarefaNome+"']")).isDisplayed()
   
}

E(/as informações das tarefas estarão divididas em quatro colunas: {string}, {string}, {string} e {string}/) { String nomeTarefa, String desc, String origem, String action -> 
  
  assert $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[1]/div/span[1]/strong[text()='"+nomeTarefa+"']")).isDisplayed()

  assert $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[2]/strong[text()='"+desc+"']")).isDisplayed()

  assert $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[3]/strong[text()='"+origem+"']")).isDisplayed()

  assert $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[4]/strong[text()='"+action+"']")).isDisplayed()

}