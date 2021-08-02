import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.apache.commons.io.FileUtils

Dado(/que o usuário faça a seleção do ícone de pesquisa ao lado da coluna Nome do Projeto/) { ->
  at PageProj

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    page.btnsearch.click()
  }

  Thread.sleep(2000)

}

E(/que seja aberto um modal/) { ->
  
  assert $(By.className("ant-table-filter-dropdown")).isDisplayed()
  
  Thread.sleep(1000)

}

E(/inserir o nome de um projeto existente na lista/) { ->
 
  def nomeProjeto = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(13).substring(22).split("\\|")[0].trim();

  waitFor(10) {
    $(By.xpath('/html/body/div[2]/div/div/div/div/input')).value(nomeProjeto)
  }
  
}

Quando(/selecionar o botão Buscar/) { ->
  at PageProj

  waitFor(10) {
    page.btnBuscar.click()
  }

  Thread.sleep(2000)

}

Então (/o sistema deve apresentar o projeto que possui o nome inserido no campo de pesquisa/) { -> 

  def nomeProjeto = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(13).substring(22).split("\\|")[0].trim(); 
  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span/span[text()='"+nomeProjeto+"']")).isDisplayed()

}