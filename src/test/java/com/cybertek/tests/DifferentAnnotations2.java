package com.cybertek.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DifferentAnnotations2 {
    @Test
    public void TestOne() {
        System.out.println("This is Test one");
    }

    @Test
    public void testTwo() {
        System.out.println("This is test two");
    }

    @AfterMethod
    public void AfterMethod(){
        System.out.println("This is after method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("This is after class");
    }





}
