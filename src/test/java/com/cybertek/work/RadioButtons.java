package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButtons {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //verify blue and red not checked
        WebElement blue= driver.findElement(By.id("gwt-debug-cwRadioButton-color-blue-input"));
        WebElement red= driver.findElement(By.id("gwt-debug-cwRadioButton-color-red-input"));
        //will print by default values of selection
        System.out.println("blue: "+blue.isSelected());
        System.out.println("red: "+red.isSelected());

        //check blue
        if (!(blue.isSelected())){
            blue.click();

        }
        if (blue.isSelected() && !red.isSelected()){
            System.out.println("PASS");
        }
        //verify blue checked red not checked

        //verify blue not checked and red checked
        if (!(red.isSelected())){
            red.click();
        }

        if (red.isSelected() && !blue.isSelected()){
            System.out.println("PASS");
        }
    }
}
