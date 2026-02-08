package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By completeMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCheckoutInfo(String first, String last, String postal) {
        driver.findElement(firstNameInput).sendKeys(first);
        driver.findElement(lastNameInput).sendKeys(last);
        driver.findElement(postalCodeInput).sendKeys(postal);
        driver.findElement(continueButton).click();
    }

    public void finishCheckout() {
        driver.findElement(finishButton).click();
    }

    public String getCompleteMessage() {
        return driver.findElement(completeMessage).getText();
    }
}
