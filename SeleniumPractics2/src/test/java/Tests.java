import PageObject.MainPage;
import PageObject.OrderPage;
import WebDriverFactory.AssertsForSimpleTests;
import WebDriverFactory.UrlSettings;
import WebDriverFactory.WaitSettings;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Tests {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WaitSettings.WAIT_5_SECOND, TimeUnit.SECONDS); // Так как делаю тест в условиях ооочень медленного инета
//        driver.manage().timeouts().implicitlyWait(WaitSettings.WAIT_2_SECOND, TimeUnit.SECONDS); //Выставил ожидание для всех методов findElement с 2 секундами, использовал переменную из класса WebDriverConfig
    }

    @Test
    @Step
    @DisplayName("Тест по заказу самоката")
    public void completeScooterOrderAndCheckStatusOrder() {
        driver.get(UrlSettings.URL1);
        boolean checkSuccessOrder = new MainPage(driver)
                .clickOnCookieBtn()
                .goOnOrderPage()
                .fillOrderForm()
                .choiceMetro()
                .clickNextOnPageAboutRent()
                .chooseWhenDelivery() // ВАЛИТСЯ ПОКА НА ЭТОМ, НУЖНО ИСПРОБОВАТЬ DOM BREAKPOINTS, КАК Я НАУЧИЛСЯ ЭТО ДЕЛАТЬ
                .choosePeriod()
                .fillOtherInputsOnAboutRentPage()
                .checkSuccessOrder();
//        Assert.assertEquals("Тест провалился! ",AssertsForSimpleTests.SUCCESS_ORDER_MESSAGE, checkSuccessOrder);
        MatcherAssert.assertThat(AssertsForSimpleTests.SUCCESS_ORDER_MESSAGE, checkSuccessOrder);
    }

}
