import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.apache.commons.io.FileUtils

Dado(/que o usuário acesse a página Detalhes do projeto selecionado/) { ->
  at PageProj

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(13).substring(22).split("\\|")[0].trim();
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProj+"']")).click()
  }

  Thread.sleep(2000)

}

E(/acionar o botão Excluir/) { ->

  waitFor(10) {
    page.btndeleteProj.click()
  }

  Thread.sleep(2000)

}

E(/o sistema revelar uma pop-up com a seguinte mensagem: {string}/) { String msg ->

  assert $(By.className("ant-popover-content")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

}

Quando(/o usuário efetuar o clique no botão Não/) { ->

  waitFor(10) {
    page.deleteNo.click()
  }

  Thread.sleep(2000)

}

Então (/o projeto não será excluído/) { ->

  def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(13).substring(22).split("\\|")[0].trim();
  def projDelete = $(By.xpath("//*[@id='root']/section/section/div/div/div/span/div/div/h3[text()='"+nomeProj+"']")).isDisplayed()                             
  assert projDelete == true

  Thread.sleep(2000)

}