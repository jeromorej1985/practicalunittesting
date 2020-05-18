package com.manors.parkview.practicalunittesting.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import com.manors.parkview.practicalunittesting.model.Message;
import com.manors.parkview.practicalunittesting.model.Subscriber;

import org.junit.Test;

public class RaceResultsServiceTest {
    private RaceResultsService raceResults = new RaceResultsService();
    private Message message = mock(Message.class);
    private Subscriber subscriberA = mock(Subscriber.class, "subscriberA");
    private Subscriber subscriberB = mock(Subscriber.class, "subscriberB");

    @Test
    public void notSubscribedClientShouldNotReceiveMessage(){
        raceResults.send(message);

        verify(subscriberA, never()).receive(message);
        verify(subscriberB, never()).receive(message);
    }
    
    @Test
    public void subscribedClientShouldReceiveMessage(){
        raceResults.addSubscriber(subscriberA);
        raceResults.send(message);

        verify(subscriberA).receive(message);
    }

    @Test
    public void allSubscribedClientsShouldReceiveMessages(){
        raceResults.addSubscriber(subscriberA);
        raceResults.addSubscriber(subscriberB);
        raceResults.send(message);

        verify(subscriberA).receive(message);
        verify(subscriberB).receive(message);
    }

    @Test
    public void shouldSendOnlyOneMessageToMultipleSubscriber(){
        raceResults.addSubscriber(subscriberA);
        raceResults.addSubscriber(subscriberA);
        raceResults.send(message);

        verify(subscriberA).receive(message);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveMessage(){
        raceResults.addSubscriber(subscriberA);
        raceResults.removeSubscriber(subscriberA);
        raceResults.send(message);

        verify(subscriberA, never()).receive(message);
    }


   
    
}