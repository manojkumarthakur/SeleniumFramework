package org.manoj.tests;

import org.manoj.Utils.TestUtils;
import org.manoj.pages.RedBusHomePage;
import org.manoj.pages.SearchResultPage;
import org.manoj.pages.SeatSelectionPage;
import org.testng.annotations.Test;

public class RedBusCheckBookingTest extends BaseTest{

    public final String redBusURL = "https://www.redbus.in/";
    public static String from = "Bangalore";
    public static String to = "Chennai";

    private RedBusHomePage homePage;
    private SearchResultPage resultPage;
    private SeatSelectionPage seatSelectionPage;




    @Test(priority = 0)
    public void navigateToRedBus() {
        driver.get(redBusURL);
        homePage = new RedBusHomePage(driver);
//        TestUtils.sleep(2000);
        System.out.println(driver.getTitle());
        homePage.setFrom(from);
//        TestUtils.sleep(2000);
        homePage.setTo(to);
//        TestUtils.sleep(2000);
        homePage.selectDate(1);
        homePage.clickSearch();
    }

    @Test(priority = 1)
    public void selectBus() {
        resultPage = new SearchResultPage(driver);
        TestUtils.sleep(2000);
        resultPage.selectBus(2);
        TestUtils.sleep(2000);
    }


    @Test(priority = 2)
    public void checkAvailibility() {
        seatSelectionPage = new SeatSelectionPage(driver);
        TestUtils.sleep(2000);
        System.out.println("Total available seats are: " + seatSelectionPage.availableSeatsCount());
        TestUtils.sleep(2000);
        int[] minMaxPrice = seatSelectionPage.minMaxSeatCharges();
        System.out.println("Minimum ticket price is : " + minMaxPrice[0]);
        System.out.println("Maximum ticket price is : " + minMaxPrice[1]);
    }


}
