import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.apache.commons.io.FileUtils

Dado(/que o usuário escolha uma das Tarefas da lista para editar/) { ->

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

E(/limpar o campo nome/) { ->

  waitFor(10) {
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    $(By.xpath("//*[@id='name']")).value(del)
  }

}

E(/renomear a Tarefa: {string}/) { String rename ->

  waitFor(10) {
    $(By.xpath("//*[@id='name']")).value(rename)
  }

  repo.add("Nome Projeto Alterado", rename)

}

E(/inserir uma nova descrição: {string}/) { String descAlter ->

  waitFor(10) {
    $(By.xpath("//*[@id='description']")).value(descAlter)
  }

  repo.add("Descrição Alterada", descAlter)

  Thread.sleep(2000)
  
}

Quando(/efetuar o clique no botão Cancelar/) { ->

  waitFor(10) {
    $(By.xpath("//*[text()='Cancelar']")).click()
  }

  Thread.sleep(2000)

}

Então(/o sistema deve fechar modal/) { ->

  def modal = $(By.className("ant-modal-content")).isDisplayed()
  assert modal == false

}

E(/o nome e a descrição da tarefa não devem ser alterados/) { ->

  String minhaTarefaAlterada = repo.get("Nome Projeto Alterado");
  String myTaskAlter = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span[text()='"+minhaTarefaAlterada+"']")).isDisplayed()
  assert myTaskAlter != true

  String descAlterado = repo.get("Descrição Alterada");
  String descriptionAlter = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/span[text()='"+descAlterado+"']")).isDisplayed()
  assert descriptionAlter != true

  Thread.sleep(1000)

}