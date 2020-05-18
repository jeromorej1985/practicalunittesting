package com.manors.parkview.practicalunittesting.model;

public class Phone {
    private final boolean mobile;
    private final String number;

    public Phone(boolean mobile, String number) {
        this.mobile = mobile;
        this.number = number;
    }

    public boolean isMobile() {
        return mobile;
    }

    

    @Override
    public String toString() {
        return "Phone [mobile=" + mobile + ", number=" + number + "]";
    }

    

    
    
}