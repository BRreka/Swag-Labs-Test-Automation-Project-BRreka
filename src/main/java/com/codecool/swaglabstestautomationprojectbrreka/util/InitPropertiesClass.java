package com.codecool.swaglabstestautomationprojectbrreka.util;

import java.io.*;
import java.util.*;

public class InitPropertiesClass {
    private static final CONFIG_PROPERTIES_PATH;
    private static volatile Properties properties;

    private InitPropertiesClass() {}

    public static Properties getInstance() throws IOException {
        if (CONFIG_PROPERTIES_PATH == null) {
            throw new IllegalArgumentException("Please provide config path");
        }
        Properties prop = properties;
        if(prop == null) {
            synchronized (InitPropertiesClass.class) {
                prop = properties;
                if(prop == null) {
                    prop = new Properties();
                    FileInputStream ip = new FileInputStream(CONFIG_PROPERTIES_PATH);
                    prop.load(ip);
                }
            }
        }
        return prop;
    }
}
