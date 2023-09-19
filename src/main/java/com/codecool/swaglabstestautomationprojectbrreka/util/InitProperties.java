package com.codecool.swaglabstestautomationprojectbrreka.util;

import java.io.*;
import java.util.*;

public class InitProperties {
    private static final String CONFIG_PROPERTIES_PATH = "C:\\Users\\bencz\\Documents\\InvisiSh9\\TECH\\JAVAPROJECTS\\Swag-Labs-Test-Automation-Project-BRreka\\src\\main\\java\\com\\codecool\\swaglabstestautomationprojectbrreka\\config\\config.properties";
    private static volatile Properties properties;

    private InitProperties() {}

    public static Properties getInstance() {
        if(CONFIG_PROPERTIES_PATH == null) {
            throw new IllegalArgumentException("Please provide config path");
        }
        Properties prop = properties;
        if(prop == null) {
            synchronized (InitProperties.class) {
                prop = properties;
                if(prop == null) {
                    prop = new Properties();
                    try {
                        FileInputStream ip = new FileInputStream(CONFIG_PROPERTIES_PATH);
                        prop.load(ip);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return prop;
    }
}
