import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

Dado(/que o usuário acesse um fluxo implantado/) { ->

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(10) {
    def nomeProj = (String)FileUtils.readLines(new File(System.getProperty("user.dir") + "/src/cucumber/resources/helper/CRUD_FluxoImplantado_dataBase/Registros.txt")).get(10).substring(26).split("\\|")[0].trim();
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[2]/button/span/span[text()='"+nomeProj+"']")).click()
  }

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='root']/section/section/section/main/section/div/div[2]/div[1]/div/span"), 'Fluxos implantados'));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='root']/section/section/section/main/section/div/div[2]/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/span/span[2]"), 'Sucesso'));

}

Quando(/selecionar o botão Excluir, localizado na coluna Ações/) { ->

  Thread.sleep(1000)

  browser.driver.executeScript("document.querySelector('#root > section > section > section > main > section > div > div.project-details-table-content > div.ant-table-wrapper > div > div > div > div > div > table > tbody > tr > td:nth-child(5) > button:nth-child(5)').click()");

}

E(/um popover com a seguinte mensagem for exibido: {string}/) { String msg ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-popover-content"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[1]/div"), msg));

}

Quando(/o usuário confirmar a operação de exclusão/) { ->

  WebElement element = browser.driver.findElement(By.className("ant-popover-buttons"));
  JavascriptExecutor jse = (JavascriptExecutor)browser.driver;
  jse.executeScript("arguments[0].getElementsByTagName('button')[1].click();", element);

}

Então(/a implantação será deletada/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-popover-content")));
  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='root']/section/section/section/main/section/div/div[2]/div[1]/div/span")));
  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='root']/section/section/section/main/section/div/div[2]/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/span/span[2]")));

}