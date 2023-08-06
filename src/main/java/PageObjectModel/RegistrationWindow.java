package PageObjectModel;

import PageObjectModel.ParentObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegistrationWindow extends ParentObject {

    WebDriver driver;

    private static final By NAME = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][1]/div/div[@class='input pr-6 pl-6 input_type_text input_size_default']/input[@class='text input__textfield text_type_main-default']");
    private static final By NAME_ACTIVE = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][1]/div/div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']");
    private static final By EMAIL = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][2]/div/div[@class='input pr-6 pl-6 input_type_text input_size_default']/input[@class='text input__textfield text_type_main-default']");
    private static final By EMAIL_ACTIVE = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][2]/div/div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']\"");
    private static final By PASSWORD = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][3]/div/div[@class='input pr-6 pl-6 input_type_password input_size_default']/input[@class='text input__textfield text_type_main-default']");
    private static final By PASSWORD_ACTIVE = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][3]/div/div[@class='input pr-6 pl-6 input_type_text input_size_default input_status_active']/input[@class='text input__textfield text_type_main-default']");
    private static final By REGISTRATION_BUTTON = By.xpath(".//form[@class='Auth_form__3qKeq mb-20']/button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    private static final By INCORRECT_PASSWORD = By.xpath(".//fieldset[@class='Auth_fieldset__1QzWN mb-6'][3]/div[@class='input__container']/p[@class='input__error text_type_main-default']");
    private static final By AUTHORIZATION_BUTTON = By.xpath(".//div/div/p[@class='undefined text text_type_main-default text_color_inactive mb-4']/a[@class='Auth_link__1fOlj']");

    public RegistrationWindow(WebDriver driver){
        this.driver = driver;
    }

    public void nameFieldInput(){
        driver.findElement(NAME).click();
        driver.findElement(NAME_ACTIVE).sendKeys("ТЕСТ ТЕСТ"); //Заполнить параметризованным значением
    }

    public void emailFieldInput(String email){
        driver.findElement(EMAIL).click();
        driver.findElement(EMAIL_ACTIVE).sendKeys(email); //Заполнить параметризованным значением
    }

    public void passwordFieldInput(String password){
        driver.findElement(PASSWORD).click();
        driver.findElement(PASSWORD_ACTIVE).sendKeys(password); //Заполнить параметризованным значением
    }
    public void passwordFieldInputIncorrect(){
        driver.findElement(PASSWORD).click();
        driver.findElement(PASSWORD_ACTIVE).sendKeys("1234"); //Заполнить параметризованным значением
    }

    public void authorizationButtonClick(){
        driver.findElement(AUTHORIZATION_BUTTON).click();
    }

    public void checkIncorrectPassword(){
         checkElementIsEnabled(INCORRECT_PASSWORD);
    }

    public void registrationButtonClick(){
        driver.findElement(REGISTRATION_BUTTON).click();
    }
}

