package ParametrizedTests;

import PageObject.MainPage;
import WebDriverFactory.UrlSettings;
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

//===============================================================================================================================================================
     /*
        БЛОК КОДА связанный с работой самого теста, поместил сюда и настройку и исполняемый код
                                                                                                    */
    private WebDriver driver;
    private List<By> actual = questionLocators;
    private List<String> expected = expectedTextForQuestions;
    private boolean result;

    public checkQuestions(List<By> questionLocators, List<String> expectedTextForQuestions, boolean result) {
        this.actual = questionLocators;
        this.expected = expectedTextForQuestions;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {{questionLocators.get(0), expectedTextForQuestions.get(0), true},
                {questionLocators.get(1),expectedTextForQuestions.get(1),true},
                {questionLocators.get(2),expectedTextForQuestions.get(2),true},
                {questionLocators.get(3),expectedTextForQuestions.get(3),true},
                {questionLocators.get(4),expectedTextForQuestions.get(4),true},
                {questionLocators.get(5),expectedTextForQuestions.get(5),true},
                {questionLocators.get(6),expectedTextForQuestions.get(6),true},
                {questionLocators.get(7),expectedTextForQuestions.get(7),true},
        };
    }


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

    @Test
    public void checkQuestions() {
        driver.get(UrlSettings.URL1);

        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnCookieBtn();
        mainPage.scrollForFAQBlock();
        driver.findElement((By) questionLocators).getText();
        String expected =driver.findElement((By) expectedTextForQuestions).getText();
        Assert.assertEquals(expected, actual);
    }


}
