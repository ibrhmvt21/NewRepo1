package com.cybertek.work;

import com.sun.corba.se.impl.ior.ByteBuffer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ZeroBank {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement input=driver.findElement(By.id("user_login"));
        input.sendKeys("username");
        WebElement password=driver.findElement(By.id("user_password"));
        password.sendKeys("password");

        WebElement SignIn=driver.findElement(By.name("submit"));
        SignIn.click();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String ActualUserName=driver.findElement(By.xpath("//*[@id='settingsBox']/ul/li[3]")).getText();

        String ExpectedUserName="username";

        if (ActualUserName.equals(ExpectedUserName)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected: "+ExpectedUserName);
            System.out.println("Actual: "+ ActualUserName);
        }

    }
}
