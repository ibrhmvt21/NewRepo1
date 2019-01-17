package com.cybertek.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cybertek.utilities.TestBase;

/*
go to https://the-internet.herokuapp.com/upload
upload file
click upload
verify text uploaded
 */
public class FileUploadTest extends TestBase {

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys("/Users/barankar/Downloads/test.txt"); //instead of clicking on upload button we will send the
        //file path with SendKeys, located element has to be an input element when inspected
        driver.findElement(By.id("file-submit")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());
    }
}
