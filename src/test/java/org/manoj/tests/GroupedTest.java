package org.manoj.tests;
import org.testng.annotations.Test;

public class GroupedTest {

    @Test(groups = {"sanity"})
    public void testMethodOne() {
        System.out.println("This is a sanity test");
    }

    @Test(groups = {"regression"})
    public void testMethodTwo() {
        System.out.println("This is a regression test");
    }

    @Test(groups = {"sanity", "regression"})
    public void testMethodThree() {
        System.out.println("This is both a sanity and regression test");
    }
}