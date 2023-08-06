import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;


public class ConstructorTest extends Data {
    @Test
    @DisplayName("Проверка смены категори на соусы")
    @Description("Проверяем наличие на странице класса выбраной категории")
    public void changeCategorySauceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.sauceClick();
        WebElement actual = driver.findElement(mainPage.activeSauce);
        assertTrue(actual.isDisplayed());
    }

    @Test
    @DisplayName("Проверка смены категории на булки")
    @Description("Проверяем наличие на странице класса выбраной категории")
    public void changeCategoryBulkiTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.nachinkaClick();
        mainPage.bulkiClick();
        WebElement actual = driver.findElement(mainPage.activeBulki);
        assertTrue(actual.isDisplayed());
    }

    @Test
    @DisplayName("Проверка смены категори на начинку")
    @Description("Проверяем наличие на странице класса выбраной категории")
    public void changeCategoryNachinkiTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.nachinkaClick();
        WebElement actual = driver.findElement(mainPage.activeNachinka);
        assertTrue(actual.isDisplayed());
    }
}
