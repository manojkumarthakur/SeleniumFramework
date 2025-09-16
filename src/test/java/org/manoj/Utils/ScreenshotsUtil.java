package org.manoj.Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotsUtil {
    WebDriver driver;

    public ScreenshotsUtil(WebDriver driver){
        this.driver = driver;
    }

    public void captureScreenShot (String methodName){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

        String ssName = methodName + formatter.format(now);

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String screenshotsAbsFilePath = System.getProperty("user.dir") + "/src/screenshots/"+ ssName+ ".png";
        File destination = new File(screenshotsAbsFilePath);
        try {
            FileHandler.copy(source, destination); // Or FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
