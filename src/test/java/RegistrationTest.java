import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationTest extends Data {
    @Test
    @DisplayName("Успешная регистрация")
    @Description("Регистрация, переход с главного экрана по кнопке Личный кабинет и последующий переход по кнопке Зарегистрироваться")
    public void registrationHappyFlow() {
        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.regLinkClick();
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.regDataInput("Николай_77", "nikolay_test77@email.ru", "Qwerty");
        registrationPage.regButtonClick();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginPage.loginTitle));
        Assert.assertEquals("Войти", loginPage.getLoginButtonText());
    }

    @Test
    @DisplayName("Неуспешная регистрация с некоррктным паролем")
    @Description("Регистрация, переход с главного экрана по кнопке Личный кабинет и последующий переход по кнопке Зарегистрироваться")
    public void registrationUnhappyFlow() {
        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.regLinkClick();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.regDataInput("Olga_97", "olga_97@email.ru", "!!!");
        registrationPage.regButtonClick();
        Assert.assertEquals("Некорректный пароль", registrationPage.stopPassText());
    }
}
