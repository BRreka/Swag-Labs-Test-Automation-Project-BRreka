package com.codecool.swaglabstestautomationprojectbrreka.util;

import java.io.*;
import java.util.*;

public class InitPropertiesClass {
    private static final String CONFIG_PROPERTIES_PATH = null;
    private static volatile Properties properties;

    private InitPropertiesClass() {}

    public static Properties getInstance() {
        if(CONFIG_PROPERTIES_PATH == null) {
            throw new IllegalArgumentException("Please provide config path");
        }
        Properties prop = properties;
        if(prop == null) {
            synchronized (InitPropertiesClass.class) {
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
