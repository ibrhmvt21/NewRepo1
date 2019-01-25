package com.cybertek.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.cybertek.utilities.TestBase;

public class DragAndDrop extends TestBase {

    @Test
    public void test(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("droptarget"));
        //variables need to be passed in correct order, first one is source second one is taget
        actions.dragAndDrop(source,target).perform();

        //write the steps for doing the drag and drop operation
        //without using the dragAnddrop() method


    }

    @Test
    public void test2(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
        // when we use multiple actions we need to add build() before we perform()
        actions.clickAndHold(source).moveToElement(target).release().build().perform();

    }
}