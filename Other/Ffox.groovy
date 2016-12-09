@Grapes([
    @Grab('org.gebish:geb-core:0.12.2'),
    @Grab('org.seleniumhq.selenium:selenium-firefox-driver:3.0.1'),
    @Grab('org.seleniumhq.selenium:selenium-support:2.42.0')
])

import geb.Browser

System.setProperty("webdriver.gecko.driver", "./geckodriver")

Browser.drive {
    go 'https://www.google.com.tw/'
}