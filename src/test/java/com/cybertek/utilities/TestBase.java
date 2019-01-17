package com.cybertek.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {//so you can not create an object of this class mainly based on our preference of how to structure
    protected SoftAssert softAssert;
    protected WebDriver driver;//our code
    protected Actions actions;


    @BeforeMethod
    public void setUpMethod() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        actions = new Actions(driver);
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDownMethod() {
        Driver.closeDriver();
        softAssert.assertAll();
    }
}
