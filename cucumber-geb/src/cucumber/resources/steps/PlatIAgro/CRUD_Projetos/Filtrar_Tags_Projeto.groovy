import pages.*

import static cucumber.api.groovy.PT.*
import cucumber.api.PendingException
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.apache.commons.io.FileUtils

Dado(/que o usuário faça a seleção do ícone ao lado da coluna Tags/) { ->
  at PageProj

  for (int i=0; i<2; i++){
    println " "
  }

  waitFor(30) {
    page.btntag.click()
  }

  Thread.sleep(2000)

}

E(/que seja aberto um modal com as opções de tags: {string}, {string} e {string}/) { String exp, String preImp, String imp ->
  
  assert $(By.className("ant-table-filter-dropdown")).isDisplayed()

  Thread.sleep(1000)

  assert $(By.xpath("/html/body/div[2]/div/div/div/ul/li[1]/span[text()='"+exp+"']")).isDisplayed()

  assert $(By.xpath("/html/body/div[2]/div/div/div/ul/li[2]/span[text()='"+preImp+"']")).isDisplayed()

  assert $(By.xpath("/html/body/div[2]/div/div/div/ul/li[3]/span[text()='"+imp+"']")).isDisplayed()

}
 
E (/demandar a seleção da Tag Experimentação/) { ->
 
  waitFor(10) {
    $(By.xpath('/html/body/div[2]/div/div/div/ul/li[1]/label')).click()
  }

}
 
Quando(/selecionar o botão OK/) { ->
 
  waitFor(10) {
    $(By.xpath('/html/body/div[2]/div/div/div/div/button[2]')).click()
  }

}

Então (/o sistema deverá exibir os projetos que possuem {string}/) { String exp ->

  WebDriverWait wait = new WebDriverWait(browser.driver, 30);
  wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr/td[4]/span/span[text()='"+exp+"']")));

}

