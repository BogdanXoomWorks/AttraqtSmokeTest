package com.xoomworks.attraqt.utilities;

import java.io.IOException;
import java.util.Properties;


public class UrlMap {
    private static Properties properties;


    public UrlMap(){
        properties = new Properties();
        try {
            properties.load(UrlMap.class.getResourceAsStream("/url.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
