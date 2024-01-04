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
    private final By currentLocator = By.xpath(".//div/div[2]/div[1]/span[text() = 'Казань']");

    public boolean checkChosenCurrent() {
       return driver.findElement(currentLocator).getText().contains(Asserts.CHOSEN_CITY);
    }

    //
        //
            // Тест №2
    private final By countryInput = By.xpath(".//div[@class = 'formControl destination']//div[@class = 'formInputPlace']");
    private final By closeSuggestCountry = By.className("close icon-i16_close");
    private final By locator_countryCheckboxes = By.xpath(".//ul/li[1]/span[text() = 'Популярные направления']");
    private final By selectCountryCheckbox = By.xpath("/html/body/header/div/div[4]/div[3]/div/div[1]/form/div[2]/div/div[2]/ul/li[5]/label/div/input");
    private final By locator_checkSelectedCountry = By.xpath("//*[@id=\"mainSearchForm\"]/div[2]/div/div[2]/ul/li[1]/label/div/span/i[text() = ', Турция']");
    private final By selectCity = By.xpath(".//ul/li[5]/label/div/input");
    private final By dateInput = By.xpath(".//div[@class = 'formDropdownWithCalendar tour-duration");
    private final By selectDate = By.xpath("/html/body/header/div/div[4]/div[3]/div/div[1]/form/div[3]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[3]/a[@class = 'ui-state-default ui-state-hover']");
    private final By startSearch = By.id("startSearch");


    public KazanPage BookingTour() {
        driver.findElement(countryInput).click();
        driver.findElement(closeSuggestCountry).click();
        driver.findElement(locator_countryCheckboxes).isDisplayed();
        driver.findElement(selectCountryCheckbox).click();
        driver.findElement(locator_checkSelectedCountry).isDisplayed();
        driver.findElement(selectCity).click();
        driver.findElement(dateInput).click();
        driver.findElement(selectDate).click();
        driver.findElement(startSearch).click();
        return this;
    }

    // Для ассерта
    private final By getDestinationText =  By.cssSelector(".profile__image[style*='background-image: url']");

    boolean checkSuccessBookingTour() {
        return driver.findElement()
    }


}
