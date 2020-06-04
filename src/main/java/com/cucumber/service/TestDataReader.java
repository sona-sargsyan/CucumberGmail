package com.cucumber.service;

import java.util.ResourceBundle;

public class TestDataReader {
    public static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
