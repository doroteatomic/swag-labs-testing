package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class AddToCartTest extends BaseTest {

    @Test
    void testAddBackpackToCart() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.addBackpackToCart();
        Assertions.assertEquals("1", products.getCartCount());
    }
}

