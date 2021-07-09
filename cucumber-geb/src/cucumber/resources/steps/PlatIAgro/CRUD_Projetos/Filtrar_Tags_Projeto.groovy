import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.apache.commons.io.FileUtils
 
 
 
 E (/selecionar a Tag Implantado/) { ->
 
  waitFor(10) {
    $(By.xpath('/html/body/div[2]/div/div/div/ul/li[3]')).click()
  }

  Thread.sleep(1000)

}
 
 
 
 
 

 Quando (/selecionar o botão OK/) { ->
 
 waitFor(10) {
   $(By.xpath('/html/body/div[2]/div/div/div/div/button[2]')).click()

 }

Thread.sleep(1000)

}



 Então (/o sistema deverá exibir os projetos que possuem experimento/) { ->

  assert $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[4]/span[3]")).isDisplayed()

   
 }

