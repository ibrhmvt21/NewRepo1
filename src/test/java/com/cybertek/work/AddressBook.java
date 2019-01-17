package com.cybertek.work;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AddressBook {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://a.testaddressbook.com/sign_in");

        WebElement input= driver.findElement(By.id("session_email"));
        input.sendKeys("kexesobepu@zsero.com");

        WebElement password=driver.findElement(By.id("session_password"));
        password.sendKeys("password");

        WebElement signIn=driver.findElement(By.name("commit"));
        signIn.click();

        String ExpectedUserName="kexesobepu@zsero.com";
        String ActualUserName=driver.findElement(By.className("navbar-text")).getText();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        if (ActualUserName.equals(ExpectedUserName)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected: "+ExpectedUserName);
            System.out.println("Actual: "+ ActualUserName);
        }


    }
}
