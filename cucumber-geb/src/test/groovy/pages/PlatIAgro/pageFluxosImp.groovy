package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PageFluxoImp extends BasePage {

  static at = { title == "PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio" }
  static content = {

    btnImpFluxo {$(By.xpath("//*[@id='root']/section/section/div/div[2]/div[1]/div[1]/div/div[2]/button[3]"))}

    btntstfluxo{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr"))}
      
    inputFile{$("input[type='file']")}

    btndelete {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[5]/button[1]"))}
      
    btnsim {$(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]"))}

    btnlogs {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[5]/button[2]"))}

    btnUseImp {$(By.xpath("//*[@id='root']/section/section/div[2]/button"))}

    }
}