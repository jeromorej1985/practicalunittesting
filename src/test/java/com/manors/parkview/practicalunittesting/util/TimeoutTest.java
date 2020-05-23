package com.manors.parkview.practicalunittesting.util;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutTest {

    @Rule
    public Timeout globalTimeout = new Timeout(2000, TimeUnit.MILLISECONDS);

    @Test
    public void willFail() throws InterruptedException {
        Thread.sleep(3000);
        assertTrue(true);
    }
    
    @Test
    public void willPass() throws InterruptedException {
        Thread.sleep(40000);
    }
}