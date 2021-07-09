import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.apache.commons.io.FileUtils
 

Quando(/o usuário inserir o nome do projeto existente:/) { ->
  at PageProj
 
  def nomeProjeto = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(10).substring(25).split("\\|")[0].trim();

  waitFor(10) {
    page.campnome.value(nomeProjeto)
  }

Thread.sleep(1000)
  
}
 

 

E(/selecionar o botão Buscar/) { ->

at PageProj

 waitFor(10) {
 
 page.btnBuscar.click()
  
 }

 Thread.sleep(2000)

}

 
 
 

Então (/o sistema deve apresentar o projeto que possui o nome inserido no campo de pesquisa/) { -> 


  def nomeProjeto = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(10).substring(25).split("\\|")[0].trim(); 
  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProjeto+"']")).isDisplayed()
}

