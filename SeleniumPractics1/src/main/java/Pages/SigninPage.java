package Pages;

import Config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SigninPage {
    private WebDriver driver;

    public SigninPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By btnSignup = By.xpath("//button[@class='auth-form__button' and @type = 'submit']");

    public MainPage logIn(){
        driver.findElement(emailField).sendKeys(WebDriverConfig.LOGIN_EMAIL_FIELD);
        driver.findElement(passwordField).sendKeys(WebDriverConfig.LOGIN_PASSWORD_FIELD);
        driver.findElement(btnSignup).click();
        return new MainPage(driver);
    }

}
