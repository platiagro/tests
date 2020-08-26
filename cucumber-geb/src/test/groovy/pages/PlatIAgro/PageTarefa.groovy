package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PageTarefa extends BasePage {
  static at = {
   title == "PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio" }
    static content ={
    btnnext{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/ul/li[5]"))}

    btnprevious{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/ul/li[1]"))}

    btntarefa{$(By.xpath("//*[@id='root']/section/section/div[2]/button"))}

    btnselect{$(By.xpath("//*[@id='newTaskForm_template']/div/span"))}

    btnoptb{$(By.xpath("//*[@id='a9a662e7-9e91-4dd3-9770-a4534f460944']/ul/li[25]"))}

    btnlimp{$(By.xpath("//*[@id='newTaskForm']/div[2]/div[2]/div/div/span/span"))}
              
    campnametask{$(By.xpath("//*[@id='name']"))}

    campdesctask{$(By.xpath("//*[@id='description']"))}

    //btnnewtask{$(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]"))}

    btncalceltask{$(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]"))}

    btnnext3{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/ul/li[4]"))}

    btnclose{$(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button"))}

    btnopsvc{$(By.xpath("//*[@id='06f9ea94-cac0-4831-a84d-8e34d7753f40']/ul/li[21]"))}

    campeditname {$(By.xpath("//*[@id='editTaskForm_name']"))}

    campeditdesc {$(By.xpath("//*[@id='editTaskForm_description']"))}

    btneditlimp {$(By.xpath("//*[@id='newEditTaskForm']/div[1]/div[2]/div/div/span"))}
    
    btnexcluir {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[3]/td[3]/button[2]"))}
    
    btnsim {$(By.xpath("/html/body/div[12]/div/div/div/div[2]/div/div[2]/button[2]"))}

    btnmais{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[4]/div/div[3]/button"))}
   
    btneditconfirm{$(By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[3]/button[2]"))}

   }
}
  