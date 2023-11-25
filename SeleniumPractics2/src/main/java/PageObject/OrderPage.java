package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class OrderPage {

    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //===================================================================================================
        /*
                     Локаторы   подстраницы с полями для ввода для создания заказа (ПЕРВАЯ СТРАНИЦА ОФОРМЛЕНИЯ ЗАКАЗА)
                                                                                                                        */

    private final By nameInput = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    private final By secondNameInput = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    private final By adresInput = By.xpath(".//input[contains(@placeholder, 'куда привезти')]");
    private final By metroInput = By.xpath(".//div/input[@class = 'select-search__input']");
    private final By phoneInput = By.xpath(".//input[contains(@placeholder, 'на него')]");
    private final By nextBtn = By.xpath(".//button[text() = 'Далее']");


    private final By neededMetroVariant = By.className("Order_SelectOption__82bhS.select-search__option"); // После ввода Сокольники, должен показаться список и нужный мне вариант там
    private final By alterNeededMetroVariant = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li[1]/button");
    //===================================================================================================
        /*
                     Локаторы   подстраницы с полями для ввода для создания заказа (ВТОРАЯ СТРАНИЦА ОФОРМЛЕНИЯ ЗАКАЗА "ПРО АРЕНДУ")
                                                                                                                                        */
    private final By whenDeliveryInput = By.xpath(".//*[@placeholder = '* Когда привезти самокат']"); // Тоже при клике выводится лист, соответвенно подсоединяю локатор
    //                private final By chooseDeliveryTime = By.xpath(".//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[@class = 'react-datepicker__day react-datepicker__day--026']");

    private final By periodInput = By.xpath(".//div[2]/div/div[@class = 'Dropdown-placeholder']"); // При клике должен вывестись лист, соответственно подсоединяю  дополнительный локатор
        private final By choosePeriod = By.xpath(".//div[@class = 'Dropdown-menu']/div[text() = 'трое суток']");

    private final By blackColorOfScooterCheckbox = By.id("black");
    private final By commentForCourierInput = By.xpath(".//div[2]/div[4]/input[@class = 'Input_Input__1iN_Z Input_Responsible__1jDKN']");
    private final By finishOrderBtn = By.xpath(".//div[3]/button[2]");

    //Локатор для модального окна, где нужно подтвердить заказ
    private final By locatorForCheckModalIsVisible = By.xpath(".//div/div[@class = 'Order_ModalHeader__3FDaJ']");
        private final By sayYesOnModalWindow = By.xpath(".//div/div[@class = 'Order_Modal__YZ-d3']/div[@class = 'Order_Buttons__1xGrp']/button[2]");

    private final By checkStatusBtn = By.xpath("//div[5]/div[2]/button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    private final By locatorForExtractStatusOrderId = By.xpath("/html/body/div/div/div[2]/div[1]/div/input");
    //==============================================
        /*
                        Локаторы для АССЕРТОВ
                                                 */
    private final By locatorForSuccessOrderMessage = By.xpath(".//div/div[@class = 'Order_Modal__YZ-d3']/div[@class = 'Order_ModalHeader__3FDaJ' and contains(text(), 'оформлен')]");

    //==============================================
        /*
                        Методы
                                                */

    public OrderPage fillOrderForm() {
        driver.findElement(nameInput).sendKeys("Дарк");
        driver.findElement(secondNameInput).sendKeys("Соулс");
        driver.findElement(adresInput).sendKeys("Г.Москва, улица Муранно, д.33");
        driver.findElement(phoneInput).sendKeys("892211133256");
        return this;
    }

    public OrderPage choiceMetro() {
        driver.findElement(metroInput).sendKeys("Сокольники");
        try { // Натыкаюсь иногда на ошибку, когда локатор не находится в выпадающем списке, поэтому обрабатываю эту ошибку и добавляю альтернативный способ поиска локатора
            driver.findElement(neededMetroVariant).click();
        } catch (Exception exception) {
            System.out.println("Локатор выбора метро из выпадающего списка не был успешно найден чтобы кликнуть по нему, запускаю альтернативный код");
            System.out.println("____________________________________________________________________________________________________________________");
        } finally {
            driver.findElement(alterNeededMetroVariant).click();
        }
        return this;
    }

    public OrderPage clickNextOnPageAboutRent() {
        driver.findElement(nextBtn).click();
        return this;
    }

    public OrderPage chooseWhenDelivery() {
        driver.findElement(whenDeliveryInput).sendKeys("25.02.2023");
        driver.findElement(whenDeliveryInput).sendKeys(Keys.ENTER);
        // driver.findElement(chooseDeliveryTime).click();
        return this;
    }

    public OrderPage choosePeriod() {
        driver.findElement(periodInput).click();
        driver.findElement(choosePeriod).click();
        return this;
    }

    public OrderPage fillOtherInputsOnAboutRentPage() {
        driver.findElement(blackColorOfScooterCheckbox).click();
        driver.findElement(commentForCourierInput).sendKeys("С полным зарядом!");
        driver.findElement(finishOrderBtn).click();
        // После клика должно появится окно с подтверждением заказа, там нужном выбрать вариант "Да", соответственно, ожидаю появление этого окна по локатору
        driver.findElement(locatorForCheckModalIsVisible).isDisplayed();
        driver.findElement(sayYesOnModalWindow).click();
        return this;
    }

    public boolean checkSuccessOrder() {
        try {
            return driver.findElement(locatorForSuccessOrderMessage).isDisplayed();
        } catch (Exception e) {
            System.out.println("Тест по проверке заказа самоката ПРОВАЛИЛСЯ!");
        }
        return driver.findElement(locatorForSuccessOrderMessage).isDisplayed();
    }

    // Метод расчитан на то, что заказ был успешно создан, чтобы извлечь id заказа и работать с ним

    static String idOrder;
    public String checkStatusOrderAndSaveThisId() {
        driver.findElement(checkStatusBtn).click();
        idOrder = driver.findElement(locatorForExtractStatusOrderId).getText();
        return "Манипуляция прошла УСПЕШНО! ID заказа: " + idOrder;
    }
}
