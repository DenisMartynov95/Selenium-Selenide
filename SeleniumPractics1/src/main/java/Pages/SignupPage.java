package Pages;

import Config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailField = By.id("email");
    private final By passwordField = By.id("password");
    private final By btnSignup = By.xpath("//button[@class='auth-form__button' and @type = 'submit']");
    private final By successSignup = By.xpath("//p[contains(text(), 'Вы успешно зарегистрировались')]");

    public SignupPage inputRegistrationFields(){
        driver.findElement(emailField).sendKeys(WebDriverConfig.REGISTRATION_EMAIL_FIELD);
        driver.findElement(passwordField).sendKeys(WebDriverConfig.REGISTRATION_PASSWORD_FIELD);
        driver.findElement(btnSignup).click();
        return this;
    }

    public boolean checkSuccessMessage(){ // Проверяю видимость текста успешной регистрации
        return driver.findElement(successSignup).isDisplayed();
    }

}
