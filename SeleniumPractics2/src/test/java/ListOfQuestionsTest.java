import org.example.ScooterOrderPage;
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

import java.util.concurrent.TimeUnit;

import static org.example.ScooterOrderPage.*;


@RunWith(Parameterized.class)
public class ListOfQuestionsTest {



    private WebDriver driver;

    private By question;
    private By answer;
    private  String expected;

    public ListOfQuestionsTest(By question, By answer, String expected) {
        this.question = question;
        this.answer = answer;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{{QUESTIONS_1, ANSWER_TO_QUESTIONS_1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {QUESTIONS_2, ANSWER_TO_QUESTIONS_2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {QUESTIONS_3, ANSWER_TO_QUESTIONS_3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {QUESTIONS_4, ANSWER_TO_QUESTIONS_4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {QUESTIONS_5, ANSWER_TO_QUESTIONS_5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {QUESTIONS_6, ANSWER_TO_QUESTIONS_6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {QUESTIONS_7, ANSWER_TO_QUESTIONS_7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {QUESTIONS_8, ANSWER_TO_QUESTIONS_8,"Да, обязательно. Всем самокатов! И Москве, и Московской области."}

        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }
    @Test
    public void listOfQuestionsTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ScooterOrderPage page = new ScooterOrderPage(driver);
        page.openPageAddCookies();
        WebElement element = driver.findElement(LIST_OF_QUESTIONS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(question).click();
        String actual = driver.findElement(answer).getText();
        Assert.assertEquals(expected, actual);

    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
