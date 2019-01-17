package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
verify monday is not selected
select monday
verify monday is selected
uncheck monday
 */
public class Checkboxes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement monday=driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-input"));




        if (!(monday.isSelected())){
            monday.click();
        }

        if (monday.isSelected()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //=======================================================

        /*
        go to same website
        click on monday only if it is not clicked

         */

    }
}
