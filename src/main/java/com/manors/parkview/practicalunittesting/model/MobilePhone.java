package com.manors.parkview.practicalunittesting.model;

public class MobilePhone {
    private String number;

    public MobilePhone(){}

    public void setNumber(String number){
        if(null == number || number.isEmpty()){
            throw new IllegalArgumentException("number can not be null or empty");
        }

        if(number.startsWith("+")){
            throw new IllegalArgumentException("plus sign prefix not allowed, number: [" + number + "]");
        }

        this.number = number;
    }
    
}