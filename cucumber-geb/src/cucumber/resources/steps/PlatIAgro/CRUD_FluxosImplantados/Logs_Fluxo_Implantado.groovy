import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

Dado(/que haja fluxo implantado com sucesso pelo usuário/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_FluxoImplantado_dataBase/Registros.txt")).get(10).substring(26).split("\\|")[0].trim();
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span/span[text()='"+nomeProj+"']")).click()
  }

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='root']/section/section/section/main/section/div/div[2]/div[1]/div/span"), 'Fluxos implantados'));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='root']/section/section/section/main/section/div/div[2]/div[2]/div/div/div/div/div/table/tbody/tr/td[2]"), 'Experimento 1'));

}

Quando(/selecionar o botão Ver Logs, localizado na coluna Ações/) { ->

  Thread.sleep(1000)

  browser.driver.executeScript("document.querySelector('#root > section > section > section > main > section > div > div.project-details-table-content > div.ant-table-wrapper > div > div > div > div > div > table > tbody > tr > td:nth-child(5) > button:nth-child(3)').click()");

}

Então(/será aberto uma drawer de Logs/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-drawer-content"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ant-drawer-title"), 'Logs'));

}

E(/as informações estarão divididas em três colunas: {string}, {string} e {string}/) { String date, String level, String message ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='ant-table-cell'][text()='Data']"), date));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='ant-table-cell'][text()='Nível']"), level));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='ant-table-cell'][text()='Mensagem']"), message));

}