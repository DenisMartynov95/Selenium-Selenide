package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

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
    private final By btnAcceptCookie = By.xpath(".//button[@class = 'btn btn-primary btn-sm d-block mx-auto mt-1 px-4 btnCookie']");

    public MainPage acceptCookie() {
        driver.findElement(btnAcceptCookie).click();
        return this;
    }


    //
        //
            // Методы и переменные для теста №1
    private final By btnOpenListForChooseGeoCurrent = By.xpath(".//div[@class = 'geolocation-current']");
    private final By btnChooseGeoCurrent = By.xpath(".//div[@class = 'geolocation-list']/ul/li[9]");


    public MainPage openListWithGeoCurrent() {
        driver.findElement(btnOpenListForChooseGeoCurrent).click();
        driver.findElement(btnChooseGeoCurrent).click();

    }


}

