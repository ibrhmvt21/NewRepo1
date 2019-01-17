package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {

    @Test
    public void test1(){
        System.out.println("Starting");

        Assert.assertTrue(false);// it did not execute the whole test
        //in testNG/Junit, in any test, if assertion fails the rest of the test will be skipped

        System.out.println("done"); // done will not display
    }

    @Test
    public void test2(){
        SoftAssert softAssert=new SoftAssert();// it will do soft Assertion meaning even if assert fails it will keep
        //going

        System.out.println("starting");

        softAssert.assertTrue(false);// you can do multiple assertion

        softAssert.assertEquals("google","etsy");

        System.out.println("done");// we will still have done displayed

        softAssert.assertAll(); // will go back and report the failing ones

    }

    @Test
    public void test3(){
        SoftAssert softAssert = new SoftAssert() ;
        System.out.println("starting");

        softAssert.assertTrue(false);

        Assert.assertTrue(false);

        System.out.println("done");


        softAssert.assertAll();// usually used on AfterMethod class to make sure it runs every time
    }
}
