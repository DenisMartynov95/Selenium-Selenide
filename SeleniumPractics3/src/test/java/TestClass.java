import PageObject.KazanPage;
import PageObject.MainPage;
import WebDriverFactory.Asserts;
import WebDriverFactory.UrlSettings;
import WebDriverFactory.WaitSettings;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClass {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage"); // , "--headless"
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WaitSettings.WAIT_2_SECOND, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(WaitSettings.WAIT_5_SECONDS, TimeUnit.SECONDS);
            driver.quit();
        }
    }


    @Test
    @Step
    @DisplayName("Тест №1: Функционал выбора точки геолокации")
    public void t1_chooseGeoCurrent() {
        driver.get(UrlSettings.MAIN_PAGE_URL);
        boolean checkChosenCurrent = new MainPage(driver)
                .changeGeoCity()
                        .checkChosenCurrent();
        MatcherAssert.assertThat(Asserts.CHOSEN_CITY, checkChosenCurrent);
        System.out.println("Тест №1 прошел успешно!");
    }

    @Test
    @Step
    @DisplayName("Тест №2: Функционал выбора тура")
    public void t2_chooseTour() {
        driver.get(UrlSettings.KAZAN_PAGE_URL);
        boolean checkSuccessBookingTour() {

        }
    }
}
