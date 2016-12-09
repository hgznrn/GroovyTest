package TestCase
import geb.Page
import geb.Browser
import au.com.bytecode.opencsv.*
import groovy.util.*
import Pages.PuhueiPage

RunScript = {
	geb.Browser.drive {
		println "drive"
	    to PuhueiPage
	    at PuhueiPage
	    login("system", "coke08150114")

	}.quit()
}

RunMainScript = { 
	geb.Browser.drive {
		if(this.args.size() != 3)
	    {
	        println "Warring!! Args is 3 number(Year Month Day)"
	        return false
	    }
	}
}



/*
getName = { it ->
	to PuhueiPage
	at PuhueiPage
}

getString = "2123456"
*/