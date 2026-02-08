package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import base.BaseTest;

public class InvalidLoginTest extends BaseTest {

    @Test
    void testInvalidLogin() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "wrong_password");

        String errorMessage = loginPage.getErrorMessage();

        Assertions.assertTrue(errorMessage.contains("Username and password do not match"));
    }
}
