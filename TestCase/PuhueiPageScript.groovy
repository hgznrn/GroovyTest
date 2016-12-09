package Plugin
/*import geb.Page
import geb.Browser
import au.com.bytecode.opencsv.*
import groovy.util.**/

RunScript = {
	geb.Browser.drive {
	    to PuhueiPage
	    at PuhueiPage
	    login("system", "coke08150114")

	}.quit()
}

RunMainScript = { 
	def flag = geb.Browser.drive {
		if(this.args.size() != 3)
	    {
	        println "Warring!! Args is 3 number(Year Month Day)"
	        return false
	    }
	}
	println flag
}



/*
getName = { it ->
	to PuhueiPage
	at PuhueiPage
}

getString = "2123456"
*/