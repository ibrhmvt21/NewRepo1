package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchResultsVerifications {

        /*
        1.Open Amazon
        2.Enter search termSelenium cookbook
        3.Verify each result contains work Selenium
        TC 3: Search results verifications
        1.Open Amazon
        2.Enter search termSelenium cookbook
        3.Verify default Ship to option is United States
        4.Verify options contain Canada
        5.Select Canada
        6.Verify Ship to option is now Canada
         */




    WebDriver driver;
    @BeforeClass
    public void getWebsite(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://amazon.com");


    }


    //3.Verify each result contains work Selenium
    @Test
    public void SearchResult() {

        WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
        input.sendKeys("Selenium cookbook" + Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div[1]/div/ul/li[1]/div/div/div/div[2]/div[1]/div[1]/a/h2"));
        String s1= result.getText().toLowerCase();
        Assert.assertTrue(s1.contains("selenium"));
    }

    @AfterClass
    public void CloseBrowser(){
        driver.close();
    }
}