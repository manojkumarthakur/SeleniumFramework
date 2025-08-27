package org.manoj.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUiUtils {
    private WebDriver driver;
    public TestUiUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void setValue(WebElement element, String value){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].setAttribute('value', '" + value +"')", element);
    }
}
