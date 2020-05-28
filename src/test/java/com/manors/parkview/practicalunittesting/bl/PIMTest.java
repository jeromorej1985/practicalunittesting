package com.manors.parkview.practicalunittesting.bl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Date;

import com.manors.parkview.practicalunittesting.model.Meeting;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class PIMTest {
	private static final int ONE_HOUR = 60;
	private static final Date START_DATE = new Date();
	private static final int MILLIS_IN_MINUTE = 1000 * 60;
	private static final Date END_DATE = new Date(START_DATE.getTime() + ONE_HOUR
		* MILLIS_IN_MINUTE);
	private Calendar calendar;
	private PIM pim;

	@Before
	public void initialize() {
		calendar = mock(Calendar.class);
		pim = new PIM(calendar);
	}

	

	@Test
	public void shouldAddNewEventToCalendar() throws Exception {
		Meeting expectedMeeting = new Meeting(START_DATE, END_DATE);
		pim.addMeeting(START_DATE, ONE_HOUR);

		verify(calendar).addEvent(expectedMeeting);
	}

	@Test
	public void shouldAddNewEventToCallendarVerifyingArgument() throws Exception {
		ArgumentCaptor<Meeting> argument =  ArgumentCaptor.forClass(Meeting.class);
		pim.addMeeting(START_DATE, ONE_HOUR);

		verify(calendar).addEvent(argument.capture());
		Meeting meeting = argument.getValue();
		assertEquals(START_DATE, meeting.getStartDate());
		assertEquals(END_DATE, meeting.getEndDate());
	}

}
