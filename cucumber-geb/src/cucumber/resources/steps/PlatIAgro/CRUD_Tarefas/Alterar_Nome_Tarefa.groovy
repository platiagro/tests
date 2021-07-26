import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.apache.commons.io.FileUtils
import org.testng.Assert

Dado(/que o usuário selecione a Tarefa criada anteriormente/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    $(By.xpath("//*[contains(@title, '4')]")).click()
  }

  def nomeTar = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(10).substring(25).split("\\|")[0].trim();

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span[text()='"+nomeTar+"']")).click()
  }

  Thread.sleep(2000)

}

E(/um modal seja aberto, com o atual nome da tarefa selecionada/) { ->  
  
  def modal = $(By.className("ant-modal-content")).isDisplayed()
  assert modal == true
  
  def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(10).substring(25).split("\\|")[0].trim();
  assert $(By.xpath("//*[contains(@value, '"+nomeProj+"')]")).isDisplayed()

}

E(/limpe o campo nome da tarefa/) { ->

  waitFor(10) {
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    $(By.xpath("//*[@id='name']")).value(del)
  }

}

E(/alterar o nome da Tarefa, acrescentando ao final: {string}/) { String nameAlter ->

  def nomeTar = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(10).substring(34).split("\\|")[0].trim();
  def nomeTarAlter = nomeTar + " " + nameAlter

  waitFor(10) {
    $(By.xpath("//*[@id='name']")).value(nomeTarAlter)
  }

  repo.add("Nome Tarefa Alterada", nomeTarAlter)

  //Armazena o nome do projeto alterado para controle
	reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt"), true);
	reg.write("+---------------------------------------------------------+\n"
		    + "| Nome da tarefa alterada: " + nomeTarAlter + "            |\n"
			+ "+---------------------------------------------------------+\n");
	reg.close();

}

E(/informar uma nova descrição: {string}/) { String descAlter ->

  waitFor(10) {
    $(By.xpath("//*[@id='description']")).value(descAlter)
  }

  repo.add("Descrição Alterada", descAlter)

  Thread.sleep(2000)
  
}

Quando(/confirmar a operação/) { ->

  waitFor(10) {
    page.btneditTask.click()
  }

  Thread.sleep(2000)

}

Então(/o modal será fechado/) { ->

  def modal = $(By.className("ant-modal-content")).isDisplayed()
  assert modal == false

}

E(/uma mensagem de sucesso será exibida na tela: {string}/) { String msgSuccess ->

  assert $(By.className("ant-message-notice")).isDisplayed()

  //String displaySucess = $(By.xpath("//*[contains(text(), '"+msgSuccess+"')]")).text()
  //Assert.assertEquals(msgSuccess, displaySucess);

  assert $(By.xpath("//*[contains(text(), '"+msgSuccess+"')]")).isDisplayed()

  Thread.sleep(2000)

}

E(/o nome e a descrição da tarefa alterados serão atualizados/) { ->

  String minhaTarefaAlterada = repo.get("Nome Tarefa Alterada");
  String myTaskAlter = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span[text()='"+minhaTarefaAlterada+"']")).text();
  assert minhaTarefaAlterada.contains(myTaskAlter)

  String descAlterado = repo.get("Descrição Alterada");
  String descriptionAlter = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/span[text()='"+descAlterado+"']")).text();
  assert descAlterado.contains(descriptionAlter)

  Thread.sleep(1000)

}