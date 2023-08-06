import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка "Личный кабинет"
    public By profileButton = By.xpath("//a[@href = '/account']");
    //Кнопка "Войти в аккаунт"
    private By loginButton = By.xpath("//button[text() = 'Войти в аккаунт']");
    //Кнопка "Оформить заказ"
    private By orderCreateButton = By.xpath("//button[text() = 'Оформить заказ']");
    //Заголовок "Соберите бургер"
    private By burgerMadeTitle = By.xpath("//h1[text() ='Соберите бургер']");


    //Вкладка "Булки"
    private By bulkiPosition = By.xpath("//span[text() ='Булки']");
    //Активная вкладка "Булки"
    By activeBulki = By.xpath("//section[@class ='BurgerIngredients_ingredients__1N8v2']/div/div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() ='Булки']");
    //Вкладка "Соусы"
    private By saucePosition = By.xpath("//span[text() ='Соусы']");
    //Активная вкладка "Соусы"
    By activeSauce = By.xpath("//section[@class ='BurgerIngredients_ingredients__1N8v2']/div/div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() ='Соусы']");
    //Вкладка "Начинки"
    private By nachinka = By.xpath("//span[text() ='Начинки']");
    //Активная вкладка "Начинки"
    By activeNachinka = By.xpath("//section[@class ='BurgerIngredients_ingredients__1N8v2']/div/div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text() ='Начинки']");


    //Нажатие на вкладку "Булки"
    public void bulkiClick() {
        driver.findElement(bulkiPosition).click();
    }

    //Нажатие на вкладку "Соусы"
    public void sauceClick() {
        driver.findElement(saucePosition).click();
    }

    public String getOrderCreateButtonAfterLogin() {
        return driver.findElement(orderCreateButton).getText();
    }

    //Нажатие на вкладку "Начинки"
    public void nachinkaClick() {
        driver.findElement(nachinka).click();
    }


    //Нажатие на кнопку "Личный кабинет"
    public void profileButtonClick() {
        driver.findElement(profileButton).click();
    }

    //Нажатие на кнопку аторизоваться
    public void loginButtonClick() {
        driver.findElement(loginButton).click();
    }

    //Получение текста заголовка "Соберите бургер"
    public String burgerMailTitle() {
        return driver.findElement(burgerMadeTitle).getText();
    }
}
