package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesTest {
    @Test
    public void login(){
        System.out.println("login");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "login") //method name
    public void zbuySth(){
        System.out.println("Buy buy buy");
    }

    @Test(priority = 2)
    public void homePage(){
        System.out.println("home page");
    }

}