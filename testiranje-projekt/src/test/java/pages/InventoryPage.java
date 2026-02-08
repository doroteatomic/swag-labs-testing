package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
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

    public void logout() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link"))).click();
    }

    public void addFirstItemToCart() {
        WebElement firstButton = driver.findElement(By.cssSelector(".inventory_item button"));
        if (firstButton.getText().equalsIgnoreCase("Add to cart")) {
            firstButton.click();
        }
    }


    public void removeFirstItemFromCart() {
        driver.findElement(By.cssSelector(".inventory_item button")).click();
    }

    public String getCartBadgeCount() {
        try {
            return driver.findElement(By.className("shopping_cart_badge")).getText();
        } catch (Exception e) {
            return "0";
        }
    }

}
