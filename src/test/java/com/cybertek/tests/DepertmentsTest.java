package com.cybertek.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DepertmentsTest {

    /*
        1.open browser
        2.go to https://amazon.com
        3.verify that default dropdown option is all
        4.verify that all options are sorted alphabetically
        5.Click on the menu icon on the left
        6.click on Full Store directory
     */
    WebDriver driver;
    Select allDepartments;

    @BeforeClass
    public void setUpMethod(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://amazon.com");
    }

    @Test (priority=0)
    public void test1(){
        //finding an element with a select tag
        WebElement selectElement=driver.findElement(By.id("searchDropdownBox"));
        //create a select class object to select option on a dropdown menu
        //whenever we need to select an element from a dropdown menu we need a select element
        allDepartments =new Select(selectElement);
        //get the current selected option
        String selectedOption= allDepartments.getFirstSelectedOption().getText();
        //Verify that dropdown option is All
        //TODO skipping because failing
        Assert.assertTrue(selectedOption.contains("all"));

    }

    @Test(priority=1)
    public void sortAlphabetical(){
//        for(WebElement option: allDepartments.getOptions() ){
//            System.out.println(option.getText());
//        }
        //using the compare to method, we will compare each element in the list to next one
        for (int i=0; i<allDepartments.getOptions().size()-1; i++){
            String current =allDepartments.getOptions().get(i).getText();
            String next= allDepartments.getOptions().get(i+1).getText();

            System.out.println("comparing: "+ current + " with " + next );

            Assert.assertTrue(current.compareTo(next) <= 0);
        }



    }
    @Test
    public void mainDepartmentsTest() throws InterruptedException {
//        5.Click on the menu icon on the left


        driver.findElement(By.cssSelector("i.hm-icon.nav-sprite")).click();

        // click on Full Store directory
        // waiting because it is taking time for element to load and be clickable
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href='/gp/site-directory?ref_=nav_em_T1_0_2_2_33__fullstore']")).click();

        // capture all of the main department names in the page.

        List<WebElement> mainDepts = driver.findElements(By.cssSelector("h2.fsdDeptTitle"));

        for (WebElement option :
                mainDepts) {
            System.out.println(option.getText());
        }

    }
}