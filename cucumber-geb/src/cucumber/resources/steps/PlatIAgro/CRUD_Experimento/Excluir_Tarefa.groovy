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

Dado(/que seja selecionado um projeto na listagem que possua experimento associado/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_Experimento_dataBase/Registros.txt")).get(13).substring(33).split("\\|")[0].trim();
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span/span[text()='"+nomeProj+"']")).click()
  }

  at PageExperimento

  waitFor(30) {
    page.cardExperimento.click()
  }

  Thread.sleep(2000)

}

Quando(/selecionar a Tarefa presente no fluxo de experimento para remover/) { ->

  waitFor(30) {
    $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[1]/button[3]/span")).click()
  }

  WebElement remove = browser.driver.findElement(By.xpath("//*[@class='ellipsis'][text()='Regressão Linear']"));
  Actions action = new Actions(browser.driver);
  action.contextClick(remove).build().perform();

  at PageExperimento

  waitFor(30) {
    page.remover.click()
  }

}

Então(/a tarefa será removida do fluxo de experimento com o sistema apresentando: {string}/) { String msg ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-message-notice-content"))).isDisplayed();

  assert $(By.xpath("//*[contains(text(), '"+msg+"')]")).text()

}