package UserData;

import org.apache.commons.lang3.RandomStringUtils;
public class RandomCreateUser {
    public static User createRandom(){
        String name = RandomStringUtils.randomAlphabetic(8);
        String email = RandomStringUtils.randomAlphabetic(8) + "@gmail.com";
        String password = RandomStringUtils.randomAlphabetic(8);
        return new User(name, email, password);
    }
}


