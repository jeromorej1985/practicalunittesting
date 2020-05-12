package com.manors.parkview.practicalunittesting.model;

import lombok.Data;

@Data
public class Address {
    private String street;

    public Address(String street) {
        this.street = street;
    }


    public String getStreet() {
        return street;
    }

}
