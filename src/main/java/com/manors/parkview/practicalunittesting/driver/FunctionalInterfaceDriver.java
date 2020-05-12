package com.manors.parkview.practicalunittesting.driver;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.manors.parkview.practicalunittesting.util.LessThanConditional;
import com.manors.parkview.practicalunittesting.util.StringProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FunctionalInterfaceDriver {
    private static final Logger log = LoggerFactory.getLogger(FunctionalInterfaceDriver.class);

    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(10, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> numberGreaterThanFive = n -> n > 5;
        Predicate<Integer> numberLessThanEight = n -> n < 8;
        Predicate<Integer> numberLessThanNine = FunctionalInterfaceDriver::lessThanNine;

        List<Integer> collectedResult1 = numbers.stream().filter(n -> n > 5 && n < 8).collect(Collectors.toList());
        List<Integer> collectedResult2 = numbers.stream().filter(numberGreaterThanFive.and(numberLessThanEight)).collect(Collectors.toList());
        List<Integer> collectedResult3 = numbers.stream().filter(numberGreaterThanFive.and(numberLessThanNine)).collect(Collectors.toList());
        List<Integer> collectedResult4 = numbers.stream().filter(new LessThanConditional()::test).collect(Collectors.toList());
        log.info(String.valueOf("Lambda expression: " + collectedResult1));
        log.info(String.valueOf("Function construct: " + collectedResult2));
        log.info(String.valueOf("Interface construct: " + collectedResult3));
        log.info(String.valueOf("Implements Method constract: " + collectedResult4));

        log.info("Regular boolean function: " + lessThanNine(12));


        List<String> alphabethSoup = Arrays.asList("A", "AAA", "AA", "B", "BB", "BBB", "FFF");

        Predicate<String> startsWithLetterA = s -> s.startsWith("A");
        Predicate<String> startsWithLetterB = s -> s.startsWith("B");
        log.info(StringProcessor.filter(alphabethSoup, startsWithLetterA).toString());
        log.info(StringProcessor.filter(alphabethSoup, startsWithLetterB).toString());
    }

    private static boolean lessThanNine(int number){
        return number < 9;
    }
    
    
}