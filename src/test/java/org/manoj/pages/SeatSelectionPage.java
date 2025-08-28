package org.manoj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SeatSelectionPage extends BasePage{

    @FindBy(xpath = "//div[@data-autoid='seatContainer']//*[contains(@aria-label,'seat status available')]")
    List<WebElement> availableSeats;

    public SeatSelectionPage(WebDriver driver) {
        super(driver);
    }

    public int availableSeatsCount() {
        wait.until(ExpectedConditions.visibilityOfAllElements(availableSeats));
        return availableSeats.size();
    }

    public int[] minMaxSeatCharges() {
        int min =0;
        int max =0;
        int[] minMax = new int[2];
        int count = 0;

        for (int i=0; i<availableSeats.size(); i++) {
            WebElement element = availableSeats.get(i);
            String priceWithSymbol = element.getText();
            System.out.println(priceWithSymbol);
            String priceStr = priceWithSymbol.substring(1);
            int price = Integer.valueOf(priceStr);
            if (count == 0) {
                min = price;
                max = price;
            }
            if (price < min) {
                min = price;
            }
            if (price > max) {
                max = price;
            }
            count++;
        }

        minMax[0] = min;
        minMax[1] = max;
        return minMax;
    }
}
