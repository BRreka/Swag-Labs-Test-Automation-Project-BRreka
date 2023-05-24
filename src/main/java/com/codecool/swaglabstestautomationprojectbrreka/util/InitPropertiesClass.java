package com.codecool.swaglabstestautomationprojectbrreka.util;

import java.io.*;
import java.util.*;

public class InitPropertiesClass {
    private static volatile Properties properties;

    private InitPropertiesClass() {}

    public Properties getInstance() {
        Properties prop = properties;
        if(prop == null) {
            synchronized (InitPropertiesClass.class) {
                prop = properties;
                if(prop == null) {
                    prop = new Properties();
                    try {
                        FileInputStream ip = new FileInputStream("config.properties path");
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
