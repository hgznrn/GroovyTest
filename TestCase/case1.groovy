package TestCase
import geb.Page
import geb.Browser
import au.com.bytecode.opencsv.*
import groovy.util.*
import Pages.PuhueiPage

RunScript = 
{
	geb.Browser.drive 
	{
		if(!CheckArgsNum(3)) 
		{
			println "Warring!! Args is 3 number(Year Month Day)"
			return
		}

	    to PuhueiPage
	    at PuhueiPage
	    login("system", "coke08150114")
	}.quit()
}

RunMainScript = 
{ 
	geb.Browser.drive 
	{

	}
}



/*
getName = { it ->
	to PuhueiPage
	at PuhueiPage
}

getString = "2123456"
*/