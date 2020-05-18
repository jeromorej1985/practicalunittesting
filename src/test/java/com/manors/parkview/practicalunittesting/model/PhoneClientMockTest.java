package com.manors.parkview.practicalunittesting.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class PhoneClientMockTest {
    final static Phone MOBILE_PHONE = mock(Phone.class);
    final static Phone STATIIONARY_PHONE = mock(Phone.class);
    PhoneClient client = new PhoneClient();

    @Test
    public void shouldReturnTrueIfClientHasMobile(){
        when(MOBILE_PHONE.isMobile()).thenReturn(true);

        client.addPhone(MOBILE_PHONE);
        client.addPhone(STATIIONARY_PHONE);

        assertTrue(client.hasMobile());
    }

    @Test
    public void shouldReturnFalseIfClientHasNoMobile(){
        client.addPhone(STATIIONARY_PHONE);

        assertFalse(client.hasMobile());
    }
    
}