package base;

import com.aventstack.extentreports.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ReportManager;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent = ReportManager.getInstance();
    protected ExtentTest test;

    @BeforeEach
    void setup(TestInfo testInfo) {

        driver = DriverFactory.createDriver("Brave");
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        test = extent.createTest(testInfo.getDisplayName());
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    static void flushReport() {
        extent.flush();
    }
}
