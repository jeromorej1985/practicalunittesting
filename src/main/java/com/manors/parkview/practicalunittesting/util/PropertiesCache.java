package com.manors.parkview.practicalunittesting.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesCache implements Serializable {
    private static final long serialVersionUID = -5998279979157515352L;
    private final Properties properties = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(PropertiesCache.class);
    private static final String FILENAME = "application.properties";

    private PropertiesCache() {
        String message;
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(FILENAME);
        
        message = String.format("Started Loading all properties from file %s", FILENAME);
        logger.info(message);

        try {
            properties.load(in);
        } catch (IOException e) {
            String errorMessage = String.format("Unexpected error occurred: %s" , e.getMessage());
            logger.error(errorMessage);
        }

        message = String.format("Finished loading all properties from file %s", FILENAME);
        logger.info(message);
    }

    protected Object readResolve() {
        return getInstance();
    }

    public static PropertiesCache getInstance(){
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }

    public Set<String> getAllPropertyNames(){
        return properties.stringPropertyNames();
    }

    public boolean containsKey(String key){
        return properties.containsKey(key);
    }

    private static class LazyHolder {
        private static final PropertiesCache INSTANCE = new PropertiesCache();
    }
    
}