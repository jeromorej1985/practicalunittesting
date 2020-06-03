package com.manors.parkview.practicalunittesting.bl;

import java.time.LocalDateTime;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.atomic.AtomicInteger;

import com.manors.parkview.practicalunittesting.model.DelayedEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelayedEventProducer implements Runnable {
    private final DelayQueue<DelayedEvent> queue;
    private AtomicInteger counter;
    private static final Logger logger = LoggerFactory.getLogger(DelayedEventProducer.class);

    public DelayedEventProducer(DelayQueue<DelayedEvent> queue, AtomicInteger counter) {
        this.queue = queue;
        this.counter = counter;
    }

    @Override
    public void run() {
        LocalDateTime now = LocalDateTime.now();
        int id = counter.incrementAndGet();
        DelayedEvent event = new DelayedEvent(id, "Task-" + id, now);
        logger.info("Added to queue :: " + event);
        queue.add(event);
    }
    
}