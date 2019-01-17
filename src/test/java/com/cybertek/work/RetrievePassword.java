package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RetrievePassword {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/forgot_password");

        WebElement input=driver.findElement(By.id("email"));
        input.sendKeys("some@somemail.com");

        WebElement SignIn=driver.findElement(By.id("form_submit"));
        SignIn.click();

        String ExpectedText="Your e-mail's been sent!";

        String ActualText=driver.findElement(By.id("content")).getText();

        if (ActualText.equals(ExpectedText)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected: "+ExpectedText);
            System.out.println("Actual: "+ ActualText);
        }


    }
}
