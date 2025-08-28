package org.manoj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RedBusHomePage extends BasePage{


    @FindBy(xpath = "//div[text()='From']")
    private WebElement from;

    @FindBy(xpath = "//input[@id='srcDest']")
    private WebElement fromInput;

    @FindBy(xpath = "//div[@role='heading'][text()='Bangalore']")
    private WebElement fromDropdown;

    @FindBy(xpath = "//div[text()='To']")
    private WebElement to;

    @FindBy(xpath = "//div[contains(@class,'dateInputWrapper')]")
    private WebElement datePicker;

    @FindBy(xpath = "//button[contains(@class,'searchButton')]")
    private WebElement searchButton;


    public RedBusHomePage(WebDriver driver) {
        super(driver);
    }

    private void selectValueFromDropdown(String value){
        WebElement valueSelector = driver.findElement(By.xpath(String.format("//div[@role='heading'][text()='%s']", value)));
        valueSelector.click();
    }
    private void selectDateValue(int offsetFromToday){
        WebElement valueSelector = driver.findElement(By.xpath(String.format("(//div[@data-datetype='AVAILABLE'])[%d]", offsetFromToday)));
        valueSelector.click();
    }

    public void setFrom(String fromLocation) {
        wait.until(ExpectedConditions.visibilityOf(from));
        from.click();
        wait.until(ExpectedConditions.visibilityOf(fromInput));
        fromInput.sendKeys(fromLocation);
        selectValueFromDropdown(fromLocation);
    }

    public void setTo(String toLocation) {
        // To is clicked by default, explicit click is not possible
        wait.until(ExpectedConditions.visibilityOf(fromInput));
        fromInput.sendKeys(toLocation);
        selectValueFromDropdown(toLocation);
    }

    public void selectDate(int offsetFromToday) {
        datePicker.click();
        selectDateValue(offsetFromToday);
    }

    public void clickSearch() {
        searchButton.click();
    }
}
