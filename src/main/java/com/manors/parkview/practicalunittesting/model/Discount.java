package com.manors.parkview.practicalunittesting.model;

import com.opencsv.bean.CsvBindByName;

public class Discount {
    @CsvBindByName
    private double value;
    @CsvBindByName
    private double discount;


    public Discount() {
        // default constructor
    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    


    
}