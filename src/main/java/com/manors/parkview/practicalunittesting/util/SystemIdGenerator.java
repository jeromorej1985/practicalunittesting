package com.manors.parkview.practicalunittesting.util;

public class SystemIdGenerator implements IdGenerator {

    @Override
    public Long nextId() {
        return System.currentTimeMillis();
    }
    
}