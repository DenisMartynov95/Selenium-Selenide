package PageObject;

import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class MainPage {
          /*
                    ГЛАВНАЯ СТРАНИЦА САМОКАТА
                                                        */

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

//======================================================================================================================
        /*
                     локаторы  ШАПКИ страницы
                                                    */

    private final By orderBtn = By.xpath(".//div[2]/button[1][@class='Button_Button__ra12g']");
    private final By statusOrderBtn = By.xpath(".//div[2]/button[2][@class = 'Header_Link__1TAG7']");
    private final By scooterBtn = By.xpath("//a[2]/img[@src = '/assets/scooter.svg' and @alt = 'Scooter']"); // Кнопка в шапке, которая должна возвращать на главную страницу
    private final By scrollDown = By.xpath(".//img[contains(@alt, 'Scroll')]"); //Кнопочка которая должна позволять скролить страницу сразу вниз
    private final By cookieBtn = By.xpath(".//div[2]/button[@class = 'App_CookieButton__3cvqF' and @id = 'rcc-confirm-button']");
        // Локаторы для ассертов:
            private final By welcomeText = By.xpath(".//div[2]/div[@class = 'Home_Header__iJKdX' and text() = 'Самокат '] ");




//======================================================================================================================
        /*
                    локаторы ЦЕНТРА страницы
                                                     */

    private final By orderBigBtn = By.xpath(".//div[5]/button[@class = 'Button_Button__ra12g Button_UltraBig__UU3Lp']");
        // Локаторы для ассертов:
            private final By howIsItWorks = By.xpath(".//div[4]/div[1][text() = 'Как это работает']");




//======================================================================================================================
        /*
                         Методы страницы MainPage
                                                                             */
//     Метод для скролла к подвалу страницы, к блоку "Вопросы о важном"
//    public  MainPage scrollForFAQBlock() {
//        WebElement element = driver.findElement();
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//        return this;
//    }

    public MainPage clickOnCookieBtn() {
        driver.findElement(cookieBtn).click();
        return this;
    }

    public MainPage wait2Seconds() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return this;
    }

    public OrderPage goOnOrderPage() {
        driver.findElement(orderBtn).click();
        return new OrderPage(driver);
    }


}
