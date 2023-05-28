import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfileTest extends Data {
    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода в личный кабинет после авторизации")
    public void openProfileAfterAuthTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFieldsFill(emailExist, passExist);
        loginPage.enterButtonClick();
        mainPage.profileButtonClick();
        ProfilePage profilePage = new ProfilePage(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(profilePage.profileLink));
        String actual = profilePage.getTextLink();
        Assert.assertEquals("Профиль", actual);
    }

    @Test
    @DisplayName("Переход на главный экран")
    @Description("Проверка перехода на главный экран из личного кабинета по нажатию на логотип")
    public void backToMainPageByLogoFromProfileTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFieldsFill(emailExist, passExist);
        loginPage.enterButtonClick();
        mainPage.profileButtonClick();
        ProfilePage profilePage = new ProfilePage(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(profilePage.profileLink));
        profilePage.logoClick();
        Assert.assertEquals("Оформить заказ", mainPage.getOrderCreateButtonAfterLogin());
    }

    @Test
    @DisplayName("Переход к конструктору по клику")
    @Description("Открытие конструктора, Главная страница")
    public void toConstructLinkTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFieldsFill(emailExist, passExist);
        loginPage.enterButtonClick();
        mainPage.profileButtonClick();
        ProfilePage profilePage = new ProfilePage(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(profilePage.profileLink));
        profilePage.constructorClick();
        String actual = mainPage.burgerMailTitle();
        Assert.assertEquals("Соберите бургер", actual);
    }

    @Test
    @DisplayName("Выход из пользователя кнопка проверка")
    @Description("Проверка кнопки разлогина в профиле")
    public void logoutLinkTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.profileButtonClick();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFieldsFill(emailExist, passExist);
        loginPage.enterButtonClick();
        mainPage.profileButtonClick();
        ProfilePage profilePage = new ProfilePage(driver);
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(profilePage.profileLink));
        profilePage.logoutLinkClick();
        new WebDriverWait(driver, 4)
                .until(ExpectedConditions.visibilityOfElementLocated(loginPage.enterButton));
        Assert.assertEquals("Войти", loginPage.getLoginButtonText());
    }
}
