import PageObject.MainPage;
import PageObject.OrderPage;
import WebDriverFactory.AssertsForSimpleTests;
import WebDriverFactory.TestsData;
import WebDriverFactory.UrlSettings;
import WebDriverFactory.WaitSettings;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.IsEqual.equalTo;

public class Tests {

    private WebDriver driver;

//    @Before
//    public void setUpChrome() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(WaitSettings.WAIT_2_SECOND, TimeUnit.SECONDS); //Выставил ожидание для всех методов findElement с 2 секундами, использовал переменную из класса WebDriverConfig
//    }

    @Before
    public void setUpFirefox() {
        System.setProperty("webdriver.gecko.driver", "C:\\WebDriverFirefox\\bin\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WaitSettings.WAIT_2_SECOND, TimeUnit.SECONDS);

    }

//    @After
//    public void shutDown() {
//        driver.quit();
//    }

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
                .chooseWhenDelivery()
                .choosePeriod()
                .fillOtherInputsOnAboutRentPage()
                .checkSuccessOrder();
        MatcherAssert.assertThat(AssertsForSimpleTests.SUCCESS_ORDER_MESSAGE, checkSuccessOrder);
        System.out.println("Тест по проверке заказа самоката прошел успешно!");
    }

    @Test // Пока тут проблема с выводом нужной строки с ID, надо решить её, в целом тест проходит, чую надо пошаманить над локатором
    @Step
    @DisplayName("Тест по изъятию ID заказа")
    public void extractIdOrder() {
        driver.get(UrlSettings.URL1);
        String getIdOrder = new MainPage(driver)
                .clickOnCookieBtn()
                .goOnOrderPage()
                .fillOrderForm()
                .choiceMetro()
                .clickNextOnPageAboutRent()
                .chooseWhenDelivery()
                .choosePeriod()
                .fillOtherInputsOnAboutRentPage()
                .checkStatusOrderAndSaveThisId();
        if (getIdOrder != null) { // Впихнул условия для того, чтобы отследить, что переменная в итоге не нулевая, а то были ошибки в коде в этом месте
            System.out.println(getIdOrder);
        } else {
            System.out.println("Тест №2 провалился");
        }
    }

    @Test // ПРОБЛЕМА, СТАТИЧНАЯ ПЕРЕМЕННАЯ ОБНУЛЯЕТСЯ ПОСЛЕ ТЕСТА №3
    @Step
    @DisplayName("Тест по проверке функции поиска заказа по ID, который уже был присвоен в тесте №2")
    public void checkOrder() {
        driver.get(UrlSettings.URL1);

        boolean checkOrder = new MainPage(driver)
                .clickOnCookieBtn()
                .logsIdOrderValue()
                .fillInputsForCheckOrderTest()
                .checkOrder();
        MatcherAssert.assertThat(AssertsForSimpleTests.ORDER_NAME, checkOrder);
        System.out.println("Тест №3 прошел успешно!");

    }
    }
