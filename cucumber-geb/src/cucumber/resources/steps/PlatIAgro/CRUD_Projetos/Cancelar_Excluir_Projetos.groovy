import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.apache.commons.io.FileUtils

import java.io.FileWriter
import java.util.Random

import helper.utility.NumberGerador

FileWriter reg;

Dado(/que o usuário selecione vários projetos da lista/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  for (int i=1; i<=5 ; i++){
     waitFor(30) {
        $(By.xpath("//*[@id='root']/section/section/div[2]/button/span[2]")).click()
    }

    waitFor(10) {
        String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
        page.campnome.value(del)
    }

    def nomeProj = "Teste " + NumberGerador.number()

    waitFor(10) {
        page.campnome.value(nomeProj)
    }

    //Armazena o nome do projeto gerado para conferência na exclusão
	  reg = new FileWriter((System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt"), true);
	  reg.write("+---------------------------------------------------------+\n"
			      + "| Projeto de teste " + i + ": " + nomeProj + "                       |\n"
			      + "+---------------------------------------------------------+\n");
	  reg.close();

    waitFor(10) {
        page.campDesc.value("Projeto de teste " + i)
    }

    Thread.sleep(2000)

    waitFor(10) {
        page.btnConfirm.click()
    }

    Thread.sleep(2000)

    assert $(By.className("ant-message-success")).isDisplayed()

    Thread.sleep(2000)

    browser.driver.get("https://awsplatiagro02.aquarius.cpqd.com.br/projetos");
  }

  Thread.sleep(2000)

  $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/label/span/input")).click()
  $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/label/span/input")).click()
  $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[3]/td[1]/label/span/input")).click()
  $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[4]/td[1]/label/span/input")).click()
  $(By.xpath("/html/body/div/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[5]/td[1]/label/span/input")).click()

}

E(/clicar no botão Excluir Selecionados/) { ->
  at PageProj

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/button[2]/span[2]")).click()
  }

  Thread.sleep(2000)

}

E(/o sistema iniciar uma pop-up com a seguinte mensagem: {string}/) { String msg ->

  assert $(By.className("ant-popover-content")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).isDisplayed()

}

Quando(/o usuário selecionar o botão Não/) { ->
  at PageProj

  waitFor(10) {
    $(By.xpath("//*[contains(text(), 'Não')]")).click()
  }

  Thread.sleep(2000)

}

Então(/nenhum dos projetos selecionados será excluído/) { ->

  def nomeProjI = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(19).substring(22).split("\\|")[0].trim();
  $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProjI+"']")).isDisplayed()

  def nomeProjII = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(22).substring(22).split("\\|")[0].trim();
  $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProjII+"']")).isDisplayed()

  def nomeProjIII = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(25).substring(22).split("\\|")[0].trim();
  $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProjIII+"']")).isDisplayed()

  def nomeProjIV = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(28).substring(22).split("\\|")[0].trim();
  $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProjIV+"']")).isDisplayed()

  def nomeProjV = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Projetos_dataBase/Registros.txt")).get(31).substring(22).split("\\|")[0].trim();
  $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProjV+"']")).isDisplayed()

}