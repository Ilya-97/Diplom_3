import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Профиль"
    By profileLink = By.xpath("//a[@href = '/account/profile']");
    //Логотип
    private By logo = By.className("AppHeader_header__logo__2D0X2");
    //Кнопка "Выход"
    private By logoutLink = By.xpath("//button[text() = 'Выход']");
    //Кнопка "Конструктор"
    private By constructorLink = By.xpath("//p[text() = 'Конструктор']");

    //Нажатие на логотип
    public void logoClick() {
        driver.findElement(logo).click();
    }

    //Нажатие на кнопку "Выход"
    public void logoutLinkClick() {
        driver.findElement(logoutLink).click();
    }

    //Нажатие на кнопку "Конструктор"
    public void constructorClick() {
        driver.findElement(constructorLink).click();
    }

    //Проверка наличия кнопки "Профиль"
    public String getTextLink() {
        return driver.findElement(profileLink).getText();
    }
}
