package org.manoj.tests;

import org.manoj.Utils.TestUtils;
import org.manoj.pages.RedBusHomePage;
import org.manoj.pages.SearchResultPage;
import org.testng.annotations.Test;

public class RedBusCheckBookingTest extends BaseTest{

    public final String redBusURL = "https://www.redbus.in/";
    private RedBusHomePage homePage;
    private SearchResultPage resultPage;
    public static String from = "Bangalore";
    public static String to = "Chennai";


    @Test
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

    @Test
    public void selectBus() {
        resultPage = new SearchResultPage(driver);
        TestUtils.sleep(2000);
        resultPage.selectBus(2);
        TestUtils.sleep(5000);
    }
}
