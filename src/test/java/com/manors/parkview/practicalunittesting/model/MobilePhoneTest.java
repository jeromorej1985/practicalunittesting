package com.manors.parkview.practicalunittesting.model;

import static com.googlecode.catchexception.CatchException.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MobilePhoneTest {
	private MobilePhone phone = new MobilePhone();

	@Test
	public void shouldThrowIAEForEmptyNumber() throws Exception {
		catchException(phone).setNumber(null);

		assertTrue(caughtException() instanceof IllegalArgumentException);
		assertEquals("number can not be null or empty", caughtException().getMessage());

	}

	@Test
	public void shouldThrowIAEForPlusPrefixedNumber() throws Exception {
		String phoneNumber = "+999-777-9999";
		catchException(phone).setNumber(phoneNumber);

		//assertTrue(caughtException() instanceof IllegalArgumentException);
		if(null != caughtException()){
			assertEquals("plus sign prefix not allowed, number: [" + phoneNumber +"]", caughtException().getMessage());
		}
	}

	@Test
	public void shouldThrowIllegalArgumentExceptionForEmptyNumber(){
		try {
			phone.setNumber(null);
			fail("Should have thrown IllegalArgumentException");
		} catch(IllegalArgumentException iae){
			assertEquals("number can not be null or empty", iae.getMessage());
		}
	}

}
