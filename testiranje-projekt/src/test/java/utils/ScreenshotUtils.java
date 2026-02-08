package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    private static final String SCREENSHOT_FOLDER = "test-output/screenshots/";

    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            Path path = Paths.get(SCREENSHOT_FOLDER);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = testName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timeStamp + ".png";

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destination = Paths.get(SCREENSHOT_FOLDER + fileName);

            Files.copy(source.toPath(), destination);
            return destination.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
