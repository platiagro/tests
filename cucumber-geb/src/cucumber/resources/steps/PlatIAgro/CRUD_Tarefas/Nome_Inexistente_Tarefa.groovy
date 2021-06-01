import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.apache.commons.io.FileUtils

Dado(/que o usuário acione o ícone de pesquisa ao lado da coluna Nome da Tarefa/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    page.iconpesq.click()
  }

  Thread.sleep(2000)

}

E(/o modal para pesquisa tenha a sua abertura realizada/) { ->
  
  assert $(By.className("ant-table-filter-dropdown")).isDisplayed()

  Thread.sleep(2000)

}

E(/insira um nome de uma tarefa inexistente/) { ->
  
  waitFor(10) {
    page.camptask.value("Teste False")
  }

  Thread.sleep(1000)

}

Quando(/efetuar o clique no botão Search/) { ->

  waitFor(10) {
    page.btnSearch.click()
  }

  Thread.sleep(2000)

}

Então(/o sitema deve apresentar a página em branco: {string}/) { String noData ->

  String pagBranco = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td/div/p")).text()
  assert pagBranco.contains(noData)

}

E(/deverá selecionar o botão Reset para a lista de Tarefas ser apresentada novamente/) { ->
  
  waitFor(10) {
    page.iconpesq.click()
  }

  Thread.sleep(1000)

  waitFor(60){
    page.btnreset.click() 
  }

  Thread.sleep(1000)

  assert $(By.className("ant-table-tbody")).isDisplayed()

}