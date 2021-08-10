package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PageFluxoImp extends BasePage {

  static at = { title == "PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio" }
  static content = {

    btnImpFluxo {$(By.xpath("//*[@id='root']/section/section/div/div[2]/div[1]/div[1]/div/div[2]/button[3]"))}

    btnTesteFluxo {$(By.xpath("//*[@id='root']/section/section/div/div[2]/div[1]/div[1]/div/div[2]/button[1]"))}
      
    inputFile {$("input[type='file']")}

    btnComoUsar {$(By.xpath("//*[@id='root']/section/section/section/main/section/div/div[2]/div[1]/button"))}

    cardFluxo {$(By.xpath("//*[@id='root']/section/section/section/main/section/div/div[1]/div[2]/button"))}

    btnDownload {$(By.xpath("//*[contains(@aria-label, 'download')]"))}

    btnAdd {$(By.xpath("//*[@id='root']/section/section/div/div[2]/div[1]/div[3]/div[1]/div/button[1]"))}

    btnVerMonit {$(By.xpath("//*[@id='root']/section/section/div/div[2]/div[1]/div[3]/div[1]/div[1]/button[2]/span[2]"))}

    }
}