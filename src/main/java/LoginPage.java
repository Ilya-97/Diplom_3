import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Кнопка "Зарегистрироваться"
    private By registrationLink = By.xpath("//a[@href = '/register']");
    //Кнопка "Восстановить пароль"
    private By forgotLink = By.xpath("//a[@href = '/forgot-password']");
    //Кнопка "Войти"
    By enterButton = By.xpath("//form[@class='Auth_form__3qKeq mb-20']/button");
    //Поле для ввода "email"
    private By enterEmailField = By.xpath("//input[@name='name']");
    // Поле для ввода пароля
    private By enterPasswordField = By.xpath("//input[@name='Пароль']");
    //Заголовок для  экрана авторизации
    public By loginTitle = By.xpath("//h2[text() = 'Вход']");

    //Нажатие на кнопку "Зарегистрироваться"
    public void regLinkClick(){
        driver.findElement(registrationLink).click();
    }
    //Нажатие на кнопку "Восстановить пароль"
    public void forgotLinkClick(){
        driver.findElement(forgotLink).click();
    }
    //Заполнение полей email и пароля
    public void loginFieldsFill(String email, String password){
        driver.findElement(enterEmailField).sendKeys(email);
        driver.findElement(enterPasswordField).sendKeys(password);
    }

    //Проверка текста на кнопке "Войти"
    public String getLoginButtonText(){
        return driver.findElement(enterButton).getText();
    }
    //Нажатие на кнопку "Войти"
    public void enterButtonClick(){
        driver.findElement(enterButton).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[text() ='Соберите бургер']")));
    }

}
