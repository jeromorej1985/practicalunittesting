package com.manors.parkview.practicalunittesting.driver;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.manors.parkview.practicalunittesting.bl.DelayedEventConsumer;
import com.manors.parkview.practicalunittesting.bl.DelayedEventProducer;
import com.manors.parkview.practicalunittesting.model.DelayedEvent;

public class DelayedQueueDriver {
    
    public static void main(String[] args) {
        DelayQueue<DelayedEvent> queue = new DelayQueue<>();
        AtomicInteger counter = new AtomicInteger();
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        ses.scheduleAtFixedRate(new DelayedEventProducer(queue, counter), 1, 2, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new DelayedEventConsumer(queue), 1, 10, TimeUnit.SECONDS);
    }
}