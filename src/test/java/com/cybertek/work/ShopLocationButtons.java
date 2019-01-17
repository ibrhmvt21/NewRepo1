package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ShopLocationButtons {
    public static void main(String[] args) {
        /*
        1.OpenEtsy
        2.Enter searchanyterm
        3.Verify Shop location: Anywhere is checked
        4.Verify Shop location: United States is not checked
        5.Click on Shop location: United States
        6.Verify Shop location: Anywhere is not checked
        7.Verify Shop location: United States is  checked
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //1. Open Etsy

        driver.get("https://www.etsy.com/");

        //2. Enter searchanyterm

        WebElement input = driver.findElement(By.id("search-query"));
        input.sendKeys("boxes" + Keys.ENTER);



       // 3.Verify Shop location: Anywhere is checked


        WebElement anywhere= driver.findElement(By.xpath("//form[@id='search-filter-reset-form']/div[7]/fieldset/div/div/div[1]/label[1]/a"));
        System.out.println(anywhere.isSelected());
        //System.out.println(anywhere.getAttribute("checked"));// if result is true means button is checked
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //4.Verify Shop location: United States is not checked

        WebElement unitedStates= driver.findElement(By.xpath("//input[@aria-label='United States']"));
        System.out.println(unitedStates.isSelected());//

        //5.Click on Shop location: United States

        WebElement chooseUS= driver.findElement(By.xpath("//form[@id='search-filter-reset-form']/div[7]/fieldset/div/div/div[1]/label[2]/a"));
        //"https://www.etsy.com/search?q=boxes&order=most_relevant&view_type=gallery&explicit=1&locationQuery=6252001"
        //chooseUS.click();
        //h3[contains(text(), 'Fra')]
        //button[contains(@id, 'j_idt')]
       // WebElement chooseUS= driver.findElement(By.xpath("//a[contains(href(), 'https://www.etsy.com/search?']"));
        chooseUS.click();

        //6.Verify Shop location: Anywhere is not checked
       // System.out.println(anywhere.isSelected());

        WebElement anywhere2= driver.findElement(By.xpath("//form[@id='search-filter-reset-form']/div[7]/fieldset/div/div/div[1]/label[1]/a"));
        System.out.println(anywhere2.isSelected());

    }
}
