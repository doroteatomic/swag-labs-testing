package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        if (browser.equalsIgnoreCase("brave")) {

            System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

            return new ChromeDriver(options);
        }

        throw new RuntimeException("Unsupported browser: " + browser);
    }
}
