import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.apache.commons.io.FileUtils

Dado(/que o usuário detalhe o Projeto criado anteriormente/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(30) {
    def nomeProj = $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[2]/button/span/span")).text()
    repo.add("Nome Projeto Atual", nomeProj)

    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[2]/button/span/span")).click()
  }

  Thread.sleep(2000)

}

E(/selecione o botão Editar, ao lado do nome do projeto/) { ->
  at PageProj

  waitFor(10) {
    page.btnedit.click()
  }

  Thread.sleep(2000)

}

E(/o sistema abrir um modal, com o atual nome do projeto selecionado/) { ->

  def modal = $(By.className("ant-modal-content")).isDisplayed()
  assert modal == true

  def nomeProjAtual = repo.get("Nome Projeto Atual");
  assert $(By.xpath("//*[@value='"+nomeProjAtual+"']")).isDisplayed()

}

Quando(/o usuário limpar o campo/) { ->

  waitFor(10) {
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    page.campnome.value(del)
  }

}

E(/renomear o projeto acrescentando ao final: {string}/) { String nameAlter ->

  String nomeProjAtual = repo.get("Nome Projeto Atual");
  String nomeProjAlter = nomeProjAtual + " " + nameAlter

  waitFor(10) {
    page.campnome.value(nomeProjAlter)
  }

  repo.add("Nome Projeto Alterado", nomeProjAlter)

  //Armazena o nome do projeto alterado para controle
	reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt"), true);
	reg.write("+---------------------------------------------------------+\n"
		      + "| Nome do projeto alterado: " + nomeProjAlter + "           |\n"
			    + "+---------------------------------------------------------+\n");
	reg.close();

}

E(/informar no campo descrição: {string}/) { String descAlter ->

  waitFor(10) {
    page.campDesc.value(descAlter)
  }

  repo.add("Descrição Alterada", descAlter)

  Thread.sleep(2000)
  
}

E(/clicar no botão para salvar a alteração: {string}/) { String save ->

  waitFor(10) {
    page.btnSalvar.click()
  }

  Thread.sleep(2000)

  assert $(By.className("ant-message-success")).isDisplayed()

  assert $(By.xpath("/html/body/div[2]/div/span/div/div/div/span[text()='"+save+"']")).isDisplayed()

  Thread.sleep(2000)

}

Então(/o nome e a descrição do projeto serão atualizados/) { ->

  String meuProjetoAlterado = repo.get("Nome Projeto Alterado");
  String myProjectAlter = $(By.xpath("//*[@id='root']/section/section/div/div/div/span/div/div/h3")).text();
  assert meuProjetoAlterado.contains(myProjectAlter)

  String descAlterado = repo.get("Descrição Alterada");
  String descriptionAlter = $(By.xpath("//*[@id='root']/section/section/section/aside/div/div/div[1]/p")).text();
  assert descAlterado.contains(descriptionAlter)

  Thread.sleep(2000)

}