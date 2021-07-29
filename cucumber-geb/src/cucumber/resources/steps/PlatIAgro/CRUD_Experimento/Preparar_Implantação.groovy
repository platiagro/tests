import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

String filePath = System.getProperty ('user.dir')
String caminho = '/src/cucumber/resources/files/'

Dado(/que o usuário selecione um projeto com experimentos associados/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt")).get(10).substring(26).split("\\|")[0].trim();
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span/span[text()='"+nomeProj+"']")).click()
  }

  at PageExperimento

  waitFor(30) {
    page.cardExperimento.click()
  }

}

E(/selecione o botão Preparar para a implantação/) { ->
  at PageExperimento

  waitFor(30) {
    page.btnImplantar.click()
  }

}

E(/na sequência será aberto um modal com seguinte título: {string}/) { String titleModal ->
  
  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-modal-content"))).isDisplayed();

  assert $(By.xpath("//*[@class='ant-modal-title'][text()='"+titleModal+"']")).text()

}

E(/selecionar os fluxos/) { ->

  waitFor(10) {
    $(By.xpath("//*[@id='form_in_modal']/div[1]/div/div/div/label/span[1]")).click()
  }

  waitFor(10) {
    $(By.xpath("//*[@id='form_in_modal']/div[2]/div/div/div/label/span[1]")).click()
  }

}

Quando(/clicar em OK após a seleção/) { ->

  waitFor(10) {
    $(By.xpath("//*[contains(text(), 'OK')]")).click()
  }

}

Então(/o sistema irá indicar que os experimentos foram implantados: {string}/) { String msgSuccess ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-success"))).isDisplayed();

  assert $(By.xpath("//*[contains(text(), '"+msgSuccess+"')]")).text()

}

E(/será direcionado para a página de fluxos implantados: {string}/) { String pagImpl ->

  assert $(By.xpath("//*[@id='root']/section/section/div/div[1]/div/div/span[2]/div/button/span[text()='"+pagImpl+"']")).isDisplayed()

  Thread.sleep(2000)

}
