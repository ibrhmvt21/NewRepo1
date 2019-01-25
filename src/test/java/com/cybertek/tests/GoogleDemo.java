package com.cybertek.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cybertek.utilities.TestBase;

/*
open chrome
go to goole
search for selenium cookbook
verify title contains search term
 */
public class GoogleDemo extends TestBase {
    @Test
    public void titleTest(){
        driver.get("https://www.google.com");


        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys( "selenium cookbook"+ Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("selenium cookbook"));

    }


}