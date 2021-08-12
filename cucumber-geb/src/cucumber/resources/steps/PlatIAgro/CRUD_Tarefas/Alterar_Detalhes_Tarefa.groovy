import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils
import org.testng.Assert

import helper.utility.NumberGerador

Dado(/que o usuário detalhe uma Tarefa existente/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    $(By.xpath("//*[contains(@title, '4')]")).click()
  }

  def nomeTar = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(13).substring(27).split("\\|")[0].trim();

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span/span[text()='"+nomeTar+"']")).click()
  }

}

E(/altere a descrição com a seguinte informação: {string}/) { String descAlter ->

  waitFor(10) {
    $(By.xpath("//*[@id='DESCRIPTION'][contains(@placeholder, 'Adicionar Descrição')]")).value(descAlter)
  }

  repo.add("Descrição Alterada", descAlter)

}

E(/insira uma nova categoria: {string}/) { String conjDados ->

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div[1]/div[2]/div")).click()
  }

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ant-select-item-option-content'][contains(text(), 'Minhas Tarefas')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ant-select-item-option-content'][contains(text(), 'Conjunto de dados')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ant-select-item-option-content'][contains(text(), 'Visualização de Dados')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ant-select-item-option-content'][contains(text(), 'Engenharia de Atributos')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ant-select-item-option-content'][contains(text(), 'Treinamento')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ant-select-item-option-content'][contains(text(), 'Visão Computacional')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ant-select-item-option-content'][contains(text(), 'Texto e Linguagem')]"))).isDisplayed();

  Thread.sleep(1000)

  waitFor(10) {
    $(By.xpath("//*[@class='ant-select-item-option-content'][contains(text(), '"+conjDados+"')]")).click()
  }

  def dataSet = $(By.className("ant-select-selection-item")).text()
  repo.add("Categoria", dataSet)

}

E(/em dados de entrada registrar: {string}/) { String dataInput ->

  waitFor(10) {
    $(By.xpath("//*[@id='INPUT_DATA'][contains(@placeholder, 'Adicionar dados de entrada')]")).click()
    Thread.sleep(1000)
    $(By.xpath("//*[@id='INPUT_DATA'][contains(@placeholder, 'Adicionar dados de entrada')]")).value(dataInput)
  }

  repo.add("Dados de Entrada", dataInput)

}

E(/para dados de saída registrar: {string}/) { String dataOutput ->

  waitFor(10) {
    $(By.xpath("//*[@id='OUTPUT_DATA'][contains(@placeholder, 'Adicionar dados de saída')]")).click()
    Thread.sleep(1000)
    $(By.xpath("//*[@id='OUTPUT_DATA'][contains(@placeholder, 'Adicionar dados de saída')]")).value(dataOutput)
  }

  repo.add("Dados de Saída", dataOutput)

}

E(/escolha a palavra-chave para a tag de busca: {string}/) { String tagSearch ->

  waitFor(10) {
    $(By.cssSelector("#root > section > section > div > div.task-details-page-content > div > div.task-details-page-content-form > div:nth-child(5) > div")).click()
  }
  
  waitFor(10) {
    $(By.className("ant-tag-close-icon")).click()
  }

  Thread.sleep(2000)

  waitFor(10) {
    $(By.id("SEARCH_TAGS")).value(tagSearch)
  }

  waitFor(10) {
    $(By.id("SEARCH_TAGS")).value(Keys.ENTER)
  }

  repo.add("Tag de Busca", tagSearch)

}

E(/adicione a documentação: {string}/) { String documentation ->

  waitFor(10) {
    $(By.xpath("//*[@id='DOCUMENTATION'][contains(@placeholder, 'Adicionar documentação')]")).click()
    Thread.sleep(1000)
    $(By.xpath("//*[@id='DOCUMENTATION'][contains(@placeholder, 'Adicionar documentação')]")).value(documentation)
  }

  repo.add("Documentação", documentation)
  
}

Quando(/clicar fora dos campos descritivos/) { ->

  waitFor(10) {
    $(By.className("task-details-page-content-form")).click()
  }

}

Então(/será exibida na tela uma mensagem de sucesso: {string}/) { String msgSuccess ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-notice-content"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(), 'Alteração realizada com sucesso.')]"), msgSuccess));

}

E(/as alterações nos detalhes da tarefa serão efetivados/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);

  String descAlterado = repo.get("Descrição Alterada");
  String categoria = repo.get("Categoria");
  String inputData = repo.get("Dados de Entrada");
  String outputData = repo.get("Dados de Saída");
  String buscaTag = repo.get("Tag de Busca");
  String doc = repo.get("Documentação");

  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='DESCRIPTION'][contains(@value, '"+descAlterado+"')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ant-select-selection-item'][contains(@title, '"+categoria+"')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='INPUT_DATA'][contains(@value, '"+inputData+"')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='OUTPUT_DATA'][contains(@value, '"+outputData+"')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@value, '"+buscaTag+"')]"))).isDisplayed();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='DOCUMENTATION'][contains(text(), '"+doc+"')]"))).isDisplayed();

}