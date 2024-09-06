package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    //    -----------------------------------------------------------------------------------------------------// get element locator
    By username = By.xpath("//input[@id='user-name' and @name='user-name']"); // menggabungkan element locator id dan name
    By password = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessagenull = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
    By errorMessageWrong = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

//    -----------------------------------------------------------------------------------------------------// action

    public void setUserName(String strUserName) {
        driver.findElement(username).sendKeys(strUserName);
    }
    public void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public void loginToSauceDemo(String strUserName, String strPassword) {
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickLogin();
        assert driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html");
    }

    //    -----------------------------------------------------------------------------------------------------// assertion
    public String getErrorMessageNull() {
        return driver.findElement(errorMessagenull).getText();
    }
    public String getErrorMessageWrong() {
        return driver.findElement(errorMessageWrong).getText();
    }

}
