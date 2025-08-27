package org.manoj.tests;

import org.manoj.Utils.TestUtils;
import org.manoj.pages.RedBusHomePage;
import org.testng.annotations.Test;

public class RedBusCheckBookingTest extends BaseTest{

    public final String redBusURL = "https://www.redbus.in/";
    private RedBusHomePage homePage;
    public static String from = "Bangalore";


    @Test
    public void navigateToRedBus() {
        driver.get(redBusURL);
        homePage = new RedBusHomePage(driver);
        TestUtils.sleep(2000);
        System.out.println(driver.getTitle());
        homePage.setFrom(from);
        TestUtils.sleep(5000);
    }


}
