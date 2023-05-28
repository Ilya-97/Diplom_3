import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;


public class ConstructorTest extends Data {
    @Test
    @DisplayName("Проверка смены категори на соусы")
    @Description("Проверяем наличие на странице класса выбраной категории")
    public void changeCategorySauceTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.sauceClick();
        WebElement actual = driver.findElement(mainPage.activeSauce);
        Assert.assertEquals(true, actual.isDisplayed());
    }

    @Test
    @DisplayName("Проверка смены категори на булки")
    @Description("Проверяем наличие на странице класса выбраной категории")
    public void changeCategoryBulkiTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.nachinkaClick();
        mainPage.bulkiClick();
        WebElement actual = driver.findElement(mainPage.activeBulki);
        Assert.assertEquals(true, actual.isDisplayed());
    }

    @Test
    @DisplayName("Проверка смены категори на начинку")
    @Description("Проверяем наличие на странице класса выбраной категории")
    public void changeCategoryNachinkiTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.nachinkaClick();
        WebElement actual = driver.findElement(mainPage.activeNachinka);
        Assert.assertEquals(true, actual.isDisplayed());
    }
}
