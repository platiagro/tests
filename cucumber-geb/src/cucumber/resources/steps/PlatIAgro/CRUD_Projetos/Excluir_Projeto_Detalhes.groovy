import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.testng.Assert

import java.io.FileWriter
import java.util.Random

import helper.utility.NumberGerador

Dado(/que o usuário faça o clique no botão Novo Projeto/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/button/span[2]")).click()
  }

  Thread.sleep(2000)

}

E(/o sistema demandar a abertura de um modal com o nome {string} selecionado/) { String nameProj ->

  String nomeProj = $(By.xpath("//*[@value='Novo Projeto']")).toString();
  assert nomeProj.contains(nameProj)

}

E(/suceder em limpar o campo nome do projeto/) { ->

  waitFor(10) {
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    page.campnome.value(del)
  }

}

E(/inserir um nome para o projeto: {string}/) { String nomeDel ->

  def nomeProj = nomeDel + " " + NumberGerador.number()

  waitFor(10) {
    page.campnome.value(nomeProj)
  }

  repo.add("Nome Projeto", nomeProj)

  //Armazena o nome do projeto gerado para ser excluído
  reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt"), true);
  reg.write("+---------------------------------------------------------+\n"
		      + "| Nome do projeto deletado: " + nomeProj + "           |\n"
		      + "+---------------------------------------------------------+\n");
  reg.close();

}

E(/na descrição informar: {string}/) { String desc ->

  waitFor(30) {
    page.campDesc.value(desc)
  }

  repo.add("Descrição", desc)

  Thread.sleep(2000)
  
}

Quando (/realizar o clique no botão Criar/) { ->

  waitFor(30) {
    page.btnConfirm.click()
  }

  Thread.sleep(2000)

}

E(/o novo projeto será criado com sucesso/) { ->

  assert $(By.className("ant-message-success")).isDisplayed()

  String projNome = "Projeto " + repo.get("Nome Projeto") + " criado!"
  String displaySucess = $(By.xpath("//*[contains(text(), '"+projNome+"')]")).text()

  Assert.assertEquals(projNome, displaySucess);

}

E(/será direcionado para a página Detalhes do projeto/) { ->

  assert $(By.className("project-details")).isDisplayed()
   
}

E(/selecionar o botão Excluir/) { ->
  
  waitFor(10) {
    page.btndeleteProj.click()
  }

  Thread.sleep(2000)

}

E(/o sistema abrir uma pop-up com a seguinte mensagem: {string}/) { String msg ->

  assert $(By.className("ant-popover-content")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

}

Quando(/confirmar a operação clicando no botão Sim/) { ->

  waitFor(30) {
    page.deleteYes.click()
  }

}

Então(/o projeto será excluído/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-notice"))).isDisplayed();

}

E(/o usuário será direcionado para a página {string}/) { String myProj ->

  String meuProjeto = $(By.xpath("//*[@id='root']/section/section/div[1]/div/div/span/div/div/h3")).text();
  assert meuProjeto.contains(myProj)

  def projNomeDel = repo.get("Nome Projeto")
  def projDelete = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span/span[text()='"+projNomeDel+"']")).isDisplayed()
  assert projDelete == false

  Thread.sleep(2000)

}