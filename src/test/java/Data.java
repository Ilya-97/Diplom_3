import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;


import java.time.Duration;

public class Data {
    public WebDriver driver;


    //Данные для готового пользователя
    public String emailExist = "test_test@gmail.com";
    public String passExist = "Qwer1234";


    @Before
    public void StartUp() {
        //Драйвер для браузера
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href ='/account']")));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
