package Pages;

import Config.WebDriverConfig;
import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        try {
            Thread.sleep(2000); // Приостановите выполнение на 2 секунды, так как тест летит слишком вперед после авторизации
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //
        //
            //
                // Методы и переменные для теста №2

    private final By btnAddLogo = By.xpath("//div[@class = 'profile__image']");
    private final By changeLogoField = By.id("owner-avatar");
    private final By btnSaveLogo = By.xpath(".//form[@name='edit-avatar']/button[text()='Сохранить']");
    // Для ассерта
    private final By getLogoUrl = By.cssSelector(".profile__image[style*='background-image: url']"); //Получаю измененный урл через css, так как оттуда стили легко брать, а нужный мне урл отображается только в стилях

    public MainPage addLogoAndSave(){
        driver.findElement(btnAddLogo).click();
        driver.findElement(changeLogoField).clear();
        driver.findElement(changeLogoField).sendKeys(WebDriverConfig.LOGO_URL);
        driver.findElement(btnSaveLogo).isDisplayed();
        driver.findElement(btnSaveLogo).click();
        return this;
    }

    public boolean checkLogoUrl(){ // Проверяю урл добавленного логотипа,получаю атрибут style у css, затем сравниваю с тем значением, которое взял из переменной в классе WebDriverConfig
        return driver.findElement(getLogoUrl).getAttribute("style").contains(WebDriverConfig.ASSERT_LOGO_URL);
    }

    //
        //
            //
                // Методы и переменные для теста №3 и №4

    private final By btnChangeName = By.xpath("//div[@class = 'profile__info']/button[contains(@class, 'profile__edit-button') and contains(@type, 'button')]");
    private final By newNameField = By.id("owner-name");
    private final By newAliasField = By.id("owner-description");
    private final By btnSaveNewName = By.xpath(".//form[@name='edit']/button[text() = 'Сохранить']");
    // Для ассерта
    private final By getNewNameField = By.xpath("//h1[@class='profile__title']");
    private final By getNewAliasField = By.xpath("//p[text() = 'QA Java']");

    public MainPage changeNameButtonClick() {
        driver.findElement(btnChangeName).click();
        return this;
    }
    public MainPage setNewNameAndAlias() {
        driver.findElement(newNameField).clear();
        driver.findElement(newNameField).sendKeys(WebDriverConfig.NEW_NAME);
        driver.findElement(newAliasField).clear();
        driver.findElement(newAliasField).sendKeys(WebDriverConfig.NEW_ALIAS);
        driver.findElement(btnSaveNewName).click();
        return this;
    }


    public boolean checkNewName(){
        return driver.findElement(getNewNameField).getText().contains(WebDriverConfig.NEW_NAME);

    }
    public boolean checkNewAlias(){
        return driver.findElement(getNewAliasField).getText().contains(WebDriverConfig.NEW_ALIAS);
    }

    //
        //
            //
                // Методы и переменные для теста №5

    private final By addBtn = By.xpath(".//button[@class ='profile__add-button']");
    private final By locatorForVisibleModalText = By.xpath("//form/h3[text() = 'Новое место']"); // Нужен для того, чтобы проверить, что нужная модалка открылась
    private final By newPlaceNameField = By.xpath("//div/form[@name = 'new-card']//input[@id ='place-name']");
    private final By newPictureUrlField = By.xpath("//div/form[@name = 'new-card']//input[@id ='place-link']");
    private final By btnSaveNewPlace = By.xpath("//div/form[@name = 'new-card']//button[contains(text(), 'Сохранить')]");
    // Для ассерта
    private final By newCardLocator = By.xpath("/html/body/div/div/main/section[2]/ul/li[position()=1]//h2[@class = 'card__title' and contains(text(), 'Казань')]");

    public MainPage clickOnAddCardBtn(){
        driver.findElement(addBtn).click();
        return this;
    }

    public MainPage locatorForVisibleModalText() {
        driver.findElement(locatorForVisibleModalText).isDisplayed();
        return this;
    }
    public MainPage setNewPlaceFields(){
        driver.findElement(newPlaceNameField).sendKeys(WebDriverConfig.NEW_PLACE_NAME);
        driver.findElement(newPictureUrlField).sendKeys(WebDriverConfig.NEW_PICTURE_URL);
        driver.findElement(btnSaveNewPlace).click();
        return this;
    }


    public boolean checkNewCard() {
        return driver.findElement(newCardLocator).getText().contains(WebDriverConfig.NEW_PLACE_NAME);
    }

        //
            //
                //
                    // Методы и переменные для теста №6 (некоторые нужные методы мне, уже написаны в №5)

    //private final By btnDeleteCard = By.xpath("/html/body/div/div/main/section[2]/ul/li[position()=1]/button[not(@style= 'visibility: hidden')]"); //Изначально кнопка скрыта, добавил фильтр
    private final By btnDeleteCard = By.xpath("/html/body/div/div/main/section[2]/ul/li[position()=1]/button[@class = 'card__delete-button card__delete-button_visible']");
    // Для ассерта
    private final By defaultCardLocator = By.xpath("/html/body/div/div/main/section[2]/ul/li[position()=1]//h2[@class = 'card__title' and contains(text(), 'Москва сити')]");

    public MainPage btnDeleteForVisible() {
        driver.findElement(btnDeleteCard).isDisplayed();
        return this;
    }
    public MainPage deleteCard() {
        driver.findElement(btnDeleteCard).click();
        return this;
    }

    public boolean checkIsCardHasDeleted() {
        return driver.findElement(defaultCardLocator).getText().contains(WebDriverConfig.DEFAULT_PLACE_NAME);
    }

        //
            //
                //
                    // Методы и переменные для теста №7

    private final By btnLikeCard = By.xpath("/html/body/div/div/main/section[2]/ul/li[2550]/div[2]/div/button[@type = 'button']");
    // Для ассерта
    private final By getLikeCounts = By.xpath("//ul/li[position()=2550]//p[@class = 'card__like-count']");

    public MainPage likeCard() {
        driver.findElement(btnLikeCard).click();
        return this;
    }

    public boolean checkLikeCard(){
        return driver.findElement(getLikeCounts).getText().contains(WebDriverConfig.EXPECTED_LIKE_COUNT);
    }


}

