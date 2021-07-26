import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.apache.commons.io.FileUtils


Dado(/que o usuário selecione vários projetos existentes na lista/) { ->
  at PageProj

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/label/span/input")).click()
  }

  waitFor(10) {
    $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/label/span/input")).click()
  }

  waitFor(10) {
    $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[3]/td[1]/label/span/input")).click()
  }

  waitFor(10) {
    $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[4]/td[1]/label/span/input")).click()
  }

}

E(/na sequência clicar no botão Excluir Selecionados/) { ->

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/button[2]/span[2]")).click()
  }

  Thread.sleep(2000)

}

E(/o sistema encetar uma pop-up com a seguinte mensagem: {string}/) { String msg ->

  assert $(By.className("ant-popover-content")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

}

Quando(/o usuário requerer o clique no botão Sim/) { ->
  at PageProj

  waitFor(10) {
    $(By.xpath("//*[contains(text(), 'Sim')]")).click()
  }

  Thread.sleep(2000)

}

Então(/todos os projetos selecionados serão excluídos/) { ->

  assert $(By.className("ant-message-notice")).isDisplayed()
  
  Thread.sleep(2000)

}

E(/removidos da lista de projetos/) { ->

  def nomeProjI = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(10).substring(22).split("\\|")[0].trim();
  def projDeleteI = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProjI+"']")).isDisplayed()
  assert projDeleteI == false

  def nomeProjII = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(13).substring(22).split("\\|")[0].trim();
  def projDeleteII = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProjII+"']")).isDisplayed()
  assert projDeleteII == false

  def nomeProjIII = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(16).substring(22).split("\\|")[0].trim();
  def projDeleteIII = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProjIII+"']")).isDisplayed()
  assert projDeleteIII == false

  def nomeProjIV = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(19).substring(22).split("\\|")[0].trim();
  def projDeleteIV = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProjIV+"']")).isDisplayed()
  assert projDeleteIV == false

}