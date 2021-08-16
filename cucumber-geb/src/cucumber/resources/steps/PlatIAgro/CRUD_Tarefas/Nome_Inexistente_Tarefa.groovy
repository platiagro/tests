import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

Dado(/que o usuário acione o ícone de pesquisa ao lado da coluna Nome da Tarefa/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    page.iconPesq.click()
  }

}

E(/o modal para pesquisa tenha a sua abertura realizada/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-table-filter-dropdown"))).isDisplayed();
  
  assert $(By.className("ant-table-filter-dropdown")).isDisplayed()

}

E(/insira um nome de uma tarefa inexistente/) { ->
  
  waitFor(10) {
    page.fieldTask.value("Teste False")
  }

}

Quando(/efetuar o clique no botão Search/) { ->

  waitFor(10) {
    page.btnSearch.click()
  }

}

Então(/o sitema deve apresentar a página em branco: {string}/) { String noData ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td/div/p"), noData));
                                 
  String pagBranco = $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td/div/p")).text()
  assert pagBranco.contains(noData)

}

E(/deverá selecionar o botão Reset para a lista de Tarefas ser apresentada novamente/) { ->
  
  waitFor(10) {
    page.iconPesq.click()
  }

  waitFor(60){
    page.btnReset.click()
  }

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-table-tbody"))).isDisplayed();

  assert $(By.className("ant-table-tbody")).isDisplayed()

}