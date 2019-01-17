package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties;

    static {
        //this is the path to the location of the file
        String path = "configuration.properties";

        //fileinputstrem method throws an excception that's why we need it in try-catch block
        try {
            // java can not read files directly, it needs to inputStream to read the file
            //inputstream takes the location of the file as a constructor
            FileInputStream fileInputStream = new FileInputStream(path);

            //Properties class is used the read specifically Properties  files, files with key value pairs
            properties = new Properties();

            //file contents are loaded to properties form the inputstream
            properties.load(fileInputStream);

            //all inputstream must be closed
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String property){

        return properties.getProperty(property);

    }
}
