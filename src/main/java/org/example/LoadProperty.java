package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperty {
    static Properties prop = new Properties();
    static FileInputStream input;
    static String propertiesFileLocation = "src\\test\\java\\TestData\\TestConfig.Properties";

    public String getProperty(String key) {
        try {
            input = new FileInputStream(propertiesFileLocation);
            prop.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

}