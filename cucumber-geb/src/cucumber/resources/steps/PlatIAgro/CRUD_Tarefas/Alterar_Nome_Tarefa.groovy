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

Dado(/que o usuário selecione a Tarefa criada anteriormente/) { ->

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

E(/acione o clique no ícone para editar/) { ->  
  at PageTarefa

  waitFor(10) {
    page.iconEdit.click()
  }

}

E(/limpe o campo nome da tarefa/) { ->
  at PageTarefa

  waitFor(10) {
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    page.fieldNameTask.value(del)
  }

}

E(/alterar o nome da Tarefa: {string}/) { String nameAlter ->
  at PageTarefa

  def nomeTarAlter = nameAlter + " " + NumberGerador.number()

  waitFor(10) {
    page.fieldNameTask.value(nomeTarAlter)
  }

  repo.add("Nome Tarefa Alterada", nomeTarAlter)

  //Armazena o nome da tarefa alterada para controle
	reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt"), true);
	reg.write("+---------------------------------------------------------+\n"
		      + "| Nome da tarefa alterada: " + nomeTarAlter + "           |\n"
			    + "+---------------------------------------------------------+\n");
	reg.close();

}

Quando(/confirmar a operação/) { ->
  at PageTarefa

  waitFor(10) {
    page.btnSave.click()
  }

}

Então(/uma mensagem de sucesso será exibida na tela: {string}/) { String msgSuccess ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-notice-content"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(), 'Alteração realizada com sucesso.')]"), msgSuccess));

}

E(/o nome da tarefa alterada será atualizada/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);

  String minhaTarefaAlterada = repo.get("Nome Tarefa Alterada");

  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[1]/section/section/div/div[1]/div/div/span/div/h3/span"), minhaTarefaAlterada));

  String myTaskAlter = $(By.xpath("/html/body/div[1]/section/section/div/div[1]/div/div/span/div/h3/span[text()='"+minhaTarefaAlterada+"']")).text();
  assert minhaTarefaAlterada.contains(myTaskAlter)

}