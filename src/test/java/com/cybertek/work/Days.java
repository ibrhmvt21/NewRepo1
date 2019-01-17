package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Days {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Random rand = new Random();
        int n=rand.nextInt(5);

        switch (n){
            case 0:
                WebElement randommonday= driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-input"));
                randommonday.click();
                String text= driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-label")).getText();
                System.out.println(text);
                randommonday.click();
                break;
            case 1:
                WebElement randomtues= driver.findElement(By.id("gwt-debug-cwCheckBox-Tuesday-input"));
                randomtues.click();
                String text1= driver.findElement(By.id("gwt-debug-cwCheckBox-Tuesday-label")).getText();
                System.out.println(text1);
                randomtues.click();
                break;
            case 2:
                WebElement randomwed= driver.findElement(By.id("gwt-debug-cwCheckBox-Wednesday-input"));
                randomwed.click();
                String text2= driver.findElement(By.id("gwt-debug-cwCheckBox-Wednesday-label")).getText();
                System.out.println(text2);
                randomwed.click();
                break;
            case 3:
                WebElement randomthur= driver.findElement(By.id("gwt-debug-cwCheckBox-Thursday-input"));
                randomthur.click();
                String text3= driver.findElement(By.id("gwt-debug-cwCheckBox-Thursday-label")).getText();
                System.out.println(text3);
                randomthur.click();
                break;
            case 4:
                WebElement randomfri= driver.findElement(By.id("gwt-debug-cwCheckBox-Friday-input"));
                randomfri.click();
                String text4= driver.findElement(By.id("gwt-debug-cwCheckBox-Friday-label")).getText();
                System.out.println(text4);
                randomfri.click();
                break;

        }
        WebElement randomfri= driver.findElement(By.id("gwt-debug-cwCheckBox-Friday-input"));
        //Friday selected un-selected-----1
        randomfri.click();
        randomfri.click();
        //Friday selected un-selected-----2
        randomfri.click();
        randomfri.click();
        //Friday selected un-selected-----3
        randomfri.click();
        randomfri.click();




    }
}
