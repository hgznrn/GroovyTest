@Grapes([
    @Grab('org.gebish:geb-core:0.9.3'),
    @Grab('org.seleniumhq.selenium:selenium-chrome-driver:2.42.0'),
    @Grab('org.seleniumhq.selenium:selenium-support:2.42.0')
])
import geb.Browser
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.By;

System.setProperty('webdriver.chrome.driver', './chromedriver')
 
driver = {
    DesiredCapabilities capabilities = DesiredCapabilities.chrome()
    ChromeOptions options = new ChromeOptions()
    options.addArguments("start-maximized")
    capabilities.setCapability(ChromeOptions.CAPABILITY, options)
    ChromeDriver driver = new ChromeDriver(capabilities)
}
 
Browser.drive {
    println 'Config'
    config.reportsDir = new File('C:/Users//PhoenixTree010//Desktop//WHYNOT//report')

    println 'GO~~'
    

    println title

    go 'http://lamborweb01.rtm.net/'
    
    $("a[href='/LiveVideo']").click()
    $("a[href='/Electronic_Game']").click()
    $("a[href='/Lottery_Betting']").click()
    $("a[href='/Agent']").click()
    $("a[href='/Tutorial']").click()
    $("a[href='/AboutUs']").click()
    $("a[href='/BetMobile/Index']").click()

    $("a", "href='/LiveVideo'")
    
    $("a[href='/Register/']").click()
    $("label[ng-i18next='register.Register_RegisterAccount'] + input").click()
    $("label[ng-i18next='register.Register_RegisterAccount'] + input").value("kyos0109")
    $("label[ng-i18next='register.LastName'] + input").value("Ku")
    $("label[ng-i18next='register.FirstName'] + input").value("Kyle")
    $("label[ng-i18next='register.NickName'] + input").value("WTFFF")

	$("a[href='javascript:;']").click()
	$('li[data-value="206"]').click()

    $("label[ng-i18next='register.PhoneNo'] + input").value("0123456789")
    $("label[ng-i18next='register.Email'] + input").value("test@test.com")
    $("label[ng-i18next='register.Password'] + input").value("Aa123456")
    $("label[ng-i18next='register.ConfirmPassword'] + input").value("Aa123456")
    $("label[ng-i18next='register.Password'] + input").value("Aa123456")
    $("label[ng-i18next='register.Password'] + input").value("Aa123456")
    
    //驗證

    //報告

    //$('input[type=checkbox]').prop("checked", true)

    //$("a[href='/Login']").click()


    report 'Test1'

    //close()
}