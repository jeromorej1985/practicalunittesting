package com.manors.parkview.practicalunittesting.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PhoneClientTest {
	final static String ANY_NUMBER = "999-888-7777";
	final static Phone MOBILE_PHONE = new Phone(true, ANY_NUMBER);
	final static Phone STATIONARY_PHONE = new Phone(false, ANY_NUMBER);

	PhoneClient client = new PhoneClient();

	@Test
	public void shouldReturnTrueIfClientHasMobile() throws Exception {
		client.addPhone(MOBILE_PHONE);
		client.addPhone(STATIONARY_PHONE);
		
		assertTrue(client.hasMobile());
	}

	@Test
	public void shouldReturnFalseIfClientHasNoMobile() throws Exception {
		client.addPhone(STATIONARY_PHONE);

		assertFalse(client.hasMobile());
	}

}
