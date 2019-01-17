package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


public class FileExistsTest {

    @Test
    public void test(){
        //get the current folder
        String currentFolder = System.getProperty("user.dir");

        System.out.println(currentFolder);

        String userFolder = System.getProperty("user.home");
        System.out.println(userFolder);

        String path = userFolder+"/Downloads/a.xlsx";

        System.out.println(path);

        Assert.assertTrue(Files.exists(Paths.get(path)));
        // this whole steps are used to verify that the downloaded file exists inside computer

    }
}
