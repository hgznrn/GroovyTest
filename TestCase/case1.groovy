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
		if(this.args.size() != 4) //包含
	    {
	        println "Warring!! Args is 3 number(Year Month Day)"
	        return false
	    }

	    to PuhueiPage
	    at PuhueiPage
	    login("system", "coke08150114")

	}.quit()
}

RunMainScript = 
{ 
	def flag = false;
	geb.Browser.drive 
	{
		//設定限制3個參數
		flag = CheckArgsNum(3)
	}
	if (flag) return geb.Browser.drive
	else return null
}



/*
getName = { it ->
	to PuhueiPage
	at PuhueiPage
}

getString = "2123456"
*/