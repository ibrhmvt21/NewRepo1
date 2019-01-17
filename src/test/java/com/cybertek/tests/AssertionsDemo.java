package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsDemo {

    @Test
    public void test1() {
        String a = "B";
        String b = "B";

        Assert.assertEquals(a, b);  // asserts if both parameters are equal -- compares a to b

    }

    @Test
    public void test2(){
        String a = "A";
        String b = "A";

        Assert.assertEquals(a, b);
    }

    @Test
    public void test3(){
        String a="A";
        String b="AAA";


        Assert.assertTrue(a.contains(b),
                b +" should have contained "+ a); //if value is not true then it will stop will not run remainder of code
        System.out.println("DONE");
    }
}
