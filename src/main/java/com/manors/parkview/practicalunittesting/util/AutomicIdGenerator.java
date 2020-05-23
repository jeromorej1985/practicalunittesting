package com.manors.parkview.practicalunittesting.util;

public class AutomicIdGenerator implements IdGenerator {
    private Long nextId = System.currentTimeMillis();

    @Override
    public Long nextId() {
        return nextId++;
    }
    
}