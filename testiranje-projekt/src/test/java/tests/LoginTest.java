package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    void testValidLoginStandardUser() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @Test
    void testLockedOutUser() {
        LoginPage login = new LoginPage(driver);
        login.login("locked_out_user", "secret_sauce");
        Assertions.assertTrue(login.getErrorMessage().contains("locked"));
    }
}
