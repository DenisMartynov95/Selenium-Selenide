package PageObject;

import org.openqa.selenium.*;

import java.util.ArrayList;
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
                         локаторы ПОДВАЛА страницы.
                                                                             */

    // Огромный блок с локаторами "Вопросы о важном"
    // OPEN_QUESTION_1 - ЭТО КНОПКА ДЛЯ ВЫПАДАЮЩЕГО ANSWER. Суть проверки заключается в открытии ANSWER и сравнении, что у каждого вопроса есть опеределенный ответ
    private static final By QUESTIONS = By.xpath(".//div[@id='accordion__heading-0']");

        public static final By OPEN_QUESTION_1 = By.id("accordion__heading-0");
            public static final By QUESTIONS_1 = By.xpath(".//div[@id='accordion__heading-0']");

        public static final By OPEN_QUESTION_2 = By.id("accordion__heading-1");
            public static final By QUESTIONS_2 = By.xpath(".//div[@id='accordion__heading-1']");

        public static final By OPEN_QUESTION_3 = By.id("accordion__heading-2");
            public static final By QUESTIONS_3 = By.xpath(".//div[@id='accordion__heading-2']");

        public static final By OPEN_QUESTION_4 = By.id("accordion__heading-3");
            public static final By QUESTIONS_4 = By.xpath(".//div[@id='accordion__heading-3']");

        public static final By OPEN_QUESTION_5 = By.id("accordion__heading-4");
            public static final By QUESTIONS_5 = By.xpath(".//div[@id='accordion__heading-4']");

        public static final By OPEN_QUESTION_6 = By.id("accordion__heading-5");
            public static final By QUESTIONS_6 = By.xpath(".//div[@id='accordion__heading-5']");

        public static final By OPEN_QUESTION_7 = By.id("accordion__heading-6");
            public static final By QUESTIONS_7 = By.xpath(".//div[@id='accordion__heading-6']");

        public static final By OPEN_QUESTION_8 = By.id("accordion__heading-7");
            public static final By QUESTIONS_8 = By.xpath(".//div[@id='accordion__heading-7']");

        // Локаторы для ассертов:
            public static final By ANSWER_1 = By.xpath(".//div[2]/p[text() = 'Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");
            public static final By ANSWER_2 = By.xpath(".//div[2]/p[contains(text(),'Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.')]");
            public static final By ANSWER_3 = By.xpath(".//div[2]/p[contains(text(),'Допустим, вы оформляете заказ')]");
            public static final By ANSWER_4 = By.xpath(".//div[2]/p[contains(text(),'Только начиная с завтрашнего дня')]");
            public static final By ANSWER_5 = By.xpath(".//div[2]/p[contains(text(),'Пока что нет!')]");
            public static final By ANSWER_6 = By.xpath(".//div[2]/p[contains(text(),'Самокат приезжает к вам с полной зарядкой.')]");
            public static final By ANSWER_7 = By.xpath(".//div[2]/p[contains(text(),'Да, пока самокат не привезли. Штрафа не будет,')]");
            public static final By ANSWER_8 = By.xpath(".//div[2]/p[contains(text(),'Да, обязательно. Всем самокатов!')]");




//======================================================================================================================
        /*
                         Методы страницы MainPage
                                                                             */
    // Метод для скролла к подвалу страницы, к блоку "Вопросы о важном"
    public  MainPage scrollForFAQBlock() {
        WebElement element = driver.findElement(QUESTIONS);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        return this;
    }

    public MainPage clickOnCookieBtn() {
        driver.findElement(cookieBtn).click();
        return this;
    }

    public MainPage wait2Seconds() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return this;
    }


    //ПОДУМАЙ НАД РЕАЛИЗАЦИЕЙ ПАРАМЕТРИЗАЦИИ В ОТДЕЛЬНЫЙ ТЕСТОВЫЙ КЛАСС, А НЕ СЮДА, ТК ЗДЕСЬ ВИЖУ ВАРИАНТ ТОЛЬКО НАД СОЗДАНИЕМ ARRAYLIST И ПЕРЕБОРА ВСЕХ ВАРИАНТОВ ЦИКЛАМИ
    //НЕУДОБНО КАЖДЫЙ РАЗ ХОДИТЬ В ТЕСТОВЫЙ КЛАСС ЧТОБЫ ВНЕДРЯТЬ ЗАВИСИМОСТИ
    //НЕУДОБНО РАБОТАТЬ С ТАКИМ ОГРОМНЫМ КОЛИЧЕСТВОМ ПЕРЕМЕННЫХ И ВНЕДРЯТЬ МЕТОДЫ, НАДО ПРИДУМАТЬ КАК СДЕЛАТЬ КОД МЕНЬШЕ И ЧТОБЫ ОН РАБОТАЛ

//    public boolean checkListOfQuestionsTest() {
//        return driver.findElement(ANSWER_1).getText().contains("Сутки — 400 рублей. Оплата курьеру — наличными или картой");
//    }


}
