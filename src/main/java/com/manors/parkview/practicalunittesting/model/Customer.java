package com.manors.parkview.practicalunittesting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private String name;
    private Address address;
    private double creditLimit;
}