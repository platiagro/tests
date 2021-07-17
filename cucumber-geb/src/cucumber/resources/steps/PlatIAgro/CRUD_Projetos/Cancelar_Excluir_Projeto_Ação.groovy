import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.apache.commons.io.FileUtils

Dado(/que o usuário efetue a seleção de um dos projetos da lista/) { ->
  at PageProj

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/label/span/input")).click()
  }

  Thread.sleep(2000)

}

E(/na coluna ação seletar a opção Excluir/) { ->

  def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(13).substring(22).split("\\|")[0].trim();

  waitFor(10) {
    $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[6]/button/span")).click()
  }

  Thread.sleep(1000)

}

E(/o sistema apresentar uma pop-up com a seguinte mensagem: {string}/) { String msg ->

  assert $(By.className("ant-popover-content")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

}

Quando(/o usuário clicar no botão Não/) { ->

  waitFor(10) {
    page.btnNao.click()
  }

  Thread.sleep(2000)

}

Então (/o projeto não será excluído e permanecerá na lista de projetos/) { ->

  def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(13).substring(22).split("\\|")[0].trim();
  def projDelete = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProj+"']")).isDisplayed()                           
  assert projDelete == true

}