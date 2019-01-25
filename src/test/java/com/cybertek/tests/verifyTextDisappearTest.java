package com.cybertek.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cybertek.utilities.TestBase;

public class verifyTextDisappearTest extends TestBase {

    @Test
    public void verify1() {
        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");
        WebElement text = driver.findElement(By.id("myDIV"));
        System.out.println(text.getText());

        Assert.assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//button[@class='w3-btn w3-hover-black w3-dark-grey']"));
        button.click();

        Assert.assertFalse(text.isDisplayed());

        // OR Assert.assertTrue(!text.isDisplayed());


    }

    @Test
    public void verify2() {
        driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_remove");

        driver.switchTo().frame("iframeResult");

        WebElement text = driver.findElement(By.xpath("//body/p"));
        Assert.assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//body/button"));
        button.click();

        // Assert.assertFalse(text.isDisplayed()); will throw stale element error
        Assert.assertFalse(elementDisplayed(By.xpath("//body/p")));
    }

    /*
        takes a locator and returns if an element matching this locatpr exists
        @param by
        @return
     */
    public boolean elementDisplayed(By by) {
        // try find it
        //if cant find it return false


        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public boolean elementDisplayedS(By by){
        return driver.findElements(by).isEmpty();
    }

}
