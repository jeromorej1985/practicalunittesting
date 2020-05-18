package com.manors.parkview.practicalunittesting.bl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.manors.parkview.practicalunittesting.model.Client;

import org.junit.Test;

public class MessengerTest {
	private static final String CLIENT_EMAIL = "some@email.com";
	private static final String MSG_CONTENT = "Dear Mary! You are wonderful";

	@Test
	public void testMessenger() throws Exception {

	}

	@Test
	public void testSendMessage() throws Exception {
		Template template = mock(Template.class);
		Client client = mock(Client.class);
		MailServer mailServer = mock(MailServer.class);
		TemplateEngine templateEngine = mock(TemplateEngine.class);

		Messenger messenger = new Messenger(mailServer, templateEngine);
		
		when(client.getEmail()).thenReturn(CLIENT_EMAIL);
		when(templateEngine.prepareMessage(template, client)).thenReturn(MSG_CONTENT);

		messenger.sendMessage(client, template);

		verify(mailServer).send(CLIENT_EMAIL, MSG_CONTENT);

	}

}
