package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage {

    private WebDriver driver;

    private By sortDropdown = By.className("product_sort_container");
    private By itemPrices = By.className("inventory_item_price");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortByPriceLowToHigh() {
        WebElement dropdown = driver.findElement(sortDropdown);
        dropdown.sendKeys("Price (low to high)");
    }

    public List<Double> getItemPrices() {
        List<WebElement> prices = driver.findElements(itemPrices);

        return prices.stream()
                .map(e -> e.getText().replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
