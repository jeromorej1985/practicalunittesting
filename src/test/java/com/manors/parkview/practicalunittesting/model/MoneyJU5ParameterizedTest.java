package com.manors.parkview.practicalunittesting.model;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyJU5ParameterizedTest {
    private final static String VALID_CURRENCY = "USD";

    @ParameterizedTest
    @ValueSource(ints = { 10, 20, 40, 50})
    public void constructorShouldSetAmountAndCurrency(int amount){
        Money money = new Money(amount, VALID_CURRENCY);
        assertEquals(amount, money.getAmount());
    }

}
