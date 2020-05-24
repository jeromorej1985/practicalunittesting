package com.manors.parkview.practicalunittesting.util;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(DataDrivenTestRunner.class)
public class ReadExcelDataTest {
    private DiscountCalculator discountCalculator;

    @Before
    public void initialize() throws FileNotFoundException {
        discountCalculator = new DiscountCalculator();
    }
    
    @Test
    @DataLoader(
        filePaths = {"purchasediscount.xls"},
        loaderType = LoaderType.EXCEL
    )
    public void shouldCalculateDiscount(
        @Param(name = "value") String value,
        @Param(name = "discount") String discount
    ){
        assertEquals(Double.parseDouble(discount), discountCalculator.calculateDiscount(Double.parseDouble(value)), 0.0001);
    }
}