package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HTMLPopup {
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
    public void doNotDestroyTheWorldTest(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//span[.='Destroy the World']")).click();
        //locate an element in pop up win and click
        driver.findElement(By.xpath("//span[.='No']")).click();
    }

    @Test
    public void ooppsTest(){
        driver.get("https://sweetalert.js.org/");
        // triger the pop up
        driver.findElement(By.xpath("(//button[@class='preview'])[2]")).click();
        // close the pop up
        driver.findElement(By.xpath("//button[.='OK']")).click();


    }

}
