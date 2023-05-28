import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;


public class LoginTest extends Data {
    @Test
    @DisplayName("Авторизация личный кабинет ссылка")
    public void authHappyFromMainLoginButtonTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFieldsFill(emailExist, passExist);
        loginPage.enterButtonClick();
        Assert.assertEquals("Оформить заказ", mainPage.getOrderCreateButtonAfterLogin());
    }

    @Test
    @DisplayName("Авторизация основная кнопка ссылка")
    public void authHappyFromMainTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.loginButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFieldsFill(emailExist, passExist);
        loginPage.enterButtonClick();
        Assert.assertEquals("Оформить заказ", mainPage.getOrderCreateButtonAfterLogin());
    }

    @Test
    @DisplayName("Авторизация переход с регистрации ссылка")
    public void authHappyFromRegTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.regLinkClick();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.loginPageLinkClick();
        loginPage.loginFieldsFill(emailExist, passExist);
        loginPage.enterButtonClick();
        Assert.assertEquals("Оформить заказ", mainPage.getOrderCreateButtonAfterLogin());
    }

    @Test
    @DisplayName("Авторизация. Переход с восстановления пароля ссылка")
    public void authHappyFromForgotPassTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.forgotLinkClick();
        ForgorPasswordPage forgorPasswordPage = new ForgorPasswordPage(driver);
        forgorPasswordPage.loginLinkClick();
        loginPage.loginFieldsFill(emailExist, passExist);
        loginPage.enterButtonClick();
        Assert.assertEquals("Оформить заказ", mainPage.getOrderCreateButtonAfterLogin());
    }
}
