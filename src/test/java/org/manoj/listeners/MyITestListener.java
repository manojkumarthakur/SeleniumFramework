package org.manoj.listeners;

import org.manoj.Utils.ScreenshotsUtil;
import org.manoj.tests.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyITestListener extends BaseTest implements ITestListener {


    public void onTestStart(ITestResult result) {
        System.out.println("***** Starting test: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("***** Test executed successfully: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("***** Test execution failed: " + result.getName());
        ScreenshotsUtil ssUtil = new ScreenshotsUtil(driver);
        ssUtil.captureScreenShot(result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("***** Test execution skipped: " + result.getName());

    }
}
