package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainWindow extends ParentObject{

    private WebDriver driver;

    private static final By LOGIN = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    private static final By PLACE_AN_ORDER = By.xpath(".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button[text()='Оформить заказ']");
    private static final By PROFILE_BUTTON = By.xpath(".//header[@class='AppHeader_header__X9aJA pb-4 pt-4']/nav[@class='AppHeader_header__nav__g5hnF']/a[@class='AppHeader_header__link__3D_hX']/p[@class='AppHeader_header__linkText__3q_va ml-2']");
    private static final By BUN = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect'][1]/span[@class = 'text text_type_main-default']");
    private static final By BUN_SELECT = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[1]/span");
    private static final By SAUCE = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect'][1]/span[@class = 'text text_type_main-default']");
    private static final By SAUCE_SELECT = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[2]/span");
    private static final By FILLING = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect'][2]/span[@class = 'text text_type_main-default']");
    private static final By FILLING_SELECT = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div/div[3]/span");

    public MainWindow(WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginButton(){
        driver.findElement(LOGIN).click();
    }
    public void clickProfileButton(){
        driver.findElement(PROFILE_BUTTON).click();
    }

    public void clickBunSelect(){
        driver.findElement(BUN);
    }
    public boolean bunIsDisplayed(){
        checkElementIsEnabled(BUN_SELECT);
        return driver.findElement(BUN_SELECT).isEnabled();
    }
    public void clickSauceSelect(){
        driver.findElement(SAUCE);
    }
    public boolean sauceIsDisplayed(){
        checkElementIsEnabled(SAUCE_SELECT);
        return driver.findElement(SAUCE_SELECT).isEnabled();
    }
    public void clickFillingSelect(){
        driver.findElement(FILLING);
    }
    public boolean fillingIsDisplayed(){
        checkElementIsEnabled(FILLING_SELECT);
        return driver.findElement(FILLING_SELECT).isEnabled();
    }




}
