package com.manors.parkview.practicalunittesting.bl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;

import com.manors.parkview.practicalunittesting.model.Email;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest({MailClient.class, EmailServer.class})
@RunWith(PowerMockRunner.class)
public class MailClientTest {
	private MailClient mailClient;

	@Before
	public void initialize(){
		mailClient = new MailClient();
	}

	@After
	public void validate() {
    	validateMockitoUsage();
	}

	@Test
	public void shouldSendMail() throws Exception {
		String address = "1234 Winter Way";
		String title = "Blue Almonds";
		String body = "This is a short tale";

		PowerMockito.mockStatic(EmailServer.class);
		ArgumentCaptor<Email> captor = ArgumentCaptor.forClass(Email.class);

		mailClient.sendEmail(address, title, body);
		PowerMockito.verifyStatic(EmailServer.class, times(1));
		EmailServer.sendEmail(captor.capture());
		Email emailResults = captor.getValue();
		assertEquals(address, emailResults.getAddress());
		assertEquals(title, emailResults.getTitle());
		assertEquals(body, emailResults.getBody());
	
	}

}
