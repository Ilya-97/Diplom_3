package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RecoveryPasswordWindow {

    private WebDriver driver;
    private static final By ENTRANCE_BUTTON = By.xpath(".//div/p[@class='undefined text text_type_main-default text_color_inactive mb-4']/a[@class='Auth_link__1fOlj']");

    public RecoveryPasswordWindow(WebDriver driver){
        this.driver = driver;
    }
    public void entranceButtonClick(){
        driver.findElement(ENTRANCE_BUTTON).click();
    }
}
