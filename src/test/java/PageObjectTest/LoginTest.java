package PageObjectTest;

import PageObjectModel.LoginWindow;
import PageObjectModel.MainWindow;
import PageObjectModel.RecoveryPasswordWindow;
import PageObjectModel.RegistrationWindow;
import SettingsBrowser.Browser;
import UserData.ExistentUser;
import UserData.RandomCreateUser;
import UserData.RestUser;
import UserData.User;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;


public class LoginTest {

    private User user;
    private RandomCreateUser randomCreateUser;
    ExistentUser existentUser;
    private String accessToken;
    private RestUser restUser;
    private WebDriver driver;


    private static final String URL = "https://stellarburgers.nomoreparties.site/";

    static {
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(Browser.getPath(System.getenv("Chrome"))));
    }


    @Before
    @Description("Открывает страницу приложения, через API создает рандомного пользователя, авторизуется под пользователем, получает токен")
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(URL);
        user = RandomCreateUser.createRandom();
        restUser = new RestUser();
        restUser.create(user);
    }

    @After
    @Description("Выходит из браузера, через API удаляет созданного пользователя")
    public void teardown() {
        driver.quit();
        restUser.delete(accessToken, ExistentUser.from(user));
    }

    @Test
    @DisplayName("Проверка окна авторизации на главной странице")
    @Description("Проверка авторизации пользователя при нажатии на кнопку Вход на главной странице")
    public void checkLoginMainWindow(){
        MainWindow mainWindow = new MainWindow(driver);
        mainWindow.clickLoginButton();
        LoginWindow loginWindow = new LoginWindow(driver);
        loginWindow.nameFieldInput();
        loginWindow.passwordFieldInput();
        loginWindow.entranceClickButton();
        Assert.assertTrue(loginWindow.isEntranceButtonDisplayed());
    }

    @Test
    @DisplayName("Проверка окна авторизации через личный кабинет")
    @Description("Проверка авторизации пользователя при нажатии на кнопку Вход из личного кабинета")
    public void checkLoginProfile(){
        MainWindow mainWindow = new MainWindow(driver);
        mainWindow.clickProfileButton();
        LoginWindow loginWindow = new LoginWindow(driver);
        loginWindow.nameFieldInput();
        loginWindow.passwordFieldInput();
        loginWindow.entranceClickButton();
        Assert.assertTrue(loginWindow.isEntranceButtonDisplayed());
    }

    @Test
    @DisplayName("Проверка окна авторизации через форму регистрации")
    @Description("Проверка авторизации пользователя при нажатии на кнопку Вход из формы регистрации")
    public void checkLoginRegistrationForm(){
        MainWindow mainWindow = new MainWindow(driver);
        mainWindow.clickProfileButton();
        LoginWindow loginWindow = new LoginWindow(driver);
        loginWindow.registrationClick();
        RegistrationWindow registrationWindow = new RegistrationWindow(driver);
        registrationWindow.authorizationButtonClick();
        loginWindow.nameFieldInput();
        loginWindow.passwordFieldInput();
        loginWindow.entranceClickButton();
        Assert.assertTrue(loginWindow.isEntranceButtonDisplayed());

    }

    @Test
    @DisplayName("Проверка окна авторизации через форму восстановления пароля")
    @Description("Проверка авторизации пользователя при нажатии на кнопку Вход из формы восстановления пароля")
    public void checkLoginForgotPassword(){
        MainWindow mainWindow = new MainWindow(driver);
        mainWindow.clickProfileButton();
        LoginWindow loginWindow = new LoginWindow(driver);
        loginWindow.forgotPasswordButtonClick();
        RecoveryPasswordWindow recoveryPasswordWindow = new RecoveryPasswordWindow(driver);
        recoveryPasswordWindow.entranceButtonClick();
        loginWindow.nameFieldInput();
        loginWindow.passwordFieldInput();
        loginWindow.entranceClickButton();
        Assert.assertTrue(loginWindow.isEntranceButtonDisplayed());
    }

}
