package com.manors.parkview.practicalunittesting.bl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HelloRedesignedTest {
	private HelloRedesigned hello;
	private TimeProvider timeProvider;

	@BeforeEach
	public void setUp() {
		timeProvider = mock(TimeProvider.class);
		hello = new HelloRedesigned(timeProvider);
	}

	
	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11})
	public void shouldSayGoodMorningInTheMorning(int morningHour) throws Exception {
		when(timeProvider.getTime()).thenReturn(getCalendar(morningHour));

		String errorMessage = String.format("In the morning you should say %s!", hello.sayHello());
		assertEquals("Good Morning!", hello.sayHello(), errorMessage);
	}


	@ParameterizedTest
	@ValueSource(ints = {12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23})
	public void shouldSayGoodEveningInTheEvening(int eveningHour) throws Exception {
		when(timeProvider.getTime()).thenReturn(getCalendar(eveningHour));

		String errorMessage = String.format("In the evening you should say %s" , hello.sayHello());
		assertEquals("Good Afternoon!", hello.sayHello(), errorMessage);
	}

	private Calendar getCalendar(int hour){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hour);
		return cal;
	}

}
