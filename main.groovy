@Grapes([
    @Grab('org.gebish:geb-core:0.9.3'),
    @Grab('org.seleniumhq.selenium:selenium-chrome-driver:2.42.0'),
    @Grab('org.seleniumhq.selenium:selenium-support:2.42.0'),
    @Grab('net.sf.opencsv:opencsv:2.3')
])

import org.openqa.selenium.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

System.setProperty('webdriver.chrome.driver', './chromedriver')

driver = { 
    DesiredCapabilities capabilities = DesiredCapabilities.chrome()
    ChromeOptions options = new ChromeOptions()
    options.addArguments("start-maximized")
    capabilities.setCapability(ChromeOptions.CAPABILITY, options)
    ChromeDriver driver = new ChromeDriver(capabilities) 
}

//evaluate(new File("Config/config.groovy"))

if(this.args.size() < 1)
{
	println "Warnning! please enter TestCase Name in Directory of TestCase/ => groovy main.groovy {filename}"
	return
}

evaluate(new File("TestCase/" + this.args[0]))

def flag = RunMainScript()
println flag
if(flag) {
	println "dkfjkdjf"
	RunScript()	
} 


