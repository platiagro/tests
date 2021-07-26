import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.testng.Assert
import org.apache.commons.io.FileUtils

import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Random
import java.util.Date
import java.util.TimeZone

import org.sikuli.script.Key
import org.sikuli.script.Screen
import org.sikuli.basics.Settings

import helper.utility.NumberGerador

FileWriter reg;
Screen screen = new Screen();
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
    page.btntarefa.click()
  }

  Thread.sleep(2000)

}

E(/seja aberto um modal onde o Template em branco deve estar definido como default/) { ->

  assert $(By.className("ant-modal-content")).isDisplayed() 
  
  $(By.xpath("//*[contains(@title, 'Template em branco')]")).isDisplayed()

}

E(/haverá a opção de escolher um exemplo/) { ->

  /*for(String winHandle : browser.driver.getWindowHandles()){
	browser.driver.switchTo().window(winHandle);
  }

  browser.driver.switchTo().activeElement();*/

  browser.driver.executeScript("document.querySelector('#newTaskForm > div:nth-child(1) > div.ant-col.ant-form-item-control > div > div > div > div > span.ant-select-selection-item').click()")
  
  Settings.ActionLogs = null != null;
  screen.type(Key.ENTER);

  Thread.sleep(2000)

  def comboBox = $(By.className("rc-virtual-list-holder-inner")).isDisplayed()
  assert comboBox == true

  screen.type(Key.ENTER);

}

E(/nomear a Tarefa com o nome inicial de: {string}/) { String nomeEd ->

  def nomeTarefa = nomeEd + " " + NumberGerador.number()

  waitFor(10) {
    page.campnametask.value(nomeTarefa)
  }

  repo.add("Nome Tarefa", nomeTarefa)

  //Armazena o nome do projeto gerado para ser utilizado por outros cenários
	reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt"), true);
	reg.write("+---------------------------------------------------------+\n"
			    + "| Nome da tarefa criada: " + nomeTarefa + "           |\n"
			    + "+---------------------------------------------------------+\n");
	reg.close();

}

E(/inserir a Descrição: {string}/) { String desc ->

  waitFor(30) {
    page.campdesctask.value(desc)
  }

  repo.add("Descrição", desc)

  Thread.sleep(2000)
  
}

Quando (/clicar no botão Criar Notebooks/) { ->

  waitFor(10) {
    page.btnCriarTask.click()
  }

  Thread.sleep(1000)

}

Então(/o sistema exibirá a seguinte mensagem: {string}/) { String msgSuccess ->

  assert $(By.className("ant-message-success")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msgSuccess+"')]")).isDisplayed()

  Thread.sleep(1000)
   
}

E(/o modal será resetado e fechado/) { ->

  List<String> abas = new ArrayList<>(browser.driver.getWindowHandles());
  browser.driver.switchTo().window(abas.get(0));

  def modal = $(By.className("ant-modal-content")).isDisplayed()
  assert modal == false

}

E(/irá abrir uma nova tela do JupyterLab: {string}/) { String jupyter ->

  List<String> abas = new ArrayList<>(browser.driver.getWindowHandles());
  browser.driver.switchTo().window(abas.get(1));

  //browser.driver.switchTo().defaultContent();

  def labJupyter = $(By.xpath("/html/body/div/section/section/div/div/div[2]")).text()
  assert labJupyter == jupyter

  Thread.sleep(2000)

}

E(/a tarefa criada será adicionada na lista de tarefas de acordo com a ordenação alfabética/) { ->

  List<String> abas = new ArrayList<>(browser.driver.getWindowHandles());
  browser.driver.switchTo().window(abas.get(0));

  $(By.xpath("//*[contains(@title, '4')]")).click()

  def tarefaNome = repo.get("Nome Tarefa")
  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span[text()='"+tarefaNome+"']")).isDisplayed()

  Thread.sleep(2000)
   
}

E(/as informações das tarefas estarão divididas em quatro colunas: {string}, {string}, {string} e {string}/) { String nomeTarefa, String desc, String origem, String action -> 
  
  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[1]/div/span[1]/strong[text()='"+nomeTarefa+"']")).isDisplayed()

  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[2]/strong[text()='"+desc+"']")).isDisplayed()

  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[3]/strong[text()='"+origem+"']")).isDisplayed()

  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[4]/strong[text()='"+action+"']")).isDisplayed()

  Thread.sleep(2000)

}