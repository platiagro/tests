import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

Dado(/que o usuário clique no botão para adicionar um monitoramento/) { ->

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

  at PageFluxoImp

  waitFor(30) {
    page.cardFluxo.click()
  }

  waitFor(30) {
    page.btnAdd.click()
  }

}

E(/um modal seja aberto para seleção/) { ->
  
  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-modal-content"))).isDisplayed();

}

E(/escolha um tipo de monitoramento/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("monitoring-task-card-title")));

  def title = $(By.className("monitoring-task-card-title")).text()
  repo.add("Title Monitoring", title)
  
  waitFor(30) {
    $(By.className("monitoring-task-card-description")).click()
  }

}

Quando(/clicar no botão Adicionar Monitoramento/) { ->
  
  WebElement element = browser.driver.findElement(By.className("ant-modal-footer"));
  JavascriptExecutor jse = (JavascriptExecutor)browser.driver;
  jse.executeScript("arguments[0].getElementsByTagName('button')[1].click();", element);

}

Então(/no painel de monitoramento é exibido o tipo selecionado anteriormente/) { ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("monitoring-flow-box-content"))).isDisplayed();

  String titleMonitoring = repo.get("Title Monitoring")
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("monitoring-flow-box-title"), titleMonitoring));

}

E(/ao clicar no botão Ver Monitoramentos um drawer será exibido/) { ->
  at PageFluxoImp

  waitFor(30) {
    page.btnVerMonit.click()
  }

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-drawer-content"))).isDisplayed();

  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("monitoring-drawer-header-title"), 'Teste do Monitoramento | Experimento 1'));

  String titleMonitoring = repo.get("Title Monitoring")
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("monitoring-drawer-item-title"), titleMonitoring));

}