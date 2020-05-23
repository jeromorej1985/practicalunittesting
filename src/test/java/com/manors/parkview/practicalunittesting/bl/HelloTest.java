package com.manors.parkview.practicalunittesting.bl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelloTest {
	private Hello hello = new Hello();

	@Test
	public void shouldSayGoodMorningInTheMorning() throws Exception {
		assertEquals("Good Morning!", hello.sayHello());
	}

	@Test
	public void shouldSayGoodAfternoonInTheEvening() throws Exception {
		assertEquals("Good Afternoon!", hello.sayHello());
	}

}
