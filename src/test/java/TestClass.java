import Config.AppConfig;
import Config.WebDriverConfig;
import Pages.MainPage;
import Pages.SigninPage;
import Pages.SignupPage;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClass {
    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--headless" ); //
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WebDriverConfig.WAIT_2_SECONDS, TimeUnit.SECONDS);//Выставил ожидание для всех методов findElement с 2 секундами, использовал переменную из класса WebDriverConfig
    }

    @Test
    @Step
    @DisplayName("Тест №1: Проверка сообщения об успешной регистрации")
    public void t1_checkSuccessMessageAfterRegistration(){
        driver.get(AppConfig.URL);
        boolean checkSuccessMessage = new SignupPage(driver)
                .inputRegistrationFields()
                .checkSuccessMessage();
        assertTrue(checkSuccessMessage); // То что указал в скобках (checkSuccessMessage), не забудь указать вверху, где boolean <ВОТ ЗДЕСЬ> = new ...
        System.out.println("№1 Тест-кейс прошел успешно, регистрация успешна");
        driver.quit();
    }
    // Идем дальше, другие шаги
    @Test
    @Step
    @DisplayName("Тест №2: Добавление логотипа и проверка изменений")
    public void t2_addLogoAndCheckChanges(){
        driver.get(AppConfig.URL2);
        boolean checkLogoUrl = new SigninPage(driver)
                .logIn()
                .addLogoAndSave()
                        .checkLogoUrl();
        MatcherAssert.assertThat(WebDriverConfig.ASSERT_LOGO_URL, checkLogoUrl);
        System.out.println("№2 Тест-кейс прошел успешно, лого изменилось");
        driver.quit();
    }
    // Идем дальше, другие шаги
    @Test
    @Step
    @DisplayName("Тест №3: Изменение имени пользователя и проверка изменений")
    public void t3_changeNameAndCheckChanges() {
        driver.get(AppConfig.URL2);
        boolean checkNewName = new SigninPage(driver)
                .logIn()
                .changeNameButtonClick()
                .setNewNameAndAlias()
                .checkNewName();
        MatcherAssert.assertThat(WebDriverConfig.NEW_NAME, checkNewName);
        System.out.println("№3 Тест-кейс прошел успешно, имя изменилось");
        driver.quit();
    }
    // Идем дальше, другие шаги
    @Test
    @Step
    @DisplayName("Тест №4: Изменение псевдонима пользователя и проверка изменений")
    public void t4_changeAliasAndCheckChanges(){
        driver.get(AppConfig.URL2);
        boolean checkNewAlias = new SigninPage(driver)
                .logIn()
                .changeNameButtonClick()
                .setNewNameAndAlias()
                .checkNewAlias();
        MatcherAssert.assertThat(WebDriverConfig.NEW_ALIAS, checkNewAlias);
        System.out.println("№4 Тест-кейс прошел успешно, псевдоним изменился");
        driver.quit();
    }
    // Идем дальше, другие шаги
    @Test
    @Step
    @DisplayName("Тест №5: Добавление карты и проверка изменений")
    public void t5_addCardAndCheckChanges(){
        driver.get(AppConfig.URL2);
        boolean checkNewCard = new SigninPage(driver)
                .logIn()
                .clickOnAddCardBtn()
                .locatorForVisibleModalText()
                .setNewPlaceFields()
                        .checkNewCard();
        MatcherAssert.assertThat(WebDriverConfig.NEW_PLACE_NAME, checkNewCard);
        System.out.println("№5 Тест-кейс прошел успешно, карточка \"Казань\" добавилась");
        driver.quit();
    }
    // Идем дальше, другие шаги
    @Test
    @Step
    @DisplayName("Тест №6: Удаление карты и проверка изменений")
    public void t6_deleteCardAndCheckChanges() {
        driver.get(AppConfig.URL2);
        boolean checkIsCardHasDeleted = new SigninPage(driver)
                .logIn()
                .clickOnAddCardBtn()
                .locatorForVisibleModalText()
                .setNewPlaceFields()
                .btnDeleteForVisible()
                .deleteCard()
                        .checkIsCardHasDeleted();
        MatcherAssert.assertThat(WebDriverConfig.DEFAULT_PLACE_NAME, checkIsCardHasDeleted);
        System.out.println("№6 Тест-кейс прошел успешно, карточка удалилась успешно");
    }
    // Идем дальше, другие шаги
//    @Test
//    @Step
//    @DisplayName("Тест №7: Лайк карты и проверка изменений")
//    public void t7_likeCardAndCheckChanges() {
//        driver.get(AppConfig.URL2);
//        boolean likeCardAndCheckChanges = new SigninPage(driver)
//                .logIn()
//                .likeCard()
//                .checkLikeCard();
//        MatcherAssert.assertThat(WebDriverConfig.EXPECTED_LIKE_COUNT, likeCardAndCheckChanges);
//        System.out.println("№7 Тест-кейс прошел успешно, лайк успешно поставился");
//    }
}
