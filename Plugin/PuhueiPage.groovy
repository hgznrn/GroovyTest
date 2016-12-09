package Plugin
import geb.Page

class PuhueiPage extends Page {
    static url = "http://www.puhuei.com/login"
    static at = { waitFor{ title == '會員登入'} }
    static content = {
        usernameInput { $("input[name='username']") } //會員帳號
        passwordInput { $("input[name='password']") } //會員密碼
        btnLogin {$("button[id='login-button']") }
    }
    void login(String account, String password) { //登入
        usernameInput.value(account)
        passwordInput.value(password)
        btnLogin.click()
        println "Login Finish"
    }

    void loginagain() {
        println "loginagain"
    }
}


