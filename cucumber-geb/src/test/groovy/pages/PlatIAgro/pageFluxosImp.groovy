package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PageFluxoImp extends BasePage {
  static at = {
   title == "PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio" }
    static content ={

      btntstfluxo{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr"))}
      
      inputFile{$("input[type='file']")}

      btndelete {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[5]/button[1]"))}

      btnsim {$(By.xpath("/html/body/div[8]/div/div/div/div[2]/div/div[2]/button[2]"))}

      btnlogs {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[5]/button[2]"))}

      btnUseImp {$(By.xpath("//*[@id='root']/section/section/div[2]/button"))}

    }
}