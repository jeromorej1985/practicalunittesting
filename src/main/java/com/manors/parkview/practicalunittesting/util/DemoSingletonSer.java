package com.manors.parkview.practicalunittesting.util;

import java.io.Serializable;

public class DemoSingletonSer implements Serializable {
    private static final long serialVersionUID = -3917375323824884899L;
    private static volatile DemoSingletonSer instance;

    public static DemoSingletonSer getInstance() {
        if (instance == null) {
            instance = new DemoSingletonSer();
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }

    private int number = 10;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "DemoSingletonSer [number=" + number + "]";
    }

    
    
}