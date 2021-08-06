import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

String filePath = System.getProperty ('user.dir')
String caminho = '/src/cucumber/resources/files/Iris.csv'

Dado(/que o usuário tenha um experimento com arquivo csv implantado/) { ->

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
    $(By.xpath("//*[@class='ellipsis'][text()='Fonte de dados']")).click()
  }

  waitFor(30) {
    page.inputFile.value(filePath + caminho) //upload do arquivo de entrada
  }

  Thread.sleep(2000)
  
  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-message-notice")));

}

Quando(/houver a selecão do botão Testar Fluxo/) { ->
  at PageFluxoImp

  waitFor(30) {
    page.btnTesteFluxo.click()
  }

}

Então(/será apresentado um modal com o seguinte título: {string}/) { String title ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-modal-content"))).isDisplayed();
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("ant-modal-title"), title));

  def modal = $(By.className("ant-modal-content")).isDisplayed()                        
  assert modal == true

}

E(/as seguintes colunas descritivas exibidas: {string}, {string}, {string}, {string} e {string}/) { String id, String sepalLengthCm, String sepalWidthCm, String petalLengthCm, String petalWidthCm ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 10);
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='ant-table-cell'][text()='Id']"), id));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='ant-table-cell'][text()='SepalLengthCm']"), sepalLengthCm));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='ant-table-cell'][text()='SepalWidthCm']"), sepalWidthCm));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='ant-table-cell'][text()='PetalLengthCm']"), petalLengthCm));
  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@class='ant-table-cell'][text()='PetalWidthCm']"), petalWidthCm));

}