package org.manoj.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;

    public BaseTest() {
        this.driver = new ChromeDriver();
    }

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver!= null)
            driver.quit();
    }
}
