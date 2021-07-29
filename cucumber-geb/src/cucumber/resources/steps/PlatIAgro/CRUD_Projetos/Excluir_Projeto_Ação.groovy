import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.apache.commons.io.FileUtils

import java.io.FileWriter
import java.util.Random

import helper.utility.NumberGerador

Dado(/que o usuário selecione um dos projetos da lista/) { ->
  at PageProj

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/label/span/input")).click()
  }

}

E(/na coluna ação selecionar a opção Excluir/) { ->

  def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(25).substring(28).split("\\|")[0].trim();

  waitFor(10) {
    $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[6]/button/span")).click()
  }

  Thread.sleep(1000)

}

E(/o sistema exibir uma pop-up com a seguinte mensagem: {string}/) { String msg ->

  assert $(By.className("ant-popover-content")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

}

Quando(/o usuário confirmar a operação clicando no botão Sim/) { ->

  waitFor(10) {
    page.btnsim.click()
  }

  Thread.sleep(2000)

}

Então (/o projeto será excluído da lista de Projetos/) { ->

  def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(13).substring(28).split("\\|")[0].trim();
  def projDelete = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[2]/button/span/span[text()='"+nomeProj+"']")).isDisplayed()                             
  assert projDelete == false

  Thread.sleep(2000)

}