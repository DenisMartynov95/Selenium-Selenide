package PageObject;


import WebDriverFactory.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KazanPage {

    private final WebDriver driver;

    public KazanPage(WebDriver driver) {
        this.driver = driver;
    }

    // Для ассерта теста №1
    private final By currentLocator = By.xpath(".//div/input[@itemname = 'Казань']");

    public boolean checkChosenCurrent() {
       return driver.findElement(currentLocator).getText().contains(Asserts.CHOSEN_CITY);
    }


}
