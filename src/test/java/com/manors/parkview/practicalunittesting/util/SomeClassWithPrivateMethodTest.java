package com.manors.parkview.practicalunittesting.util;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class SomeClassWithPrivateMethodTest {

    @Test
    public void shouldTestPrivateMethodWithReflection() throws NoSuchMethodException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        SomeClassWithPrivateMethod sut = new SomeClassWithPrivateMethod();
        Class<Long>[] parameterTypes = new Class[1];
        parameterTypes[0] = java.lang.Long.class;
        Method method = sut.getClass().getDeclaredMethod("privateMethod", parameterTypes);
        method.setAccessible(true);
        Object[] arguments = new Object[1];
        arguments[0] = 557L;
        boolean result = (boolean) method.invoke(sut, arguments);

        assertTrue(result);
    }

}
