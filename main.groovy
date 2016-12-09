evaluate(new File("Config/config.groovy"))

println this.args.size()

if(this.args.size() < 1)
{
	println "Warnning! please enter TestCase Name in Directory of TestCase"
	return
}

evaluate(new File("TestCase/" + this.args[0]))

def flag = RunMainScript()
println flag
if(flag) RunScript()

