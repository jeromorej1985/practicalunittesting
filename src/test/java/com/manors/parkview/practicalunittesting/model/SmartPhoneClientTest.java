package com.manors.parkview.practicalunittesting.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SmartPhoneClientTest {
    private final static SmartPhone MOBILE_PHONE = new SmartPhone("+909-777-9999");
    private final static SmartPhone STATIONARY_PHONE = new SmartPhone("999-777-8888");
    private SmartPhoneClient client = new SmartPhoneClient();

    @Test
    public void shouldReturnTrueIfClientHasMobile(){
        client.addPhone(MOBILE_PHONE);
        client.addPhone(STATIONARY_PHONE);

        assertTrue(client.hasMobile());
    }

    @Test
    public void shouldReturnFalseIfClientHasNoMobile(){
        client.addPhone(STATIONARY_PHONE);

        assertFalse(client.hasMobile());
    }
    
}