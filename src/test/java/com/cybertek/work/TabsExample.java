package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class TabsExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

    }

    @AfterMethod

    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }

    /*Test case:
go to http://the-internet.herokuapp.com/windows
click on click "Click here"

verify that new title is "New Window"
verify that new title is not "The Internet"

*/
    @Test
    public void changeTab() {
        System.out.println(driver.getWindowHandles().size());
        System.out.println(driver.getWindowHandle());

        driver.findElement(By.linkText("Click Here")).click();

        System.out.println(driver.getWindowHandles().size());

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("***********************");



        Assert.assertEquals(driver.getTitle(),"New Window");
        Assert.assertNotEquals(driver.getTitle(),"The Internet");
}

    /*
    go to https://www.w3schools.com/html/
    click on Try it yourself
    verify the url of the new tab contains "default"

     */

    @Test
    public void changeTab2() {
        driver.get("https://www.w3schools.com/html/");
        driver.findElement(By.linkText("Try it Yourself »")).click();

        for (String handle : driver.getWindowHandles()) {


            driver.switchTo().window(handle);// works with id
            System.out.println(driver.getTitle());
            if (driver.getTitle().equals("Tryit Editor v3.6")) {
                break;
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("default"));

        System.out.println(driver.getWindowHandles().size());
        driver.close();
        System.out.println(driver.getWindowHandles().size());
    }
}
