@Grapes([
    @Grab('org.gebish:geb-core:0.9.3'),
    @Grab('org.seleniumhq.selenium:selenium-chrome-driver:2.42.0'),
    @Grab('org.seleniumhq.selenium:selenium-support:2.42.0')
])

import geb.Browser
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

System.setProperty('webdriver.chrome.driver', '/Users/unity_user/Documents/WorkSpace/Groovy/chromedriver')

driver = { 
	DesiredCapabilities capabilities = DesiredCapabilities.chrome()
    ChromeOptions options = new ChromeOptions()
    options.addArguments("start-maximized")
    capabilities.setCapability(ChromeOptions.CAPABILITY, options)
    ChromeDriver driver = new ChromeDriver(capabilities) 
}

Browser.drive {
	println 'Config'
    go 'http://lamborweb01.rtm.net/'

    $("a[href='/Register/']").click()

    $("input[name='LastName']").value("aaaa")
    $("input[name='readCheck']").click()

    $("input", name:"LasatName").value("aaaa")
}
