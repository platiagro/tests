import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.apache.commons.io.FileUtils

Dado(/que o usuário realize o clique no botão Novo Projeto/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/button/span[2]")).click()
  }

  Thread.sleep(2000)

}

E(/o sistema demandar a abertura do modal com o nome {string} selecionado/) { String nameProj ->

  String nomeProj = $(By.xpath("//*[@value='Novo Projeto']")).toString();
  assert nomeProj.contains(nameProj)

}

E(/seja apagado o conteúdo do campo nome do projeto/) { ->

  waitFor(10) {
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    page.campnome.value(del)
  }

}

E(/nomeie o projeto com o mesmo nome do projeto criado anteriormente/) { ->

  String nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(10).substring(22).split("\\|")[0].trim();

  waitFor(10) {
    page.campnome.value(nomeProj)
  }

}

E(/na descrição inserir a seguinte informação: {string}/) { String desc ->

  waitFor(30) {
    page.campDesc.value(desc)
  }

}

Quando(/for demandado o clique no botão Criar/) { ->

  waitFor(30) {
    page.btnConfirm.click()
  }

  Thread.sleep(2000)

}

Então(/o sistema deverá informar que {string}/) { String repeatName ->

  assert $(By.className("ant-message-error")).isDisplayed()

  String nomeRepete = $(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div[2]/div")).text();
  assert nomeRepete.contains(repeatName)

  Thread.sleep(2000)

}