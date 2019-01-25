package com.cybertek.tests;

import com.cybertek.pages.HomePage;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.cybertek.utilities.TestBase;

public class ErrorMessageValidationTest extends TestBase {
    HomePage homePage=new HomePage();



    @Test
    public void wrongEmailTest() {
        HomePage homePage=new HomePage();
//        driver.get("http://automationpractice.com/index.php");
//        driver.findElement(By.xpath("//a[@class='login']")).click();
//        Faker fake=new Faker();
//        String email= fake.internet().emailAddress();
//        driver.findElement(By.id("email")).sendKeys(email);
//        String paswrd=fake.internet().password();
//        driver.findElement(By.id("passwd")).sendKeys(paswrd);
//        driver.findElement(By.id("SubmitLogin")).click();
//        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.get(ConfigurationReader.getProperty("url"));
        homePage.username.sendKeys("admin");
//      driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("admin");
//      above line is same as line 32
        homePage.password.sendKeys("test");
//      driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        homePage.logInButton.click();
//      driver.findElement(By.id("ctl00_MainContent_login_button")).click();
        String errMesg = "Invalid Login or Password.";
        String actualErr= homePage.errorMesg.getText();
//      String actErrMsg = driver.findElement(By.id("ctl00_MainContent_status")).getText();
        Assert.assertEquals(actualErr, errMesg);
    }

    @Test
    public void wrongPasswordTest() {
        /*
        1. go to website http://automationpractice.com/index.php
        2. try to login with wrong password
        3. verify error message Authentication failed.
         */
        HomePage homePage=new HomePage();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        homePage.username.sendKeys("Tester");
//      driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        homePage.password.sendKeys("wrong pass");
//      driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("wrong pass");
        homePage.logInButton.click();
//      driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        String errMesg = "Invalid Login or Password.";
        String actErrMsg=homePage.errorMesg.getText();
//      String actErrMsg = driver.findElement(By.id("ctl00_MainContent_status")).getText();


        Assert.assertEquals(actErrMsg, errMesg);
//      when .quit() is working can not quit and create a new one selenium still sees an object when .quit() is used
    }

    @Test
    public void blankUsername(){
        HomePage homePage=new HomePage();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        homePage.login("","");

        String expectedError = "Invalid Login or Password.";
        String actualError = homePage.errorMesg.getText();
        Assert.assertEquals(actualError, expectedError);

    }


}