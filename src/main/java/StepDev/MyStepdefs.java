package StepDev;

import POM.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class MyStepdefs {
    WebDriver driver;
    LoginPage loginPage;
    //----------------------------------------------------------------------------------------------------------------------Success login
    @Given("^I am on the login page$")
    public void Iamontheloginpage() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/ChromeDriver/new/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @When("^I enter username and password$")
    public void Ienterusernameandpassword() {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();
    }
    @Then("^I should see the dashboard page$")
    public void Ishouldseethedashboardpage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        driver.quit();
    }
    //    ------------------------------------------------------------------------------------------------------Failed login
    @When("^I enter invalid username and password$")
    public void Ienterinvalidusernameandpassword() {
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce1");
        loginPage.clickLogin();
    }
    @Then("^I should see message Invalid username or password$")
    public void IshouldseemessageInvalidusernameorpassworde() {
        Assert.assertEquals(loginPage.getErrorMessageWrong(), "Epic sadface: Username and password do not match any user in this service");
        driver.quit();
    }
//    ------------------------------------------------------------------------------------------------------------Null login
    @When("^I click Login Button$")
    public void IclickLoginButton() {
        loginPage.clickLogin();
    }
    @Then("^I should see message \"([^\"]*)\"$")
    public void Ishouldseemessage(String message) {
        String errorMessage = loginPage.getErrorMessageWrong();
        Assert.assertEquals(errorMessage, "Epic sadface: " + message);
        driver.quit();
    }

}