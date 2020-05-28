package com.manors.parkview.practicalunittesting.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.powermock.reflect.Whitebox;

public class SomeClassWithPrivateMethodPowermockTest {


    @Test
    public void shouldAllowTestingPrivateMethodWithReflection() throws Exception {
        SomeClassWithPrivateMethod sut = new SomeClassWithPrivateMethod();
        boolean result = Whitebox.invokeMethod(sut, "privateMethod", 889789L);
        assertTrue(result);
    }
    
}