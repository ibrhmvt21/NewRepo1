package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Sports {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //verify that Football is selected by default and all others are not selected.

        WebElement football= driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input"));

        if (!(football.isSelected())){
            football.click();
        }
        // select another sport
        WebElement baseball= driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Baseball-input"));
        WebElement basketball= driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Basketball-input"));
        WebElement hockey= driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Hockey-input"));
        WebElement soccer= driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Soccer-input"));
        WebElement waterpolo= driver.findElement(By.id("gwt-debug-cwRadioButton-sport-WaterPolo-input"));
        //select baseball
        if (!(baseball.isSelected())){
            baseball.click();
        }


    }

}
