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
import au.com.bytecode.opencsv.*
import groovy.util.*
import Plugin.*

evaluate(new File("Config/GebConfig.groovy"))

Browser.drive {
    if(this.args.size() != 3)
    {
        println "Warring!! Args is 3 number(Year Month Day)"
        return
    }

    aa()

}.quit()

//Grooovy/Lib
//Groovy/Scripts

