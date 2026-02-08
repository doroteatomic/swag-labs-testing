package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutTest extends BaseTest {

    @Test
    void testCheckoutFlow() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);
        products.addBackpackToCart();
        products.clickCart();

        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillCheckoutInfo("John", "Doe", "12345");
        checkout.finishCheckout();

        Assertions.assertEquals("Thank you for your order!", checkout.getCompleteMessage());
    }
}

