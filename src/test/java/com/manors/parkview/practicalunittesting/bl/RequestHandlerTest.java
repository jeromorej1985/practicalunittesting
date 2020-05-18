package com.manors.parkview.practicalunittesting.bl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static com.googlecode.catchexception.CatchException.*;

import com.manors.parkview.practicalunittesting.exception.InvalidRequestException;

import org.junit.Test;

public class RequestHandlerTest {

	@Test
	public void shouldThrowException() throws InvalidRequestException {
		Request request = createInvalidRequest();
		RequestProcessor requestProcessor = mock(RequestProcessor.class);
		RequestHandler reqHandler = new RequestHandler(requestProcessor);

		catchException(reqHandler).handle(request);

		assertTrue("Should have thrown exception of InvalidRequestException class", caughtException() instanceof InvalidRequestException);
		verify(requestProcessor, never()).process(request);
	}

	private Request createInvalidRequest() {
		return null;
	}

	@Test
	public void testHandle() throws Exception {

	}

}
