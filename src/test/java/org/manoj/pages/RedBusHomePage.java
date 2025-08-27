package org.manoj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RedBusHomePage extends BasePage{

    public RedBusHomePage(WebDriver driver) {
        super(driver);
    }

    private WebElement from = driver.findElement(By.xpath("//div[text()='From']"));
    private WebElement fromInput = driver.findElement(By.xpath("(//div[contains(@class,'srcDest')])[2]"));
    private WebElement to = driver.findElement(By.xpath("//div[text()='From']"));

    public void setFrom(String fromLocation) {
        wait.until(ExpectedConditions.visibilityOf(from));
        from.click();
//        fromInput.sendKeys(fromLocation);
        testUiUtils.setValue(fromInput, fromLocation);
        //div[@role='heading'][text()='Bangalore']

    }

}
