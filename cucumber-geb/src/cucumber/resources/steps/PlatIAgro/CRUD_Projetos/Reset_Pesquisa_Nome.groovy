import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.apache.commons.io.FileUtils

Dado(/que o usuário selecione o ícone de pesquisa ao lado da coluna Nome do Projeto/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  at PageProj

  waitFor(10) {
    page.btnsearch.click()
  }

  Thread.sleep(2000)

}

E(/seja aberto um modal/) { ->
  
  assert $(By.className("ant-table-filter-dropdown")).isDisplayed()
  
  Thread.sleep(1000)

}

Quando(/inserir o nome do projeto alterado anteriormente/) { ->

  def nomeProjeto = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(25).substring(28).split("\\|")[0].trim();

  waitFor(10) {
    $(By.xpath("//input[@class='ant-input']")).value(nomeProjeto)
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