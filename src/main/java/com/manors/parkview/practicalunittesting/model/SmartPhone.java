package com.manors.parkview.practicalunittesting.model;

public class SmartPhone {
    private final boolean mobile;
    private final String number;

    public SmartPhone(String number){
        this.number = number;
        this.mobile = number.startsWith("+") && number.endsWith("9");
    }

    public boolean isMobile(){
        return mobile;
    }

    @Override
    public String toString() {
        return "SmartPhone [mobile=" + mobile + ", number=" + number + "]";
    }

    
}