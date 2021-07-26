import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.apache.commons.io.FileUtils

Dado(/que o usuário, na coluna Ação da lista, clique em Excluir uma Tarefa/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[3]/td[4]/div/div[3]/button/span[1]")).click()
  }

  waitFor(10){
    $(By.xpath("//*[contains(text(), 'Excluir')]")).click()
  }

  Thread.sleep(2000)

}

E(/o sistema deve abrir uma pop-up com a seguinte mensagem: {string}/) { String msg ->

  assert $(By.className("ant-popconfirm")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

  Thread.sleep(1000)

}

Quando(/selecionar o botão Não/) { ->

  waitFor(10) {
    page.btnnao.click()
  }

  Thread.sleep(2000)

}

Então (/a operação será cancelada/) { ->

  def tarDelete = $(By.className("ant-popconfirm")).isDisplayed()                             
  assert tarDelete != true

  Thread.sleep(2000)

}

E(/nenhuma tarefa será excluída/) { ->

  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span[text()='Análise Descritiva']")).isDisplayed()

}