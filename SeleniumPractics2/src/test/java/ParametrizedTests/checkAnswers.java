package ParametrizedTests;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class checkAnswers {
    private WebDriver driver;


    /*
        БЛОК КОДА связанный с локаторами, где должен храниться локатор для КЛИКА, чтобы открыть ответ на вопрос
                                                                                                                     */
    public static final By OPEN_QUESTION_1 = By.id("accordion__heading-0");
    public static final By OPEN_QUESTION_2 = By.id("accordion__heading-1");
    public static final By OPEN_QUESTION_3 = By.id("accordion__heading-2");
    public static final By OPEN_QUESTION_4 = By.id("accordion__heading-3");
    public static final By OPEN_QUESTION_5 = By.id("accordion__heading-4");
    public static final By OPEN_QUESTION_6 = By.id("accordion__heading-5");
    public static final By OPEN_QUESTION_7 = By.id("accordion__heading-6");
    public static final By OPEN_QUESTION_8 = By.id("accordion__heading-7");


    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }


}
