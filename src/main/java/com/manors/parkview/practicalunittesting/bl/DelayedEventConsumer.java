package com.manors.parkview.practicalunittesting.bl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;

import com.manors.parkview.practicalunittesting.model.DelayedEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DelayedEventConsumer implements Runnable {
    private final DelayQueue<DelayedEvent> queue;
    private final Logger logger = LoggerFactory.getLogger(DelayedEventConsumer.class);

    public DelayedEventConsumer(DelayQueue<DelayedEvent> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        List<DelayedEvent> events = new ArrayList<DelayedEvent>();
        queue.drainTo(events);
        logger.info("\nEvent processing started *****************\n");
        events.stream()
            .forEach(event -> logger.info(event.toString()));
        Logger.info("\nEvent processing ended ******************\n");

    }

    
    
}