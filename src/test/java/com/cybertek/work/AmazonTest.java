package com.cybertek.work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonTest {
    public static void main(String[] args) {
        /*
        1.open browser
        2.go to https://amazon.com
        3.verify that default dropdown option is all
        4.verify that all options are sorted alphabetically
        5.Click on the menu icon on the left
        6.click on Full Store directory
         */


        //1. Open Browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2. go to https://amazon.com
        driver.get("http:amazon.com");
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //3. Verify the All departments is selected by default

        String expectedText="All Departments";
        WebElement selected=driver.findElement(By.id("searchDropdownBox"));
        String selectedText=selected.findElements(By.xpath("//option[@selected='selected']")).get(0).getText();

       if (expectedText.equals(selectedText)){
           System.out.println("PASS");
       }else{
           System.out.println("FAIL");
           System.out.println("Expected: "+expectedText);
           System.out.println("Actual: "+selectedText);
       }


       //4. verify that all options are sorted alphabetically


        //allOptions.add(driver.findElement(By.xpath("//select/[*]")));
           WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        List<WebElement> allOptions= dropdown.findElements(By.tagName("option"));
        String [] links=new String [allOptions.size()];

        for (int i=1, a=0; i<=allOptions.size()&& a<allOptions.size(); i++, a++){


        links [a]=((driver.findElement(By.xpath("//select/*["+i+"]")).getText()));

        }

        for (int i=0; i<links.length;i++){
            for (int j=0; j<links[i].length(); j++) {
                if (links[i].charAt(j) == ' ') {
                   links[i]= links[i].replace(" ", "");
                }
            }
        }



        char z=' ';
        for (int i=0; i<links.length-1; i++) {
            if((!(links[i].toLowerCase().equals("women") ||links[i].toLowerCase().equals("men")||links[i].toLowerCase().equals("girls") ||links[i].toLowerCase().equals("boys")||links[i].toLowerCase().equals("baby") )))
            {
                if (links[i].toLowerCase().charAt(0) <= links[i + 1].toLowerCase().charAt(0))
                {
                    continue;
                }
                else
                    {
                    System.out.println("Dropdown menu is not sorted");
                     z ='n';
                    break;
                    }
            }
            else
                {
                continue;
                }
        }

        if (z!='n'){
            System.out.println("Dropdown menu is sorted");
        }


        //5.Click on the menu icon on the left

        WebElement menu=driver.findElement(By.id("nav-hamburger-menu"));
        menu.click();

        //6.click on Full Store directory
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement fullStore0=driver.findElement(By.partialLinkText("Full Store"));
        fullStore0.click();






    }
}
