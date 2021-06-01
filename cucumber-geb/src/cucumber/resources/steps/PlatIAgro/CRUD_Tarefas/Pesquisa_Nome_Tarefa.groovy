import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.apache.commons.io.FileUtils

Dado(/que o usuário selecione o ícone de pesquisa ao lado da coluna Nome da Tarefa/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    page.iconpesq.click()
  }

  Thread.sleep(2000)

}

E(/o modal para pesquisa seja aberto/) { ->
  
  assert $(By.className("ant-table-filter-dropdown")).isDisplayed()

  Thread.sleep(1000)

}

E(/insira o nome da tarefa existente/) { ->

  def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(13).substring(27).split("\\|")[0].trim();

  waitFor(10) {
    page.camptask.value(nomeProj)
  }

  Thread.sleep(1000)

}

Quando(/clicar no botão Search/) { ->

  waitFor(10) {
    page.btnSearch.click()
  }

  Thread.sleep(2000)

}

Então(/o sistema deve apresentar a Tarefa que possui o nome inserido no campo de pesquisa/) { ->

  def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(13).substring(27).split("\\|")[0].trim(); 
  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span[text()='"+nomeProj+"']")).isDisplayed()

}