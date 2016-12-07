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
    go 'http://lamborib.rtm.net/'
    println "Hello World"
	$('input', id: 'AgentCode').value('4444') //輸入帳號
	$('input', id: 'LoginID').value('A004') //輸入帳號
	println $('input', id: 'LoginID').value() //取得 Element 包含的文字內容。
	$('input', id: 'LoginPassword').value('123456') //輸入密碼
	$('input', id: 'LoginBtn').click() //按下登入
	
	
    println $('div.navbar-header a').text()
    println $('li.dropdown a').text()
    println $('li.dropdown').size()
    def groupBtns = $('li.dropdown')
    def nReportAbility = groupBtns[2]
    nReportAbility.click()
    def nTranctionRecord = nReportAbility.find("ul.dropdown-menu li")[0]
    nTranctionRecord.click()
    
	/*$('a', text:contains("報表功能")).click()
	$('a', text:contains("交易紀錄")).click()
	println $('a', text: "報表功能").size()
	println $('a', text: "交易紀錄").size()*/
	// $('a', text: "Report Features").click()
	// $('a', text: 'Account Transaction').click()
	//waitFor(5) {} //最長等待時間為 5 秒
	// close() //如果希望 Geb 的任務完成後，就關閉瀏覽器視窗結束程式，可以使用「close()」指令。但是在 Groovy Console 下執行 Geb 程式時，並不建議將瀏覽器視窗關閉，因為這麼做會使得 Selenium WebDriver 無法再次執行任務，需要重新打開 Groovy Console 才能繼續執行 Geb 程式。
	//quit() //另一個結束指令為「quit()」，它不僅關閉瀏覽器視窗，也會終止 WebDriver 的執行。

	// waitFor { title.startsWith('Google') }
	// report 'test OK'
}