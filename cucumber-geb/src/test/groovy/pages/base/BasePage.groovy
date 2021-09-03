package pages.base

import geb.Page

class BasePage extends Page {

  def switchTo(page){

    waitFor(30){
      //Faz o switch na janela aberta como popup
      def newWindow
        browser.drive{
            withWindow{isAt page } {
              newWindow = browser.currentWindow
            }
        }
     browser.switchToWindow(newWindow)
    }
  }

   //Faz o controle de carregamento em caso de lentidão.
   def waitPageLoading(){
      Thread.sleep(2000);
       if($(By.xpath("//*[@id='modalDiv']/div/img")) ){
          waitFor(240){!$(By.xpath("//*[@id='modalDiv']/div/img")).isDisplayed()}
         }
         Thread.sleep(1000);
      }

}
