import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
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
  repo.add("Descrição", desc)

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

E(/no campo nome da Tarefa estará preenchido com a designação default/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);

  def nomeTarefa = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(10).substring(30).split("\\|")[0].trim();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='root']/section/section/div/div[1]/div/div/span/h3/h3/span"), nomeTarefa));
  assert $(By.xpath("//*[contains(@value, '"+nomeTarefa+"')]")).isDisplayed()

  String nomeCopiado = browser.driver.findElement(By.id("name")).getAttribute("value")
  repo.add("Tarefa Copiada", nomeCopiado)

}

E(/o valor do campo da descrição será o mesmo da tarefa selecionada para cópia/) { ->

  def nomeTarefa = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(13).substring(27).split("\\|")[0].trim();
  assert $(By.xpath("//*[contains(@title, '"+nomeTarefa+"')]")).isDisplayed()

  String description = repo.get("Descrição")
  String copyDesc = browser.driver.findElement(By.xpath("//*[@id='description']")).getAttribute("innerHTML")
  Assert.assertEquals(description, copyDesc);

}

Quando(/o usuário selecionar o botão Criar Notebooks/) { ->

  waitFor(10){
    page.btnCriarTask.click()
  }

  Thread.sleep(1500)

}

Então (/terá a cópia da {string}/) { String copyTaskSuccess ->

  List<String> abas = new ArrayList<>(browser.driver.getWindowHandles());
  browser.driver.switchTo().window(abas.get(0));

  assert $(By.className("ant-message-success")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+copyTaskSuccess+"')]")).isDisplayed()

  Thread.sleep(2000)

}

E(/abrirá uma nova tela do JupyterLab: {string}/) { String jupyter ->

  List<String> abas = new ArrayList<>(browser.driver.getWindowHandles());
  browser.driver.switchTo().window(abas.get(1));

  def labJupyter = $(By.xpath("/html/body/div/section/section/div/div/div[2]")).text()
  assert labJupyter == jupyter

  Thread.sleep(2000)

}

E(/a cópia da tarefa criada será adicionada na lista de tarefas de acordo com a ordenação alfabética/) { ->

  List<String> abas = new ArrayList<>(browser.driver.getWindowHandles());
  browser.driver.switchTo().window(abas.get(0));

  def tarefaNome = repo.get("Tarefa Copiada")
  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span[text()='"+tarefaNome+"']")).isDisplayed()

  Thread.sleep(2000)
   
}