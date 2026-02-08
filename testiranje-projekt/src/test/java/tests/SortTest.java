package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest extends BaseTest {

    @Test
    void testSortByPriceLowToHigh() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.sortByPriceLowToHigh();

        List<Double> actualPrices = inventoryPage.getItemPrices();

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        Assertions.assertEquals(expectedPrices, actualPrices);
    }
}
