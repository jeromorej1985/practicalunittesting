package com.manors.parkview.practicalunittesting.driver;

import com.manors.parkview.practicalunittesting.util.PropertiesCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesCacheDriver {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesCacheDriver.class);
    private static PropertiesCache instance = PropertiesCache.getInstance();

    public static void main(String[] args) {
        String message;
        // get Individual properties
        message = String.format("First name retrieved from file is %s", instance.getProperty("firstName"));
        logger.info(message);

        message = String.format("Technology retrieved from file is %s", instance.getProperty("technology"));
        logger.info(message);

        message = String.format("All properties retrieved from file are %s", instance.getAllPropertyNames());
        logger.info(message);
    }

}