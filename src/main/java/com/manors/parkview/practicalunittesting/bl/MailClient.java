package com.manors.parkview.practicalunittesting.bl;

import com.manors.parkview.practicalunittesting.model.Email;


public class MailClient {

    public void sendEmail(String address, String title, String body) {
        Email email = new Email(address, title, body);
        EmailServer.sendEmail(email);
    }
    
}