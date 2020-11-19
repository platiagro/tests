package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PageTarefa extends BasePage {
  static at = {
   title == "PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio" }
    static content ={

    btnnext{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/ul/li[5]/button"))}

    btnprevious{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/ul/li[1]"))}

    btntarefa{$(By.xpath("//*[@id='root']/section/section/div[2]/button"))}

    btnselect{$(By.xpath("//*[@id='newTaskForm_template']/div/span"))}

    btnop10{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/ul/li[6]/div" ))}

    btnop50{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/ul/li[6]/div/div[2]/div/div/div/div[2]/div/div/div[5]/div"))}
    
    btnselect2 {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/ul/li[3]"))}

    btnfechar{$(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/button"))}

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
    
    btnsim{$(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div[2]/button[2]"))}
     
    btnnao {$(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div[2]/button[1]"))}

    btnmais{$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[4]/div/div[3]/button"))}
   
    btneditTask{$(By.xpath("//*[contains(text(), 'Confirmar')]"))}

    iconpesq {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/thead/tr/th[1]/div/span[2]/span"))}
    
    btnSearch{$(By.xpath("/html/body/div[3]/div/div/div/div/div/div[1]/button"))}

    btnreset {$(By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/button"))}

    camptask{$(By.xpath("/html/body/div[3]/div/div/div/div/input"))}

    btncriarTask{$(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[3]/button[2]"))}

   }
}

