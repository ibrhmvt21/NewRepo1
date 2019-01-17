package com.cybertek.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cybertek.utilities.TestBase;

public class DoubleClickTest extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
        driver.switchTo().frame("iframeResult");// we are switching to iframe first

        Actions actions = new Actions(driver);// constructor is required for initializion so driver is passed it requires a
        //driver

        WebElement text =driver.findElement(By.id("demo"));

        // Double click on element
        // we need to add perform at the end of any action otherwise it will not perform the action
        actions.doubleClick(text).perform();

        Assert.assertTrue(text.getAttribute("style").contains("red"));


    }

}
