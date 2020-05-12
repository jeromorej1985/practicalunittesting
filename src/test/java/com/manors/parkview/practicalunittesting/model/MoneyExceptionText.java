package com.manors.parkview.practicalunittesting.model;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class MoneyExceptionText {
    private final static int VALID_AMOUNT = 5;
    private final static String VALID_CURRENCY = "USD";

    private static final Object[] getInvalidAmount() {
        return new Integer[][]{{-1254}, {-5}, {-1}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method =  "getInvalidAmount")
    public void constructorShouldThroowIAEForInvalidAmount( int invalidAmount){
       new Money(invalidAmount, VALID_CURRENCY);
    }

    private static final Object[] getCurrency(){
        return new String[][]{{null}, {""}};
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "getCurrency")
    public void constructorShouldThrowIAEForInvalidCurrency(String invalidCurrency){
        new Money(VALID_AMOUNT, invalidCurrency);
    }
}
