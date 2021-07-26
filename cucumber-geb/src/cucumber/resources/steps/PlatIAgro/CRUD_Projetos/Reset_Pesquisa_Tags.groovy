import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.apache.commons.io.FileUtils

Dado(/que o usuário selecione o ícone ao lado da coluna Tags/) { ->
  at PageProj

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(40) {
    page.btntag.click()
  }

  Thread.sleep(2000)

}

E(/seja aberto um modal com as opções de tags: {string}, {string} e {string}/) { String exp, String preImp, String imp->
  
  assert $(By.className("ant-table-filter-dropdown")).isDisplayed()

  Thread.sleep(1000)

  assert $(By.xpath("/html/body/div[2]/div/div/div/ul/li[1]/span[text()='"+exp+"']")).isDisplayed()

  assert $(By.xpath("/html/body/div[2]/div/div/div/ul/li[2]/span[text()='"+preImp+"']")).isDisplayed()

  assert $(By.xpath("/html/body/div[2]/div/div/div/ul/li[3]/span[text()='"+imp+"']")).isDisplayed()

}

E(/selecionar a Tag Experimentação/) { ->

  waitFor(10) {
    $(By.xpath('/html/body/div[2]/div/div/div/ul/li[1]/label')).click()
  }

}

Quando(/selecionar o botão Resetar/) { ->

  waitFor(10) {
    page.btnresetar.click()
  }

  Thread.sleep(2000)

}

Então(/o modal das Tags será fechado/) { ->
  
  def modalClosed = $(By.className("ant-table-filter-dropdown")).isDisplayed()
  assert modalClosed == false

}