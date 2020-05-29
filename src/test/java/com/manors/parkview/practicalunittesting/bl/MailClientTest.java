package com.manors.parkview.practicalunittesting.bl;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;

import com.manors.parkview.practicalunittesting.model.Email;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest({MailClient.class, EmailServer.class})
@RunWith(PowerMockRunner.class)
public class MailClientTest {
	private MailClient mailClient;
	private Email email;

	@Before
	public void initialize(){
		mailClient = new MailClient();
		email = mock(Email.class);
	}

	@After
	public void validate() {
    	validateMockitoUsage();
	}

	@Test
	public void shouldSendMail() throws Exception {
		String address = "123 Winter Way";
		String title = "Blue Almonds";
		String body = "This is a short tale";
		PowerMockito.whenNew(Email.class).withArguments(address, title, body).thenReturn(email);
		PowerMockito.mockStatic(EmailServer.class);
		PowerMockito.doNothing().when(EmailServer.class, "sendEmail", email);

		mailClient.sendEmail(address, title, body);
		PowerMockito.verifyStatic(EmailServer.class, times(1));
		EmailServer.sendEmail(email);
	
	}

}
