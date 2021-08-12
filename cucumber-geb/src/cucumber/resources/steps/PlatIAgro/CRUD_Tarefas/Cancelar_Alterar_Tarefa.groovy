import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

Dado(/que o usuário escolha uma das Tarefas da lista para editar/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    $(By.xpath("//*[contains(@title, '4')]")).click()
  }

  def nomeTar = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(10).substring(30).split("\\|")[0].trim();

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span/span[text()='"+nomeTar+"']")).click()
  }

}

E(/clique no ícone para editar/) { ->
  at PageTarefa

  waitFor(10) {
    page.iconEdit.click()
  }

}

E(/limpar o campo nome/) { ->
  at PageTarefa

  waitFor(10) {
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    page.fieldNameTask.value(del)
  }

}

E(/renomear a Tarefa: {string}/) { String rename ->
  at PageTarefa

  waitFor(10) {
    page.fieldNameTask.value(rename)
  }

  repo.add("Nome Tarefa Alterada", rename)

}

Quando(/efetuar o clique no botão Cancelar Edição/) { ->
  at PageTarefa

  waitFor(10) {
    page.btnCancelEdit.click()
  }

}

Então(/o nome da tarefa não deve ser alterado/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);

  String minhaTarefaAlterada = repo.get("Nome Tarefa Alterada");

  wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[@id='root']/section/section/div/div[1]/div/div/span/h3/h3/span"), minhaTarefaAlterada));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='root']/section/section/div/div[1]/div/div/span/h3/h3/span"), 'Tarefa em branco - 1'));

  String myTaskAlter = $(By.xpath("//*[@id='root']/section/section/div/div[1]/div/div/span/h3/h3/span[text()='"+minhaTarefaAlterada+"']")).isDisplayed()
  assert myTaskAlter != true

}