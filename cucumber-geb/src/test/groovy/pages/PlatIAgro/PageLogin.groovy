package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PageLogin extends BasePage {
  
  static at = { title == "PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio" }
  static content ={

    user {$(By.xpath("//*[@id='login']"))}

    senha {$(By.xpath("//*[@id='password']"))}

    btnInput {$(By.xpath("//*[@id='submit-login']"))}

    dropUser {$(By.className("user-info-component-name"))}

    dropItemSair {$(By.xpath("//*[contains(text(), 'Sair')]"))}

    }
}