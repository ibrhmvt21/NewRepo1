package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSAlert {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // driver.get("https://the-internet.herokuapp.com/windows");



    }

    @AfterMethod

    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void oopsTest(){
        driver.get("https://sweetalert.js.org/");
        // triger the pop up
        driver.findElement(By.xpath("(//button[@class='preview'])[1]")).click();


        //switch to Alert
        Alert alert = driver.switchTo().alert();// we need this line to control the alert popup (JSpopup)
        alert.accept();// clicking OK on a pop up

    }

    @Test
    public void dismiss(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();// you can only  have this line when you have an alert on page if there
        // is no alert then you get NoAlertException error
        alert.dismiss();// clicking cancel on a pop up



    }

    @Test
    public void alertText(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();// you can only  have this line when you have an alert on page if there
        // is no alert then you get NoAlertException error
        alert.sendKeys("Hello Ibrahim");// typing on the alert
        alert.accept();

    }
}
