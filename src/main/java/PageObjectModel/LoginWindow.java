package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginWindow extends MainData{
    WebDriver driver;

    private static final By EMAIL = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][1]/div/div[@class='input pr-6 pl-6 input_type_text input_size_default']/input[@class='text input__textfield text_type_main-default']");
    private static final By EMAIL_ACTIVE = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][1]/div/div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']");
    private static final By PASSWORD = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][2]/div/div[@class='input pr-6 pl-6 input_type_password input_size_default']/input[@class='text input__textfield text_type_main-default']");
    private static final By PASSWORD_ACTIVE = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][2]/div/div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']");
    private static final By ENTRANCE_BUTTON = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private static final By FORGOT_PASSWORD = By.xpath(".//div/p[@class='undefined text text_type_main-default text_color_inactive']/a[@class='Auth_link__1fOlj']");
    private static final By REGISTRATION_BUTTON = By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    public LoginWindow(WebDriver driver){
        super(driver);
    }

    public void nameFieldInput(){
        driver.findElement(EMAIL).click();
        driver.findElement(EMAIL_ACTIVE).sendKeys("еуые"); //прописать параметризованные значения
    }

    public void passwordFieldInput(){
        driver.findElement(PASSWORD).click();
        driver.findElement(PASSWORD_ACTIVE).sendKeys(""); //прописать параметризованные значения
    }

    public void entranceClickButton(){
        driver.findElement(ENTRANCE_BUTTON).click();
    }

    public void registrationClick(){
        driver.findElement(REGISTRATION_BUTTON).click();
    }

    public void forgotPasswordButtonClick(){
        driver.findElement(FORGOT_PASSWORD).click();
    }

    public boolean isEntranceButtonDisplayed() {
        checkThatElementIsEnabled(ENTRANCE_BUTTON);
        return driver.findElement(ENTRANCE_BUTTON).isDisplayed();
    }








}
