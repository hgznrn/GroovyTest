@Grapes([
    @Grab('org.gebish:geb-core:0.9.3'),
    @Grab('org.seleniumhq.selenium:selenium-chrome-driver:2.42.0'),
    @Grab('org.seleniumhq.selenium:selenium-support:2.42.0'),
    @Grab('net.sf.opencsv:opencsv:2.3')
])

import geb.Browser
import geb.Page
import org.openqa.selenium.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import au.com.bytecode.opencsv.*
import groovy.swing.SwingBuilder

System.setProperty('webdriver.chrome.driver', './chromedriver')

driver = { 
    DesiredCapabilities capabilities = DesiredCapabilities.chrome()
    ChromeOptions options = new ChromeOptions()
    options.addArguments("start-maximized")
    capabilities.setCapability(ChromeOptions.CAPABILITY, options)
    ChromeDriver driver = new ChromeDriver(capabilities) 
}

class PuhueiPage extends Page {
    static url = "http://www.puhuei.com/login"
    static at = { waitFor{ title == '會員登入'} }
    static content = {
        usernameInput { $("input[name='username']") }
        passwordInput { $("input[name='password']") }
        btnLogin {$("button[id='login-button']") }
    }
    void login(String account, String password) {
        usernameInput.value(account)
        passwordInput.value(password)
        btnLogin.click()
        println "bbb"
    }

    void loginagain() {
        println "loginagain"
    }
}

class PuhueiPage1 extends Page {
    static url = "http://www.puhuei.com/user"
    static at = { waitFor{ title == '會員專區'} }
    static content = {
        usernameInput { $("input[name='username']") }
        passwordInput { $("input[name='password']") }
        btnLogin {$("button[id='login-button']") }
    }
    static void login(String account, String password) {
        println "aaa"
    }
}

Browser.drive {
    if(this.args.size() != 3)
    {
        println "Warring!! Args is 3 number(Year Month Day)"
        return
    }

    to PuhueiPage
    at PuhueiPage
    login("system", "coke08150114")
    to PuhueiPage1
    login("aa", "bb")
    loginagain()




}.quit()

//Grooovy/Lib
//Groovy/Scripts

