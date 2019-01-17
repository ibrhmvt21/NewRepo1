package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickOnLinks {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("https://the-internet.herokuapp.com/");

       // WebElement PassRet = ((ChromeDriver) driver).findElementByXPath("//a[@href='/download']");
       // PassRet.click();

        WebElement frame2 = ((ChromeDriver) driver).findElementByXPath("//a[@href='/frames']");
        frame2.click();

        WebElement frame = ((ChromeDriver) driver).findElementByXPath("/html/body/div/div/div/ul/li [2]/a");
        frame.click();
       //a
       //li: li is 2nd child of ul
       //ul
       //div
       //div
       //div
      //body
      //html            /html/body/div/div/div/ul/li [2]/a


        //tag[contains(@text(), 'text')]




        /*
        //Check if title contains text "download"

        String ContainsDownload=driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();

        if (ContainsDownload.toLowerCase().contains("download")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected Text: download");
            System.out.println("Actual Text: "+ ContainsDownload);
        }

        driver.navigate().back();

        WebElement UppLoad=((ChromeDriver) driver).findElementByXPath("//a[@href='/upload']");
        UppLoad.click();

        String ContainsUpload=driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();

        if (ContainsUpload.toLowerCase().contains("upload")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("Expected Text: upload");
            System.out.println("Actual Text: "+ ContainsUpload);
        }

    */
    }
}
