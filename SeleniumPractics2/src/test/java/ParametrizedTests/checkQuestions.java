package ParametrizedTests;

import PageObject.MainPage;
<<<<<<< HEAD
import WebDriverFactory.Asserts;
import WebDriverFactory.UrlSettings;
import org.junit.After;
=======
import WebDriverFactory.UrlSettings;
>>>>>>> 54f8fcfb79fc1589a0a463589356ec763bf26b50
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

<<<<<<< HEAD

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

=======
@RunWith(Parameterized.class)
public class checkQuestions {

//===============================================================================================================================================================
    /*
        БЛОК КОДА связанный с локаторами, где должен храниться определенный вопрос. Поместил данный список локаторов в один лист questionLocators
                                                                                                                                                     */
    private static final By QUESTIONS_1 = By.xpath(".//div[@id='accordion__heading-0']");
    private static final By QUESTIONS_2 = By.xpath(".//div[@id='accordion__heading-1']");
    private static final By QUESTIONS_3 = By.xpath(".//div[@id='accordion__heading-2']");
    private static final By QUESTIONS_4 = By.xpath(".//div[@id='accordion__heading-3']");
    private static final By QUESTIONS_5 = By.xpath(".//div[@id='accordion__heading-4']");
    private static final By QUESTIONS_6 = By.xpath(".//div[@id='accordion__heading-5']");
    private static final By QUESTIONS_7 = By.xpath(".//div[@id='accordion__heading-6']");
    private static final By QUESTIONS_8 = By.xpath(".//div[@id='accordion__heading-7']");

    public static List<By> questionLocators = new ArrayList<>(); // Локаторы с содержимым текста вопроса.
    static {
        questionLocators.add(QUESTIONS_1);
        questionLocators.add(QUESTIONS_2);
        questionLocators.add(QUESTIONS_3);
        questionLocators.add(QUESTIONS_4);
        questionLocators.add(QUESTIONS_5);
        questionLocators.add(QUESTIONS_6);
        questionLocators.add(QUESTIONS_7);
        questionLocators.add(QUESTIONS_8);
    }

//===============================================================================================================================================================
     /*
        БЛОК КОДА связанный с локаторами, где должен храниться определенный вопрос. Поместил данный список локаторов в один лист expectedTextForQuestions
                                                                                                                                                              */
    private static final String EXPECTED_TEXT_1_QUESTION = "Сколько это стоит? И как оплатить?";
    private static final String EXPECTED_TEXT_2_QUESTION = "Хочу сразу несколько самокатов! Так можно?";
    private static final String EXPECTED_TEXT_3_QUESTION = "Как рассчитывается время аренды?";
    private static final String EXPECTED_TEXT_4_QUESTION = "Можно ли заказать самокат прямо на сегодня?";
    private static final String EXPECTED_TEXT_5_QUESTION = "Можно ли продлить заказ или вернуть самокат раньше?";
    private static final String EXPECTED_TEXT_6_QUESTION = "Вы привозите зарядку вместе с самокатом?";
    private static final String EXPECTED_TEXT_7_QUESTION = "Можно ли отменить заказ?";
    private static final String EXPECTED_TEXT_8_QUESTION = "Я жизу за МКАДом, привезёте?";

    public static List<String> expectedTextForQuestions = new ArrayList<>();
    static {
        expectedTextForQuestions.add(EXPECTED_TEXT_1_QUESTION);
        expectedTextForQuestions.add(EXPECTED_TEXT_2_QUESTION);
        expectedTextForQuestions.add(EXPECTED_TEXT_3_QUESTION);
        expectedTextForQuestions.add(EXPECTED_TEXT_4_QUESTION);
        expectedTextForQuestions.add(EXPECTED_TEXT_5_QUESTION);
        expectedTextForQuestions.add(EXPECTED_TEXT_6_QUESTION);
        expectedTextForQuestions.add(EXPECTED_TEXT_7_QUESTION);
        expectedTextForQuestions.add(EXPECTED_TEXT_8_QUESTION);
    }
>>>>>>> 54f8fcfb79fc1589a0a463589356ec763bf26b50

//===============================================================================================================================================================
     /*
        БЛОК КОДА связанный с работой самого теста, поместил сюда и настройку и исполняемый код
                                                                                                    */
    private WebDriver driver;
<<<<<<< HEAD
    private final By question;
    private final String expected;

    public checkQuestions(By question, String expected) {
        this.question = question;
        this.expected = expected;
=======
    private List<By> actual = questionLocators;
    private List<String> expected = expectedTextForQuestions;
    private boolean result;

    public checkQuestions(List<By> questionLocators, List<String> expectedTextForQuestions, boolean result) {
        this.actual = questionLocators;
        this.expected = expectedTextForQuestions;
        this.result = result;
>>>>>>> 54f8fcfb79fc1589a0a463589356ec763bf26b50
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
<<<<<<< HEAD
        return new Object[][] {{QUESTIONS_1,Asserts.EXPECTED_TEXT_1_QUESTION},
                {QUESTIONS_2, Asserts.EXPECTED_TEXT_2_QUESTION},
                {QUESTIONS_3,Asserts.EXPECTED_TEXT_3_QUESTION},
                {QUESTIONS_4,Asserts.EXPECTED_TEXT_4_QUESTION},
                {QUESTIONS_5,Asserts.EXPECTED_TEXT_5_QUESTION},
                {QUESTIONS_6,Asserts.EXPECTED_TEXT_6_QUESTION},
                {QUESTIONS_7,Asserts.EXPECTED_TEXT_7_QUESTION},
                {QUESTIONS_8,Asserts.EXPECTED_TEXT_8_QUESTION},
=======
        return new Object[][] {{questionLocators.get(0), expectedTextForQuestions.get(0), true},
                {questionLocators.get(1),expectedTextForQuestions.get(1),true},
                {questionLocators.get(2),expectedTextForQuestions.get(2),true},
                {questionLocators.get(3),expectedTextForQuestions.get(3),true},
                {questionLocators.get(4),expectedTextForQuestions.get(4),true},
                {questionLocators.get(5),expectedTextForQuestions.get(5),true},
                {questionLocators.get(6),expectedTextForQuestions.get(6),true},
                {questionLocators.get(7),expectedTextForQuestions.get(7),true},
>>>>>>> 54f8fcfb79fc1589a0a463589356ec763bf26b50
        };
    }


<<<<<<< HEAD

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--headless");
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
    }

=======
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    // ОШИБКА ПРИ ИСПОЛЬЗОВАНИИ ЛОКАТОРОВ, НУЖНО ОБЛЕГЧИТЬ КОД
    // НУЖНО ИЗБАВИТЬСЯ ОТ ЛИСТОВ, МОЖНО И БЕЗ НИХ СДЕЛАТЬ, ДАЖЕ ПРОЩЕ БУДЕТ
    // ПОДУМАТЬ НАДО НАД РЕАЛИЗАЦИЕЙ МЕТОДОВ И ЛОКАТОРОВ В MAINPAGE КЛАССЕ, А МОЖЕТ И НЕТ

>>>>>>> 54f8fcfb79fc1589a0a463589356ec763bf26b50
    @Test
    public void checkQuestions() {
        driver.get(UrlSettings.URL1);

<<<<<<< HEAD
        driver.findElement(ADD_COOKIE_BTN).click(); // Нажал "Принять куки"

        WebElement element = driver.findElement(By.xpath(".//div[@class = 'accordion']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        String actual = driver.findElement(question).getText();
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception exception) {
            System.out.println("Произошла ошибка! Перепроверь ассерты");
        } finally {
            Assert.assertEquals(actual, expected);
            System.out.println("Проверка ассерта: " + actual);
            System.out.println("___________________________________________");
        }
    }

    @After
    public void shutDown() {
        driver.quit();
    }
=======
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnCookieBtn();
        mainPage.scrollForFAQBlock();
        driver.findElement((By) questionLocators).getText();
        String expected =driver.findElement((By) expectedTextForQuestions).getText();
        Assert.assertEquals(expected, actual);
    }

>>>>>>> 54f8fcfb79fc1589a0a463589356ec763bf26b50

}
