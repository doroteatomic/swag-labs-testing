package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;
import base.BaseTest;

public class RemoveFromCartTest extends BaseTest {

    @Test
    void testRemoveFromCart() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.addFirstItemToCart();
        inventoryPage.removeFirstItemFromCart();

        Assertions.assertEquals("0", inventoryPage.getCartBadgeCount());
    }
}
