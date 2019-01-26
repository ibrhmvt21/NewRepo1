package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplitWaitExample {

    @Test
    public void EmplicitWaitTest() {
        //Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);--this wont help

        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");

        //click on enable
        Driver.getDriver().findElement(By.xpath("//form[@id='input-example']//button")).click();


        // this is a class used to emplicit wait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);//creating object
        //this is when wait happens
        // we are waiting for certain element this xpath is clicable
        wait.until(//waiting
                ExpectedConditions.elementToBeClickable(//to click
                        By.xpath("//input[@type='text']")));//clicking by the xpath



        //eneter text

        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("Hello World");


    }
}