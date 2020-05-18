package com.manors.parkview.practicalunittesting.driver;

import static org.junit.Assume.assumeTrue;

import org.junit.Test;

public class AssumeTest {

    @Test
    public void shouldRunOnlyOnWindows(){
        assumeTrue(thisIsAWindowMachine());
        System.out.println("running on Window!");
    }

    private boolean thisIsAWindowMachine(){
        return System.getProperty("os.name").startsWith("Windows");
    }

    @Test
    public void shouldRunOnlyOnMac(){
        assumeTrue(thisIsAMacMachine());
        System.out.println("runnning on a Mac");
    }

    private boolean thisIsAMacMachine(){
        return System.getProperty("os.name").startsWith("Mac");
    }
    
}