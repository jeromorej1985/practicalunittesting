package com.manors.parkview.practicalunittesting.model;

import java.util.ArrayList;
import java.util.List;

public class SmartPhoneClient {
    private final List<SmartPhone> phones = new ArrayList<>();

    public void addPhone(SmartPhone phone){
        phones.add(phone);
    }

    public boolean hasMobile(){
        for (SmartPhone phone : phones){
            if (phone.isMobile()){
                return true;
            }
        }
        return false;
    }
}