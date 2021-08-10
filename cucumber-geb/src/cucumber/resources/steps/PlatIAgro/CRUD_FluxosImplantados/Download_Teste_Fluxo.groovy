import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

import java.nio.file.Files
import java.nio.file.Paths

String filePath = System.getProperty ('user.dir')
String caminho = '/src/cucumber/resources/files/Iris.csv'

Dado(/que o usuário selecione o botão Testar Fluxo/) { ->

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

  Thread.sleep(1000)

  List<WebElement> search = browser.driver.findElements(By.xpath("//*[contains(@aria-label, 'paper-clip')]"));
  if (search.equals(true)) {
    waitFor(30) {
      page.inputFile.value(filePath + caminho) //upload do arquivo de entrada
    }

    Thread.sleep(2000)
  
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ant-message-notice")));
  } else {
    at PageFluxoImp

    waitFor(30) {
      page.btnTesteFluxo.click()
    }
  }

}

Quando(/selecionar o botão Fazer Download/) { ->
  at PageFluxoImp

  waitFor(30) {
    page.btnDownload.click()
  }

}

Então(/um arquivo do resultado será baixado com êxito/) { ->

  Thread.sleep(8000)

  String fileName = "predict-file.csv";
  String downloadDir = System.getProperty("user.home") + "/Downloads/";
  String filePathLoaded = downloadDir + fileName;

  if (Files.exists(Paths.get(filePathLoaded))) {
    println "Download de " + filePathLoaded + " concluído."
    println ""
    new File(filePathLoaded).delete();
  } else {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.getStackTrace();
        println "O download de " + filePathLoaded + " não foi concluído."
        println ""
	    }
  }

}