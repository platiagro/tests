package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PageProj extends BasePage {
  static at = {
   title == "PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio" }
    static content ={
      
       projetoMenu{$(By.xpath("//*[@id='root']/section/aside/div[1]/ul/li[1]"))}
       tarefaMenu {$(By.xpath("//*[@id='root']/section/aside/div[1]/ul/li[3]"))}


     //btnNewproj{$(By.xpath("//*[@id='root']/section/section/div[1]/div/span/div/button/span[1]"))}

     campnome{$(By.xpath("//*[@id='name']"))}

     //limparcamp{$(By.xpath("//*[@id='projectForm']/div[1]/div[2]/div/div/span/span"))}

     campDesc{$(By.xpath("//*[@id='description']"))}

     btnConfirm{$(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]"))}

     btncancel{$(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[1]"))}
   
     returnProj{$(By.xpath("//*[@id='root']/section/header/ul/li[6]"))}

     btnclose{$(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/button/span"))}
     
     btnedit{$(By.xpath("//*[@id='root']/section/section/div/div/div/span/div/span"))}

     btnalt{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[3]/td[5]/button[1]"))}
     
     editcancel{$(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[1]"))}
     
     btnexcluir{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[3]/td[6]/button"))}
     
     btnsim{$(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[2]"))}
     

     btnNao{$(By.xpath("/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[1]"))}
     
     btnselect {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/button"))}
     
     campclear{$(By.xpath("//*[@id='projectForm']/div[1]/div[2]/div/div/span/span"))}
   
     btnproj{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[5]/button[1]]"))}
   
     btnsearch{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[2]/div/span[2]/span"))}
  
     btnpesq{$(By.xpath("/html/body/div[2]/div/div/div/div/div/div[1]/button"))}

     btnreset {$(By.xpath("/html/body/div[2]/div/div/div/div/div/div[2]/button"))}

     btntag{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[4]/div/span[2]/span"))}
   
     btnok{$(By.xpath("/html/body/div[2]/div/div/div/div/button[2]"))}
     
     btnresetar{$(By.xpath("/html/body/div[2]/div/div/div/div/button[1]"))}

    }

} 