package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EtsyExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://etsy.com");

        WebElement input=driver.findElement(By.id("search-query"));
        input.sendKeys("decals");

        WebElement  submit=((ChromeDriver) driver).findElementByXPath( "//button[@value='Search']");
        submit.click();
                //driver.findElement(By.className("btn btn-primary"));//selenium will not work with space

    }
}
