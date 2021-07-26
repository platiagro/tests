import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.apache.commons.io.FileUtils

import org.sikuli.script.Key
import org.sikuli.script.Screen
import org.sikuli.basics.Settings

Screen screen = new Screen();

Dado(/que o usuário clique em Excluir, na coluna Ação, de uma Tarefa constante na lista/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    $(By.xpath("//*[contains(@title, '4')]")).click()
  }

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/div[3]/button/span[1]")).click()
  }

  waitFor(10){
    $(By.xpath("//*[contains(text(), 'Excluir')]")).click()
  }

  Thread.sleep(2000)

}

E(/o sistema deve abrir uma pop-up exibindo a mensagem: {string}/) { String msg ->

  assert $(By.className("ant-popconfirm")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

}

Quando(/o usuário confirmar a operação/) { ->

  waitFor(10) {
    page.btnsim.click()
  }

  Thread.sleep(2000)

}

Então (/a tarefa será excluída da lista/) { ->

  def nomeTarefa = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(10).substring(25).split("\\|")[0].trim();
  def projDelete = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span[text()='"+nomeTarefa+"']")).isDisplayed()                             
  assert projDelete == false

  Thread.sleep(2000)

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/div[3]/button/span[1]")).click()
  }

  waitFor(10){
    $(By.xpath("//*[contains(text(), 'Excluir')]")).click()
  }

  Thread.sleep(2000)

  /*waitFor(10) {
    $(By.xpath("//*[@class='ant-btn-sm'][text()='Sim']")).click()
  }*/

  Settings.ActionLogs = null != null;
  
  for (int i=0; i<=1; i++){
    screen.type(Key.TAB);
  }

  screen.type(Key.ENTER);

  Thread.sleep(1000)

}