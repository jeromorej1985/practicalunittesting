package com.manors.parkview.practicalunittesting.driver;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapIterationDriver {
    private static final Logger log = LoggerFactory.getLogger(MapIterationDriver.class);

    public static final void main(String[] args){
        Map<String, Integer> mapOfIntegers = Stream.of(
            new AbstractMap.SimpleEntry<>("one", 1),
            new AbstractMap.SimpleEntry<>("two", 2),
            new AbstractMap.SimpleEntry<>("three", 3)
        )
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Iterator<Map.Entry<String, Integer>> iterator = mapOfIntegers.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            log.info(String.format("entry key: %s entry value: %d", entry.getKey(), entry.getValue()));
        }

        Stream.iterate(1, count -> count+1)
            .filter(num -> num%4 == 0)
            .limit(12)
            .forEach(num -> log.info(" " + num));
    }
    
}