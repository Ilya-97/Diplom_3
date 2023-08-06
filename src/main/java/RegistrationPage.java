import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegistrationPage {
    public WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    //Поле ввода имени
    private By namePlace = By.xpath("//div[@class='Auth_login__3hAey']/form/fieldset[1]/div/div/input");

    //Поле ввода email
    private By emailPlace = By.xpath("//div[@class='Auth_login__3hAey']/form/fieldset[2]/div/div/input");
    //Поле ввода пароля
    private By passPlace = By.xpath("//div[@class='Auth_login__3hAey']/form/fieldset[3]/div/div/input");

    //Кнопка "Зарегистрироваться"
    private By regButton = By.xpath("//button[text() = 'Зарегистрироваться']");
    //Текст предупреждения о некорректном пароле
    private By stopMaskPassText = By.xpath("//p[text() = 'Некорректный пароль']");
    //Кнопка перехода на страницу авторизации
    private By  loginPageLink = By.xpath("//a[@href = '/login']");

    //Ввод данных регистрации
    public void regDataInput(String name, String email, String pass) {
        driver.findElement(namePlace).sendKeys(name);
        driver.findElement(emailPlace).sendKeys(email);
        driver.findElement(passPlace).sendKeys(pass);
    }

    //Нажатие на кнопку "Зарегистрироваться"
    public void regButtonClick(){
        driver.findElement(regButton).click();
    }

    //Нажатие на кнопку "Войти"
    public void loginPageLinkClick(){
        driver.findElement(loginPageLink).click();
    }

    //Получение текста предупреждения о некорректном пароле
    public String stopPassText() {
        return driver.findElement(stopMaskPassText).getText();
    }
}
