package StepDev;

import POM.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MyStepdefs {
    WebDriver driver;
    LoginPage loginPage;

    @Given("^I am on the login page$")
    public void Iamontheloginpage() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/ChromeDriver/chromedriver-win64 (129)/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @When("^I enter username (.+) and password (.+)$")
    public void Ienterusernameandpassword(String username, String password) {
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
    }

    @Then("^I should see the dashboard page$")
    public void Ishouldseethedashboardpage() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        driver.quit();
    }

    @When("^I enter invalid username (.+) and password (.+)$")
    public void Ienterinvalidusernameandpassword(String username, String password) {
        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();
    }

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