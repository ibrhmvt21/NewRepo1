package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpilicitWait2 {


    @Test
    public void test() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/2");

        Driver.getDriver().findElement(By.tagName("button")).click();
        Thread.sleep(10000);

        WebElement text= Driver.getDriver().findElement(By.id("finish"));

        System.out.println(text.getText());

        Assert.assertTrue(text.isDisplayed());
    }
}
