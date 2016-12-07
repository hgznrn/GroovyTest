@Grapes([
    @Grab('org.gebish:geb-core:0.9.3'),
    @Grab('org.seleniumhq.selenium:selenium-chrome-driver:2.42.0'),
    @Grab('org.seleniumhq.selenium:selenium-support:2.42.0'),
    @Grab('net.sf.opencsv:opencsv:2.3')
])

import geb.Browser
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

Browser.drive {

    if(this.args.size() != 3)
    {
        println "Warring!! Args is 3 number(Year Month Day)"
        return
    }

    go 'http://www.puhuei.com/login'
    $("input[name='username']").value("system")
    $("input[name='password']").value("coke08150114")
    $("button[id='login-button']").click()

    waitFor { $("a[href='http://www.puhuei.com/user/export']").text().contains("出金任務")}

    //點至出金任務
    $("a[href='http://www.puhuei.com/user/export']").click()

    //定義需要的年、月、日
    def nYear = this.args[0]
    def nMonth = this.args[1]
    def nDay = this.args[2]

    //Open CSV
    def TEST_OUTPUT_FILE_NAME = nYear + '-' + nMonth + '-' + nDay + '.csv'

    File output = new File(TEST_OUTPUT_FILE_NAME)
    if (output.exists())
    {
        output.delete()
    }
    output.createNewFile()
    def writer = new CSVWriter(new FileWriter(output))

    def line = (String[])["", "戶名", "銀行名稱", "分行", "代碼", "帳號", "金額", "實撥金額"]
    writer.writeNext(line)

    //找出所有頁面的超連結、一個一個去點
    //def NowPage = $(".pagination li[class='active']") //找出class="active"的子元素
    //def NextPage = $(".pagination li:last-child") //最後一個子元素
    //println "Now Active Page:" + NowPage.text() + " NextPage:" + NextPage.find("a").text()

    def NextPage = $(".pagination li:last-child").find("a") //最後一個子元素
    while(NextPage.size() > 0)
    {
        NextPage.click()

        def trData = $("table[class*='uk-table-striped'] tbody tr")
        
        trData.each { tData ->
            def tdData = tData.find("td")
            def tdData_Name = tdData[1]
            def tdData_ID = tdData[2].text()
            def tdData_BankDetail = tdData[3]
            def tdData_Money = tdData[4].text()
            def tdData_Date = tdData[0].text().split(" ")[0]
            def tdData_Date_Year = tdData_Date.split("-")[0]
            def tdData_Date_Month = tdData_Date.split("-")[1]
            def tdData_Date_Day = tdData_Date.split("-")[2]
            //println "Year:" + tdData_Date_Year + " Month:" + tdData_Date_Month + " Day:" + tdData_Date_Day
            //找出想要的年/月/日，並把資料全部取到
            if(tdData_Date_Year == nYear && tdData_Date_Month == nMonth && tdData_Date_Day == nDay)
            {
                def dataStr = ""
                tData.find("td").each{ data ->
                    dataStr += data.text() + ","
                }
                println dataStr

                tdData_BankDetail.click()

                waitFor { $("td[id='bank_account']").text() != "讀取中" }
                
                def bank_acc_name = $("td[id='bank_account_name']").text()
                def bank_cellphone = $("td[id='cellphone']").text()

                def bank_name_split = $("td[id='bank_name']").text().split('/')
                def bank_name, bank_sub_name
                if(bank_name_split.size() > 1)
                {
                    bank_name = bank_name_split[0]
                    bank_sub_name = bank_name_split[1]
                }
                else
                {
                    bank_name = bank_name_split[0]
                    bank_sub_name = ""
                }
                def bank_sub_id = $("td[id='bank_sub_id']").text()
                def bank_acc = $("td[id='bank_account']").text()

                $("a[class='uk-modal-close uk-close']").click()

                //放到Excel當中，並產出一個.csv檔
                def slash_bank_sub_id = "/ " + bank_sub_id
                def slash_bank_acc = "/ " + bank_acc

                line = (String[])[(String)tdData_ID, (String)bank_acc_name, 
                (String)bank_name, (String)bank_sub_name, 
                (String)slash_bank_sub_id, (String)slash_bank_acc, (String)tdData_Money]

                writer.writeNext(line)
                /*output.withWriter { writer ->
                    new CSVWriter(writer).writeNext((String[]) [tdData_ID, 
                        bank_acc_name, bank_name, bank_sub_name, bank_sub_id, bank_acc])
                }*/
                
            }
        }

        sleep(1000)
        NextPage = $(".pagination li:last-child").find("a") //最後一個子元素
    }

    writer.close()
}.quit()


