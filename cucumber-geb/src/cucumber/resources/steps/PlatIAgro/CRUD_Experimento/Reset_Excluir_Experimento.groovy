import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.interactions.Actions
import org.apache.commons.io.FileUtils

Dado(/que o usuário selecione a função Excluir, ao lado do nome do Experimento/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt")).get(13).substring(33).split("\\|")[0].trim();
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span[text()='"+nomeProj+"']")).click()
  }

  Thread.sleep(2000)

  at PageExperimento

  waitFor(30) {
    page.cardExperimento.click()
  }

  Thread.sleep(2000)

  WebElement abaNome = browser.driver.findElement(By.xpath("//*[@class='tab-title-custom'][contains(text(), 'Experimento 1')]"));
  Actions action = new Actions(browser.driver);
  action.contextClick(abaNome).build().perform();

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/section/main/section/footer/div/nav/span[3]/div/div/span[2]")).click()
  }

  Thread.sleep(2000)

}

E(/uma pop-up com a seguinte mensagem {string} for exibida/) { String msgModal ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-popover-inner-content"))).isDisplayed();

  assert $(By.xpath("//*[contains(text(), '"+msgModal+"')]")).text()

}

Quando(/for selecionado o botão Não/) { ->

  waitFor(10) {
    page.removerNo.click()
  }

  Thread.sleep(2000)

}

Então(/o pop-up será fechado/) { ->

  def modalClosed = $(By.className("ant-popover-inner-content")).isDisplayed()
  assert modalClosed == false

}

E(/o experimento não será excluído/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='tab-title-custom'][contains(text(), 'Experimento 1')]"))).isDisplayed();

}