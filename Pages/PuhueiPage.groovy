package Pages

class PuhueiPage extends geb.Page {
    
    static url = "http://www.puhuei.com/login"

    static at = { waitFor{ title == '會員登入'} }

    
    //會員密碼
    static content = {

        //會員帳號輸入框
        usernameInput { $("input[name='username']") } 

        //會員密碼輸入框
        passwordInput { $("input[name='password']") } 

        //會員登入
        btnLogin {$("button[id='login-button']") }

    }

    //登入
    void login(String account, String password) { 
        usernameInput.value(account)
        passwordInput.value(password)
        btnLogin.click()
        println "Login Finish"
    }
}


