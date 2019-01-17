package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AmazonHelp {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        JavascriptExecutor executor = (JavascriptExecutor)driver;
       executor.executeScript("document.body.style.zoom = '0.7'");
/*
WebElement element = driver.findElement(By.id(id_name));
(JavascriptExecutor)driver.executeScript("arguments[0].click();", element);
 */

       // WebElement html = driver.findElement(By.tagName("html"));
        //html.sendKeys(Keys.chord(Keys.COMMAND, Keys.SUBTRACT));
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.navigate().refresh();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement help= driver.findElement(By.xpath("//a[@tabindex='53']"));

       ((ChromeDriver) driver).executeScript("arguments[0].click();",help);

       // help.click();


        ///a[@href='/gp/help/customer/display.html?nodeId=508510&ref=nav_cs_help']
    }
}
