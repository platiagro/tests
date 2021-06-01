import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By

Dado(/que o usuário efetue o clique no botão Novo Projeto/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/button/span[2]")).click()
  }

  Thread.sleep(2000)

}

E(/o sistema abrir um modal com o nome {string} selecionado/) { String nameProj ->

  String nomeProj = $(By.xpath("//*[@value='Novo Projeto']")).toString();
  assert nomeProj.contains(nameProj)

}

Quando (/realizar o clique no botão Cancelar/) { ->

  waitFor(30) {
    page.btnCancel.click()
  }

  Thread.sleep(2000)

}

Então(/o modal deve ser resetado e fechado/) { ->

  def modal = $(By.className("ant-modal-content")).isDisplayed()
  assert modal == false

}