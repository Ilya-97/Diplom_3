package UserData;

import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
public class RestUser {
    private static final String USER_PATH = "api/auth/register";
    private static final String LOGIN_PATH = "api/auth/login";
    private static final String DELETE_PATH = "api/auth/user";
    private static final String PATCH_PATH = "api/auth/user";

    public ValidatableResponse create(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(USER_PATH)
                .then();
    }

    public ValidatableResponse login (ExistentUser existentUser) {
        return given()
                .header("Content-type", "application/json")
                .body(existentUser)
                .when()
                .post(LOGIN_PATH)
                .then();
    }

    public ValidatableResponse delete (String accessToken, ExistentUser existentUser) {
        return given()
                .header("authorization", accessToken)
                .body(existentUser)
                .when()
                .post(DELETE_PATH)
                .then();
    }

    public ValidatableResponse alteration (String accessToken, ExistentUser existentUser) {
        return given()
                .header("authorization", accessToken)
                .body(existentUser)
                .when()
                .post(PATCH_PATH)
                .then();
    }
}
