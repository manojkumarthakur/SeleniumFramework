package org.manoj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasePage{

    private void selectBusFromList(int busCount) {
        WebElement element = driver.findElement(By.xpath(String.format("//ul[contains(@class,'srpList')]/li[%d]", busCount)));
        element.click();
    }
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void selectBus(int busCount) {
        selectBusFromList(busCount);
    }
}
