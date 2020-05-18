package com.manors.parkview.practicalunittesting.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneClient {
    private final List<Phone> phones = new ArrayList<>();

    public void addPhone(Phone phone){
        phones.add(phone);
    }

    public boolean hasMobile(){
        for (Phone phone : phones){
            if (phone.isMobile()){
                return true;
            }
        }
        return false;
    }
}