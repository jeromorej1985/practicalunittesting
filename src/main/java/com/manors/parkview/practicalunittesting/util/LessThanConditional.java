package com.manors.parkview.practicalunittesting.util;

import java.util.function.Predicate;

public class LessThanConditional implements Predicate<Integer> {

    @Override
    public boolean test(Integer object) {
        return object < 10;
    }
}