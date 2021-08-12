import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions

Dado(/que o usuário clique no botão Nova Tarefa/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(30) {
    page.btnTarefa.click()
  }

}

E(/demande a criação da tarefa a partir de um template em branco/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("task-template-item-title"), 'Em Branco'));

  at PageTarefa

  waitFor(30) {
    page.btnCreateTask.click()
  }

  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Criando Nova Tarefa')]")));
  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-message-notice-content")));

}

E(/nomeie a Tarefa com uma designação existente: {string}/) { String nomeTarefa ->
  at PageTarefa

  waitFor(10) {
    page.iconEdit.click()
  }

  waitFor(10) {
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    page.fieldNameTask.value(del)
  }

  waitFor(10) {
    page.fieldNameTask.value(nomeTarefa)
  }

}

Quando (/realizar o clique no botão Salvar/) { ->
  at PageTarefa

  waitFor(10) {
    page.btnSave.click()
  }

}

Então(/o sistema deverá exibir a mensagem impeditiva: {string}/) { String repeatName ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-notice-content"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(), 'Já existe uma tarefa com este nome!')]"), repeatName));

  String nomeRepete = $(By.xpath("//span[contains(text(), 'Já existe uma tarefa com este nome!')]")).text();
  assert nomeRepete.contains(repeatName)

}