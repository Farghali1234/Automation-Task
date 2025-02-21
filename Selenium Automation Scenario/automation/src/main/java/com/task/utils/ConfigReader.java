package com.task.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
        }
    }

    public String getAmazonUrl() {
        return properties.getProperty("amazon.url");
    }

    public String getAmazonEmail() {
        return properties.getProperty("amazon.email");
    }

    public String getAmazonPassword() {
        return properties.getProperty("amazon.password");
    }
}
