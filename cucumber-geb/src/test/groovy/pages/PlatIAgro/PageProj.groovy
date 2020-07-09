package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PageProj extends BasePage {
  static at = {
   title == "PlatIAgro - Plataforma de Inteligência Artficial para o Agronegócio" }
    static content ={
      
     btnNewproj{$(By.xpath("//*[@id='root']/section/section/div[2]/button"))}
     btnclear{$(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/span/span/span"))}
     campnome{$(By.xpath("//*[@id='newProjectForm_name']"))}
     campDesc{$(By.xpath("//*[@id='newProjectForm_description']"))}
     btnConfirm{$(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/div/button[2]"))}
     btncancel{$(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/div/button[1]"))}
     returnProj{$(By.xpath("//*[@id='root']/section/header/ul/li[6]"))}
     btnclose{$(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button/span"))}
     btnedit{$(By.xpath("//*[@id='root']/section/section/div[1]/div/span/div/i"))}
     btnalt{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[3]/td[4]/button[1]"))}
     btnexcluir{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr/td[4]/button[2]"))}
     btnsim{$(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div[2]/button[2]"))}
     btnNao{$(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div/div[2]/button[1]"))}
     btnselect {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/button"))}
    btnsalvar{$(By.xpath("//html/body/div[2]/div/div[2]/div/div[2]/div[3]/div/button[2]"))}
    }

}