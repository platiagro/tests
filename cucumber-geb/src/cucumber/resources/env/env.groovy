import org.openqa.selenium.OutputType
import org.openqa.selenium.WebDriverException

import static cucumber.api.groovy.Hooks.*

import geb.Browser
import geb.binding.BindingUpdater
import pages.*
import wsclient.WSSoapClient
import db.DBAccess
import repository.MemoryRepository
import geb.driver.CachingDriverFactory

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.File;
import org.apache.commons.io.IOUtils;
import org.apache.commons.*
import java.nio.file.*;
//import java.nio.file.DirectoryStream;


// NOTE: if you are using the steps in the geb-cucumber library, binding and unbinding
// will already be taken care of for you

def bindingUpdater
def theBrowser
def config

def restartBrowser(browser){
	if (browser?.config?.autoClearCookies) {
				 browser.clearCookiesQuietly()
	}
	def newBrowser = new Browser()
	bindingUpdater = new BindingUpdater(binding, newBrowser)
	bindingUpdater.initialize()
	newBrowser
}


Before { scenario ->
	theBrowser=restartBrowser(theBrowser)
	bindVariables()
}

After { scenario ->

	// embed screenshot into cucumber report
	if(scenario.failed) {
		try {
			if(theBrowser){
				scenario.embed(theBrowser.driver.getScreenshotAs(OutputType.BYTES), "image/png")
			}
		} catch(WebDriverException e) {
			// sometime firefox runs out of memory trying to take a screenshot, not a big deal so ignore
		} catch(MissingMethodException e) {
			// HTMLUnit doesn't support screenshots
		}
	}

	CachingDriverFactory.clearCacheAndQuitDriver()
}

def bindVariables(){
	if(!binding.hasVariable("soapClient")){
		binding.setVariable("soapClient", new WSSoapClient())
	}
	if(!binding.hasVariable("db")){
		binding.setVariable("db", new DBAccess(new File("database.properties")))
	}
	if(!binding.hasVariable("repo")){
		binding.setVariable("repo", new MemoryRepository())
	}
	if(!binding.hasVariable("embedScreenshot")){
		binding.setVariable("embedScreenshot", true)
		//println "Setou embedScreenshot"
		deleteFilesForPathByPrefix(System.getProperty("ReportsDir"), "embedded")
	}
}

AfterStep { scenario ->

	//embed screenshot into cucumber report
		try {
			if(theBrowser){
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss")
                Date date = new Date()
				String screenshot_file = "${scenario.name}-${dateFormat.format(date)}.png"
				String reportsDir = System.getProperty("ReportsDir")
				String dest = reportsDir + "/" + screenshot_file			
				byte[] encoded_img =  theBrowser.driver.getScreenshotAs(OutputType.BYTES)								            				
				//Faz um screenshot a cada execução
				IOUtils.write(encoded_img, new FileOutputStream(dest));			          	
				scenario.embed(encoded_img,'image/png')
				scenario.write("Screenshot anexo ${dest}");	
			}
		} catch(WebDriverException e) {
			// sometime firefox runs out of memory trying to take a screenshot, not a big deal so ignore
		} catch(MissingMethodException e) {
			// HTMLUnit doesn't support screenshots
		}

}

  def deleteFilesForPathByPrefix(String path, String prefix) {
    
    try {
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(Paths.get(path), prefix + "*")
        for ( Path newDirectoryStreamItem : newDirectoryStream) {
            Files.delete(newDirectoryStreamItem);
            //println "Screenshots deletado ${newDirectoryStreamItem}"
        }
    } catch ( Exception e) {        
        println "Screenshots anexos não removidos do Report HTML"
        false
    }
    true 
  }
