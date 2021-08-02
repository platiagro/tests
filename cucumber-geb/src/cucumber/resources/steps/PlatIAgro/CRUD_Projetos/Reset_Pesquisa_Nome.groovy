import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.apache.commons.io.FileUtils

Dado(/que o usuário selecione o ícone de pesquisa ao lado da coluna Nome do Projeto/) { ->
  at PageProj

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    page.btnsearch.click()
  }

  Thread.sleep(2000)

}

E(/seja aberto um modal/) { ->
  
  assert $(By.className("ant-table-filter-dropdown")).isDisplayed()
  
  Thread.sleep(2000)

}

Quando(/inserir o nome do projeto alterado anteriormente/) { ->

  waitFor(10) {
    def nomeProjeto = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(25).substring(28).split("\\|")[0].trim();
    $(By.xpath('/html/body/div[2]/div/div/div/div/input')).value(nomeProjeto)
  }

  Thread.sleep(2000)

}

E(/selecionar o botão Reset/) { ->

  waitFor(10) {
    page.btnReset.click()
  }

  Thread.sleep(2000)

}

Então(/o sistema deve cancelar a operação fechando o modal/) { ->
  
  def modalClosed = $(By.className("ant-table-filter-dropdown")).isDisplayed()
  assert modalClosed == false

}