import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By

Dado(/que o usuário clique no botão Nova Tarefa/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(30) {
    page.btntarefa.click()
  }

  Thread.sleep(2000)

}

E(/abra um modal para escolher um exemplo ou um template em branco para criar nova tarefa/) { ->

  assert $(By.className("ant-modal-content")).isDisplayed() 
  
  $(By.xpath("//*[contains(@title, 'Template em branco')]")).isDisplayed()

}

E(/nomear a Tarefa: {string}/) { String nomeTarefa ->

  waitFor(10) {
    page.campnametask.value(nomeTarefa)
  }

}

E(/inserir a seguinte descrição: {string}/) { String desc ->

  waitFor(30) {
    page.campdesctask.value(desc)
  }

  Thread.sleep(2000)

}

Quando (/realizar o clique no botão Criar Notebooks/) { ->

  waitFor(30) {
    page.btnConfirm.click()
  }

  Thread.sleep(2000)

}

Então(/o sistema deverá exibir a mensagem impeditiva: {string}/) { String repeatName ->

  String nomeRepete = $(By.xpath("//*[@id='newTaskForm']/div[2]/div[2]/div[2]/div")).text();
  assert nomeRepete.contains(repeatName)

}