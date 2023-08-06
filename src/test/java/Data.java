import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;


import static io.restassured.RestAssured.given;

public class Data {
    public WebDriver driver;

    //Данные для готового пользователя
    UserData newUser = new UserData(RandomStringUtils.randomAlphabetic(8) + "@mail.ru", RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(8));
    UserData loginForm = new UserData(newUser.getEmail(), newUser.getPassword());

    public Response createNewUser(UserData newUser) {
        Response response = given().header("Content-type", "application/json").and().body(newUser).post("api/auth/register");
        return response;
    }

    public Response loginRestTest(UserData loginForm) {
        Response loginResponse = given()
                .header("Content-type", "application/json")
                .body(loginForm)
                .post("/api/auth/login");
        return loginResponse;
    }

    public void deleteUser() {
        TokenData accessData = loginRestTest(loginForm).as(TokenData.class);
        given().header("authorization", accessData.getAccessToken()).and().body(newUser).delete("/api/auth/user");
    }


    @Before
    public void StartUp() {
        //Драйвер для браузера
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(mainPage.profileButton));
        createNewUser(newUser);
    }

    @After

    public void tearDown() {
        driver.quit();
        deleteUser();
    }
}
