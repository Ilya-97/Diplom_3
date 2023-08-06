package PageObjectTest;

import PageObjectModel.MainWindow;
import SettingsBrowser.Browser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;


public class ConstructorTest {

    static {
        System.setProperty("webdriver.chrome.driver", Objects.requireNonNull(Browser.getPath(System.getenv("Chrome"))));
    }

    private static final String URL = "https://stellarburgers.nomoreparties.site/";
    private WebDriver driver;

    static {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER_PATH"));
    }

    @Before
    @Description("Открывает страницу приложения")
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @After
    @Description("Закрывает браузер")
    public void teardown() {
        driver.quit();
    }
    @Test
    @DisplayName("Проверка смены категории на булки")
    @Description("Проверяем наличие на странице класса выбраной категории")
    public void changeCategoryBulkiTest() {
       MainWindow mainWindow = new MainWindow(driver);
       mainWindow.clickFillingSelect();
       mainWindow.clickBunSelect();
       Assert.assertTrue(mainWindow.bunIsDisplayed());
    }

    @Test
    @DisplayName("Проверка смены категори на соусы")
    @Description("Проверяем наличие на странице класса выбраной категории")
    public void changeCategorySauceTest() {
        MainWindow mainWindow = new MainWindow(driver);
        mainWindow.clickSauceSelect();
        Assert.assertTrue(mainWindow.sauceIsDisplayed());
    }


    @Test
    @DisplayName("Проверка смены категори на начинку")
    @Description("Проверяем наличие на странице класса выбраной категории")
    public void changeCategoryNachinkiTest() {
        MainWindow mainWindow = new MainWindow(driver);
        mainWindow.clickFillingSelect();
        Assert.assertTrue(mainWindow.fillingIsDisplayed());
    }
}
