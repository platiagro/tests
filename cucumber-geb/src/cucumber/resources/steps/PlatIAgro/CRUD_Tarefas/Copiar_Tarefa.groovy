import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.testng.Assert
import org.apache.commons.io.FileUtils

Dado(/que o usuário acione o botão Mais, localizado na coluna Ação, de uma das Tarefas na lista/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    $(By.xpath("//*[contains(@title, '4')]")).click()
  }

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-table-content"))).isDisplayed();
                       
  def desc = $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[9]/td[2]/span")).text()
  repo.add("Descrição Copiada", desc)

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[9]/td[4]/div/div[3]/button")).click()          
  }

}

E(/um popover seja aberto/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-popover-content"))).isDisplayed();

  assert $(By.className("ant-popover-content")).isDisplayed()

}

Quando(/demandar o ato de fazer uma cópia/) { ->

  waitFor(10){
    $(By.xpath("//*[contains(text(), 'Fazer uma cópia')]")).click()
  }

}

Então(/a plataforma exibirá na página de detalhes a mensagem: {string}/) { String msgSuccess ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-notice-content"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(), 'Tarefa criada com sucesso.')]"), msgSuccess));

}

E(/no campo nome da Tarefa estará preenchido com a designação término Cópia - 1/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);

  def taskName = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(13).substring(27).split("\\|")[0].trim();
  def copyName = taskName + " - Cópia - 1"

  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/section/section/div/div[1]/div/div/span/div/h3/span"), copyName));
  assert $(By.xpath("/html/body/div[1]/section/section/div/div[1]/div/div/span/div/h3/span[text()='"+copyName+"']")).isDisplayed()

  def nomeTarefaCopiado = $(By.xpath("/html/body/div[1]/section/section/div/div[1]/div/div/span/div/h3/span")).text()
  repo.add("Tarefa Copiada", nomeTarefaCopiado)

}

E(/os valores dos campos da página de detalhamento serão os mesmos da tarefa selecionada para cópia/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);

  String descriptionCopy = repo.get("Descrição Copiada");

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='DESCRIPTION'][contains(@value, '"+descriptionCopy+"')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ant-select-selection-item'][contains(@title, 'Conjunto de dados')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='INPUT_DATA'][contains(@value, 'Arquivo .csv com dados tabulares (um atributo por coluna), sem cabeçalho')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='OUTPUT_DATA'][contains(@value, 'Conjunto de dados em formato de matriz, com uma amostra por linha')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@value, 'TST')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='DOCUMENTATION'][contains(text(), 'Teste - Adição da documentação')]"))).isDisplayed();

  String description = repo.get("Descrição Copiada")
  String copyDesc = browser.driver.findElement(By.xpath("//*[@id='DESCRIPTION']")).getAttribute("value")
  Assert.assertEquals(description, copyDesc);

}

E(/a cópia da tarefa criada será adicionada na lista de tarefas de acordo com a ordenação alfabética/) { ->

  waitFor(30) {
    $(By.className("ant-page-header-back-button")).click()
  }

  waitFor(30) {
    $(By.xpath("//*[contains(@title, '4')]")).click()
  }

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  def tarefaNome = repo.get("Tarefa Copiada")
  def copyDesc = repo.get("Descrição Copiada")
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span/span[text()='"+tarefaNome+"']"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr[9]/td[2]/span[text()='"+copyDesc+"']"))).isDisplayed();
   
}