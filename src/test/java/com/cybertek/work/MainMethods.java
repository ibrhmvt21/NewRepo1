package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MainMethods {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");

        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("Selenium cookbook" + Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div[1]/div/ul/li[1]/div/div/div/div[2]/div[1]/div[1]/a/h2"));
        String s1= result.getText().toLowerCase();
        System.out.println(s1.contains("selenium"));
       // Assert.assertTrue(s1.contains("selenium"));
    }
}
