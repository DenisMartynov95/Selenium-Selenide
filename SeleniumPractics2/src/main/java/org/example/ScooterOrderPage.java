package org.example;

import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class ScooterOrderPage {
    private static final String MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";
    private static final By CLICK_COOKIE = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    private WebDriver driver;
    public static final By LIST_OF_QUESTIONS = By.xpath(".//*[@class='accordion__item']");
    public static final By QUESTIONS_1 = By.xpath(".//div[@id='accordion__heading-0']");//Сколько это стоит? И как оплатить?
    public static final By QUESTIONS_2 = By.xpath(".//div[@id='accordion__heading-1']");//Хочу сразу несколько самокатов! Так можно?
    public static final By QUESTIONS_3 = By.xpath(".//div[@id='accordion__heading-2']");//Как рассчитывается время аренды?
    public static final By QUESTIONS_4 = By.xpath(".//div[@id='accordion__heading-3']");//Можно ли заказать самокат прямо на сегодня?
    public static final By QUESTIONS_5 = By.xpath(".//div[@id='accordion__heading-4']");//Можно ли продлить заказ или вернуть самокат раньше?
    public static final By QUESTIONS_6 = By.xpath(".//div[@id='accordion__heading-5']");//Вы привозите зарядку вместе с самокатом??
    public static final By QUESTIONS_7 = By.xpath(".//div[@id='accordion__heading-6']");//Можно ли отменить заказ?(".//div[@aria-disabled='true']")
    public static final By QUESTIONS_8 = By.xpath(".//div[@id='accordion__heading-7']");//Я жизу за МКАДом, привезёте?
    public static final By ANSWER_TO_QUESTIONS_1 = By.xpath(".//div[@aria-labelledby='accordion__heading-0']");//Я жизу за МКАДом, привезёте?
    public static final By ANSWER_TO_QUESTIONS_2 = By.xpath(".//div[@aria-labelledby='accordion__heading-1']");//Я жизу за МКАДом, привезёте?
    public static final By ANSWER_TO_QUESTIONS_3 = By.xpath(".//div[@aria-labelledby='accordion__heading-2']");//Я жизу за МКАДом, привезёте?
    public static final By ANSWER_TO_QUESTIONS_4 = By.xpath(".//div[@aria-labelledby='accordion__heading-3']");//Я жизу за МКАДом, привезёте?
    public static final By ANSWER_TO_QUESTIONS_5 = By.xpath(".//div[@aria-labelledby='accordion__heading-4']");//Я жизу за МКАДом, привезёте?
    public static final By ANSWER_TO_QUESTIONS_6 = By.xpath(".//div[@aria-labelledby='accordion__heading-5']");//Я жизу за МКАДом, привезёте?
    public static final By ANSWER_TO_QUESTIONS_7 = By.xpath(".//div[@aria-labelledby='accordion__heading-6']");//Я жизу за МКАДом, привезёте?
    public static final By ANSWER_TO_QUESTIONS_8 = By.xpath(".//div[@aria-labelledby='accordion__heading-7']");//Я жизу за МКАДом, привезёте?

    public ScooterOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public ScooterOrderPage openPage() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(MAIN_PAGE);
        return this;
    }

    public ScooterOrderPage addCookies() {
        driver.findElement(CLICK_COOKIE).click();
        Cookie newCookies = new Cookie("first_cookie", "10");
        driver.manage().addCookie(newCookies);
        return this;
    }

    public ScooterOrderPage openPageButton(By button) {
        WebElement element = driver.findElement(button);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(button).click();
        return this;
    }

    public void openPageAddCookiesClickOnButton(By button) {
        openPage();
        addCookies();
        openPageButton(button);
    }

    public void openPageAddCookies() {
        openPage();
        addCookies();
    }
}