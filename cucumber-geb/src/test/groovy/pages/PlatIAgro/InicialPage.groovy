package pages

import org.openqa.selenium.By
import pages.base.BasePage

class InicialPage extends BasePage {
 static at = { title == "Demo ForAgri" }
    static content ={
      //$(By.xpath("//*[contains(text(), 'Não')]"),2)} exemplo 
      
     tarefaMenu{$(By.xpath("//*[@id='root']/section/header/ul/li[4]"))}
     


    }

}