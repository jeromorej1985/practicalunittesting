package com.manors.parkview.practicalunittesting.model;

import java.util.ArrayList;
import java.util.List;

public class SUser implements User {
    private String password;
    private List<Phone> phones;

    public SUser(){
        phones = new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public List<Phone> getPhones() {
        return phones;
    }

    @Override
    public void addPhone(Phone phone) {
        this.phones.add(phone);
    }

    

    @Override
    public String toString() {
        return "SUser [password=" + password + ", phones=" + phones + "]";
    }

    
}