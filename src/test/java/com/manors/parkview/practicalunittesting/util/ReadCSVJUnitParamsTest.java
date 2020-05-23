package com.manors.parkview.practicalunittesting.util;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;

@RunWith(JUnitParamsRunner.class)
public class ReadCSVJUnitParamsTest {
    private DiscountCalculator discountCalculator;

    @Before
    public void initializer() throws IllegalStateException, FileNotFoundException {
        discountCalculator = new DiscountCalculator();
    }
    
    @Test
    @FileParameters(value = "classpath:financial.csv", mapper = CsvWithHeaderMapper.class)
    public void shouldCalculateDiscount(double value, double discount){
        assertEquals(discount, discountCalculator.calculateDiscount(value), 0.0001);
    }
}