package com.manors.parkview.practicalunittesting.bl;

import java.util.Date;

import com.manors.parkview.practicalunittesting.model.Meeting;

public class PIM {
    private final static int MILLIS_IN_MINUTE = 60 * 1000;
    private Calendar calendar;
    
    public PIM(Calendar calendar) {
        this.calendar = calendar;
    }

    public void addMeeting(Date startDate, int durationInMinutes) {
        Date endDate = new Date(startDate.getTime() + MILLIS_IN_MINUTE * durationInMinutes);
        Meeting meeting = new Meeting(startDate, endDate);
        calendar.addEvent(meeting);
    }
    
}