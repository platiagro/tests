import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By

Dado(/que o usuário acione o botão Nova Tarefa/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(30) {
    page.btntarefa.click()
  }

  Thread.sleep(2000)

}

E(/um modal seja aberto onde o Template em branco deve estar definido como default/) { ->

  assert $(By.className("ant-modal-content")).isDisplayed() 
  
  $(By.xpath("//*[contains(@title, 'Template em branco')]")).isDisplayed()

}

E(/entrar com o nome para a Tarefa: {string}/) { String nameCancel ->

  waitFor(10) {
    page.campnametask.value(nameCancel)
  }

  repo.add("Nome Tarefa", nameCancel)

}

E(/inserir a descrição: {string}/) { String desc ->

  waitFor(10) {
    page.campdesctask.value(desc)
  }

}

Quando (/clicar no botão Cancelar/) { ->

  waitFor(10) {
    page.btncalceltask.click()
  }

  Thread.sleep(2000)

}

Então(/o sistema fará com que o modal seja resetado e fechado/) { ->

  def modal = $(By.className("ant-modal-content")).isDisplayed()
  assert modal == false

}

E(/nenhuma tarefa será criada/) { ->

  $(By.xpath("//*[contains(@title, '4')]")).click()

  def tarefaNome = repo.get("Nome Tarefa")
  def nomeCancelado = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span[text()='"+tarefaNome+"']")).isDisplayed()
  assert nomeCancelado == false

  Thread.sleep(2000)

}