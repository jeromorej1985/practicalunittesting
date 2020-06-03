package com.manors.parkview.practicalunittesting.bl;

import static org.mockito.Mockito.times;

import com.manors.parkview.practicalunittesting.model.Email;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@PrepareForTest({EmailServer.class})
@RunWith(PowerMockRunner.class)
public class MailClientWithoutPowermockTest {
    private MailClient mailClient;

    @Before
    public void initialize() {
        mailClient = new MailClient();
    }

    @Test
    public void shouldAllowToSendMail(){
        String address = "rochelle.yonkers@gmail.com";
        String title = "JavaScript The Definitive";
        String body = "Everyone should learn Javascript";
        Email email = new Email(address, title, body);

        PowerMockito.mockStatic(EmailServer.class);
        mailClient.sendEmail(address, title, body);
        PowerMockito.verifyStatic(EmailServer.class, times(1));
        EmailServer.sendEmail(email);
    }
}