import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

Dado(/que o usuário selecione o ícone de pesquisa ao lado da coluna Nome da Tarefa/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    page.iconPesq.click()
  }

  Thread.sleep(2000)

}

E(/o modal para pesquisa seja aberto/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-table-filter-dropdown"))).isDisplayed();
  
  assert $(By.className("ant-table-filter-dropdown")).isDisplayed()

}

E(/insira o nome da tarefa existente/) { ->

  def nomeTarefa = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(13).substring(27).split("\\|")[0].trim();

  waitFor(10) {
    page.fieldTask.value(nomeTarefa)
  }

}

Quando(/clicar no botão Search/) { ->

  waitFor(10) {
    page.btnSearch.click()
  }

}

Então(/o sistema deve apresentar a Tarefa que possui o nome inserido no campo de pesquisa/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);

  def nomeTarefa = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(13).substring(27).split("\\|")[0].trim();

  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span/span"), nomeTarefa));

  assert $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span/span[text()='"+nomeTarefa+"']")).isDisplayed()

}