package PageObjectTest;

import PageObjectModel.LoginWindow;
import PageObjectModel.MainWindow;
import PageObjectModel.RegistrationWindow;
import SettingsBrowser.Browser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import UserData.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class RegistrationTest {

    private WebDriver driver;
    private User user;
    private RestUser restUser;
    private String accessToken;

    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    static {
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(Browser.getPath(System.getenv("Chrome"))));
    }

    @Before
    @Description("Открытие браузера. Генерация клиента")
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(URL);
        user = RandomCreateUser.createRandom();
        restUser = new RestUser();
        restUser.create(user);
    }

    @After
    @Description("Закрытие браузера. Удаление клиента")
    public void teardown() {
        driver.quit();
        if(accessToken != null) {
            restUser.delete(accessToken, ExistentUser.from(user));
        }
    }

    @Test
    @DisplayName("Проверка успешной регистрации")
    @Description("Проверяет успешную регистрацию пользователя")
    public void registrationSuccess(){
        MainWindow mainWindow = new MainWindow(driver);
        mainWindow.clickProfileButton();
        LoginWindow loginWindow = new LoginWindow(driver);
        loginWindow.registrationClick();
        RegistrationWindow registrationWindow = new RegistrationWindow(driver);
        registrationWindow.nameFieldInput();
        registrationWindow.emailFieldInput(user.getEmail());
        registrationWindow.passwordFieldInput(user.getPassword());
        registrationWindow.registrationButtonClick();
        Assert.assertTrue(loginWindow.isEntranceButtonDisplayed());
        accessToken = restUser.login(ExistentUser.from(user))
                .extract().path("accessToken");
    }

    @Test
    @DisplayName("Неуспешная регистрация с некоррктным паролем")
    @Description("Проверяет появление ошибки 'Некорректный пароль' при регистрации пользователя с некорректным паролем")
    public void registrationIncorrect(){
        MainWindow mainWindow = new MainWindow(driver);
        mainWindow.clickProfileButton();
        LoginWindow loginWindow = new LoginWindow(driver);
        loginWindow.registrationClick();
        RegistrationWindow registrationWindow = new RegistrationWindow(driver);
        registrationWindow.nameFieldInput();
        registrationWindow.emailFieldInput(user.getPassword());
        registrationWindow.passwordFieldInputIncorrect();
        registrationWindow.registrationButtonClick();
        accessToken = restUser.login(ExistentUser.from(user))
                .extract().path("accessToken");
        registrationWindow.checkIncorrectPassword();
    }
}

