package ParametrizedTests;

import PageObject.MainPage;
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


@RunWith(Parameterized.class)
public class checkQuestions {

//===============================================================================================================
    /*
        БЛОК КОДА связанный с локаторами, где должен храниться определенный вопрос. Поместил данный список локаторов в один лист questionLocators
                                                                                                                                                     */
    public static final By ADD_COOKIE_BTN = By.className("App_CookieButton__3cvqF"); // Локатор для принятия куки

    public static final By QUESTIONS_1 = By.xpath(".//div[@id='accordion__heading-0']");
    public static final By QUESTIONS_2 = By.xpath(".//div[@id='accordion__heading-1']");
    public static final By QUESTIONS_3 = By.xpath(".//div[@id='accordion__heading-2']");
    public static final By QUESTIONS_4 = By.xpath(".//div[@id='accordion__heading-3']");
    public static final By QUESTIONS_5 = By.xpath(".//div[@id='accordion__heading-4']");
    public static final By QUESTIONS_6 = By.xpath(".//div[@id='accordion__heading-5']");
    public static final By QUESTIONS_7 = By.xpath(".//div[@id='accordion__heading-6']");
    public static final By QUESTIONS_8 = By.xpath(".//div[@id='accordion__heading-7']");

//    public static List<By> questionLocators = new ArrayList<>(); // Локаторы с содержимым текста вопроса.
//    static {
//        questionLocators.add(QUESTIONS_1);
//        questionLocators.add(QUESTIONS_2);
//        questionLocators.add(QUESTIONS_3);
//        questionLocators.add(QUESTIONS_4);
//        questionLocators.add(QUESTIONS_5);
//        questionLocators.add(QUESTIONS_6);
//        questionLocators.add(QUESTIONS_7);
//        questionLocators.add(QUESTIONS_8);
//    }


//=====================================================================================================================
     /*
        БЛОК КОДА связанный с параметризацией
                                                                                                    */
    private WebDriver driver;
    private final By question;
    private final String expected;

    public checkQuestions(By question, String expected) {
        this.question = question;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {{QUESTIONS_1,Asserts.EXPECTED_TEXT_1_QUESTION},
                {QUESTIONS_2, Asserts.EXPECTED_TEXT_2_QUESTION},
                {QUESTIONS_3,Asserts.EXPECTED_TEXT_3_QUESTION},
                {QUESTIONS_4,Asserts.EXPECTED_TEXT_4_QUESTION},
                {QUESTIONS_5,Asserts.EXPECTED_TEXT_5_QUESTION},
                {QUESTIONS_6,Asserts.EXPECTED_TEXT_6_QUESTION},
                {QUESTIONS_7,Asserts.EXPECTED_TEXT_7_QUESTION},
                {QUESTIONS_8,Asserts.EXPECTED_TEXT_8_QUESTION},
        };
    }



    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--headless");
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
    }

    /*
   БЛОК КОДА связанный с самим тестом
                                                                                    */
    @Test
    public void checkQuestions() {
        driver.get(UrlSettings.URL1);

        driver.findElement(ADD_COOKIE_BTN).click(); // Нажал "Принять куки"

        WebElement element = driver.findElement(By.xpath(".//div[@class = 'accordion']")); //  ↓
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);  // Скроллю до нужного элемента

        String actual = driver.findElement(question).getText();
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception exception) {
            System.out.println("Произошла ошибка! Перепроверь ассерты");
        } finally {
            Assert.assertEquals(actual, expected);
            System.out.println("Проверка ассерта: " + actual);
            System.out.println("Кейс проверен успешно!");
            System.out.println("___________________________________________");
        }
    }

    @After
    public void shutDown() {
        driver.quit();
    }

}

