package com.cybertek.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cybertek.utilities.TestBase;

public class EtsywithSoftAssert extends TestBase {

    @Test
    public void test(){

        driver.get("https://www.etsy.com");
        driver.findElement(By.id("search-query")).sendKeys("gift"+ Keys.ENTER);
        softAssert.assertTrue(driver.getTitle().contains("gift"));

        Assert.assertTrue(driver.getTitle().contains("AAA"));

    }



}
