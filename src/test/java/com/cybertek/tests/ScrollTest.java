package com.cybertek.tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import com.cybertek.utilities.TestBase;

public class ScrollTest extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.youtube.com");

        actions.sendKeys(Keys.PAGE_DOWN);

        actions.sendKeys(Keys.PAGE_DOWN);

        actions.sendKeys(Keys.PAGE_DOWN);

    }

}