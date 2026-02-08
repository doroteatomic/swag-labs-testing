package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");

    public void addBackpackToCart() {
        driver.findElement(addBackpackButton).click();
    }

    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void clickCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}
