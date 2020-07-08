package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PageInicial extends BasePage {
 static at = { title == "PlatIAgro - Plataforma de Inteligência Artficial para o Agronegócio" }
    static content ={
      
     tarefaMenu{$(By.xpath("//*[@id='root']/section/header/ul/li[4]"))}
     projetoMenu{$(By.xpath("//*[@id='root']/section/header/ul/li[6]"))}


    }

}