import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.testng.Assert
import org.apache.commons.io.FileUtils

Dado(/que o usuário faça uma Cópia, de uma das Tarefas na lista, localizado na coluna Ação - Mais/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    $(By.xpath("//*[contains(@title, '4')]")).click()
  }

  def desc = $(By.xpath("/html/body/div[1]/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/span")).text()
  repo.add("Descrição", desc)

  waitFor(10) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[4]/div/div[3]/button")).click()
  }

  waitFor(10){
    $(By.xpath("//*[contains(text(), 'Fazer uma cópia')]")).click()
  }

  Thread.sleep(2000)

}

E(/será aberto um modal/) { ->

  assert $(By.className("ant-modal-content")).isDisplayed()  

}

E(/os valores nos campos template e descrição serão os mesmos da tarefa selecionada para cópia/) { ->

  def nomeTarefa = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(13).substring(27).split("\\|")[0].trim();
  assert $(By.xpath("//*[contains(@title, '"+nomeTarefa+"')]")).isDisplayed()

  String description = repo.get("Descrição")
  String copyDesc = browser.driver.findElement(By.xpath("//*[@id='description']")).getAttribute("innerHTML")
  Assert.assertEquals(description, copyDesc);

}

E(/no campo nome estará preenchido com o nome da tarefa seguido por {string}/) { String nameTask ->

  def nomeTarefa = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Tarefas_dataBase/Registros.txt")).get(13).substring(27).split("\\|")[0].trim();
  assert $(By.xpath("//*[contains(@value, '"+nomeTarefa+" "+nameTask+"')]")).isDisplayed()

  String nomeCopiado = browser.driver.findElement(By.id("name")).getAttribute("value")
  repo.add("Tarefa Copiada", nomeCopiado)

}

Quando(/o usuário selecionar o botão Criar Notebooks/) { ->

  waitFor(10){
    page.btnCriarTask.click()
  }

  /*screen.type(Key.TAB);
  screen.type(Key.TAB);
  screen.type(Key.ENTER);*/

  Thread.sleep(1500)

}

Então (/terá a cópia da {string}/) { String copyTaskSuccess ->

  List<String> abas = new ArrayList<>(browser.driver.getWindowHandles());
  browser.driver.switchTo().window(abas.get(0));

  assert $(By.className("ant-message-success")).isDisplayed()

  assert $(By.xpath("//*[contains(text(), '"+copyTaskSuccess+"')]")).isDisplayed()

  Thread.sleep(2000)

}

E(/abrirá uma nova tela do JupyterLab: {string}/) { String jupyter ->

  List<String> abas = new ArrayList<>(browser.driver.getWindowHandles());
  browser.driver.switchTo().window(abas.get(1));

  def labJupyter = $(By.xpath("/html/body/div/section/section/div/div/div[2]")).text()
  assert labJupyter == jupyter

  Thread.sleep(2000)

}

E(/a cópia da tarefa criada será adicionada na lista de tarefas de acordo com a ordenação alfabética/) { ->

  List<String> abas = new ArrayList<>(browser.driver.getWindowHandles());
  browser.driver.switchTo().window(abas.get(0));

  def tarefaNome = repo.get("Tarefa Copiada")
  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/button/span[text()='"+tarefaNome+"']")).isDisplayed()

  Thread.sleep(2000)
   
}