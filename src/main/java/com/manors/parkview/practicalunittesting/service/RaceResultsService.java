package com.manors.parkview.practicalunittesting.service;

import java.util.Collection;
import java.util.HashSet;

import com.manors.parkview.practicalunittesting.model.Message;
import com.manors.parkview.practicalunittesting.model.Subscriber;

public class RaceResultsService {
    private Collection<Subscriber> subscribers = new HashSet<Subscriber>();

	public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
	}

	public void send(Message message) {
        for(Subscriber subscriber : subscribers) {
            subscriber.receive(message);
        }
       
	}

	public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
	}

}
