package com.manors.parkview.practicalunittesting.model;

import java.util.List;

public interface User {

    String getPassword();
    void setPassword(String password);
    List<Phone> getPhones();
   void addPhone(Phone phone);
    
}
