import pages.*
import geb.*
import db.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.remote.DesiredCapabilities
import cucumber.api.PendingException
import org.openqa.selenium.By
import static cucumber.api.groovy.PT.*


Quando(/o usuário retornar para a página Detalhes do Projeto/){->
 at PageProj

     waitFor(60){ {$(By.xpath("//*[@id='root']/section/section/div/div/div/div")).click() }

 Thread.sleep(5000)
}