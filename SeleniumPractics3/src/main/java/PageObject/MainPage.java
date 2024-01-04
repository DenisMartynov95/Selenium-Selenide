package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //
        //
            // Методы и переменные относящиеся ко всем тестам (Принятие куки и прочие взаимодействия)
//    private final By btnAcceptCookie = By.xpath(" ");
//
//    public MainPage acceptCookie() {
//        return this;
//    }



    //
        //
            // Методы и переменные для теста №1

    private final By btnChangeGeoCity = By.xpath(".//span[@class = 'regionPanelShow']");
    private final By cityBlockLocator = By.xpath(".//div[@id = 'regionPanel']");
    private final By btnCity = By.xpath(".//div[1]/div/ul/li[38]/a[@title = 'Казань']");

    public KazanPage changeGeoCity() {
        driver.findElement(btnChangeGeoCity).click();
        driver.findElement(cityBlockLocator).isDisplayed();
        driver.findElement(btnCity).click();
        return new KazanPage(driver);
    }

}

