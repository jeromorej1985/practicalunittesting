package com.manors.parkview.practicalunittesting.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.unitils.reflectionassert.ReflectionAssert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;

	@Before
	public void setup(){
		user = new SUser();
	}

	@Test
	public void shouldReturnUsersPhone() throws Exception {
		Phone phone = new Phone(false, "888-777-6789");
		user.addPhone(phone);
		List<Phone> phones = user.getPhones();

		assertNotNull(phones);
		assertEquals(1, phones.size());
		assertTrue(phones.contains(phone));

	}

	@Test
	public void twoUsersAreEqualsWithSamePasswordAndPhoneTypeAndPhoneNumber() throws Exception {
		Phone phone1 = new Phone(true, "999-555-5545");
		Phone phone2 = new Phone(true, "999-555-5545");
		user.addPhone(phone1);
		user.setPassword("password");
		User user2 = new SUser();
		user2.addPhone(phone2);
		user2.setPassword("password");

		assertReflectionEquals(user, user2);
	}

	@Test
	public void testSetPassword() throws Exception {

	}

	@Test
	public void testGetPhones() throws Exception {

	}

	@Test
	public void testSetPhones() throws Exception {

	}

	@Test
	public void testToString() throws Exception {

	}

}
