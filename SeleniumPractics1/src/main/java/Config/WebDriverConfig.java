package Config;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class WebDriverConfig {
    Random random = new Random();

    public static final int WAIT_2_SECONDS = 2;
    public static final int WAIT_5_SECONDS =5;

    // Переменные для тестов регистрации (№1)
    public static final String REGISTRATION_EMAIL_FIELD = RandomStringUtils.randomAlphabetic(7) +"@mail.ru";
    public static final String REGISTRATION_PASSWORD_FIELD = "sajdh213";

    // Переменные для тестов авторизации(№2 и все остальные)
    public static final String LOGIN_EMAIL_FIELD = "sadsadasd@yandex.ru";
    public static final String LOGIN_PASSWORD_FIELD = "123456";
            // Переменные для 1)Подмены урла , а затем 2)Проверка введенного урла,для ассерта
    public static final String LOGO_URL = "https://e7.pngegg.com/pngimages/444/134/png-clipart-obi-wan-kenobi-star-wars-obi-wan-lego-minifigure-lego-star-wars-others-toy-block-anakin-skywalker.png";
    public static final String ASSERT_LOGO_URL = "https://e7.pngegg.com/pngimages/444/134/png-clipart-obi-wan-kenobi-star-wars-obi-wan-lego-minifigure-lego-star-wars-others-toy-block-anakin-skywalker.png";

            // Переменные для теста №3 и №4
    public static final String NEW_NAME = "Денис";
    public static final String NEW_ALIAS = "QA Java";

            // Переменные для теста №5
    public static final String NEW_PLACE_NAME = "Казань";
    public static final String NEW_PICTURE_URL = "https://planetofhotels.com/guide/sites/default/files/styles/paragraph__live_banner__lb_image__1880bp/public/live_banner/Kazan-1.jpg";

            // Переменная для теста №6
    public static final String DEFAULT_PLACE_NAME = "Москва сити";

            // Переменная для теста №7
    public static final String EXPECTED_LIKE_COUNT = "1";
}
