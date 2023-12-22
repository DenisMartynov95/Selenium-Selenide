package ParametrizedTests;

import WebDriverFactory.Asserts;
import WebDriverFactory.UrlSettings;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

import static ParametrizedTests.checkQuestions.ADD_COOKIE_BTN;

@RunWith(Parameterized.class)
public class checkAnswers {


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

//    static List<By> openQuestions = new ArrayList<>();
//    static {
//        openQuestions.add(OPEN_QUESTION_1);
//        openQuestions.add(OPEN_QUESTION_2);
//        openQuestions.add(OPEN_QUESTION_3);
//        openQuestions.add(OPEN_QUESTION_4);
//        openQuestions.add(OPEN_QUESTION_5);
//        openQuestions.add(OPEN_QUESTION_6);
//        openQuestions.add(OPEN_QUESTION_7);
//        openQuestions.add(OPEN_QUESTION_8);
//    }



    //==================================================================================
    /*
        БЛОК КОДА связанный с локаторами, где храняться локаторы с текстом ответами
                                                                                */

    public static final By ANSWER_1 = By.xpath(".//div[1]/div[2]/p");
    public static final By ANSWER_2 = By.xpath(".//div[2]/div[2]/p");
    public static final By ANSWER_3 = By.xpath(".//div[3]/div[2]/p");
    public static final By ANSWER_4 = By.xpath(".//div[4]/div[2]/p");
    public static final By ANSWER_5 = By.xpath(".//div[5]/div[2]/p");
    public static final By ANSWER_6 = By.xpath(".//div[6]/div[2]/p");
    public static final By ANSWER_7 = By.xpath(".//div[7]/div[2]/p");
    public static final By ANSWER_8 = By.xpath(".//div[8]/div[2]/p");

    //==================================================================================
    /*
        БЛОК КОДА с параметризацией
                                                                                       */
    private WebDriver driver;
    private final By locator;
    private final By answer;
    private final String expected;

    public checkAnswers(By locator,By answer, String expected) {
        this.locator = locator;
        this.answer = answer;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static  Object [][] getParameters() {
        return new Object[][] {{OPEN_QUESTION_1, ANSWER_1, Asserts.EXPECTED_TEXT_1_ANSWER},
                {OPEN_QUESTION_2, ANSWER_2, Asserts.EXPECTED_TEXT_2_ANSWER},
                {OPEN_QUESTION_3, ANSWER_3, Asserts.EXPECTED_TEXT_3_ANSWER},
                {OPEN_QUESTION_4, ANSWER_4, Asserts.EXPECTED_TEXT_4_ANSWER},
                {OPEN_QUESTION_5, ANSWER_5, Asserts.EXPECTED_TEXT_5_ANSWER},
                {OPEN_QUESTION_6, ANSWER_6, Asserts.EXPECTED_TEXT_6_ANSWER},
                {OPEN_QUESTION_7, ANSWER_7, Asserts.EXPECTED_TEXT_7_ANSWER},
                {OPEN_QUESTION_8, ANSWER_8, Asserts.EXPECTED_TEXT_8_ANSWER},
        };
    }





    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
    }

    @Test
    public void checkAnswers() {
        driver.get(UrlSettings.URL1);

        driver.findElement(ADD_COOKIE_BTN).click(); // Нажал "Принять куки"

        WebElement element = driver.findElement(By.xpath(".//div[2]/div[@class = 'accordion']")); // ↓
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element); // Скроллю до нужного элемента

        driver.findElement(locator).click(); // Открываю вопрос, чтобы открыть блок с текстом ответа
        String actual = driver.findElement(answer).getText();
        Assert.assertEquals(actual, expected);


//        for (int i = 0; i < openQuestions.size(); i++) {
//            driver.findElement(openQuestions.get(i)).click();
//            String actual = driver.findElement(answer).getText();
//            Assert.assertEquals(actual, expected);
//        }
    }

//    @After
//    public void shutDown() {
//        driver.quit();
//    }
}
