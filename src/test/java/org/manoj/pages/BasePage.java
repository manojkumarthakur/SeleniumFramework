package org.manoj.pages;

import org.manoj.Utils.TestUiUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected  WebDriver driver;
    protected WebDriverWait wait;
    protected Duration smallWait =  Duration.ofSeconds(30);
    protected Duration longWait =  Duration.ofSeconds(60);
    protected TestUiUtils testUiUtils;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        testUiUtils = new TestUiUtils(driver);
    }
}
