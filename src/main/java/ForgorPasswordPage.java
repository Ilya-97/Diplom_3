import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgorPasswordPage {
    public WebDriver driver;

    public ForgorPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    //Кнопка "Войти"
    private By loginLink = By.xpath("//a[@href = '/login']");

    //Нажатие на кнопку "Войти"
    public void loginLinkClick(){
        driver.findElement(loginLink).click();
    }
}
