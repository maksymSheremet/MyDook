package my.code.chapter2.prefer_dependency_injection.email;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

class EmailServiceTest {

    @Test
    void testSEndEmailWelcomeEmail() {
        MailSender mockSender = Mockito.mock(MailSender.class);
        EmailService emailService = new EmailService(mockSender);

        emailService.sendWelcomeEmail("user@example.com");

        verify(mockSender).send("user@example.com", "Ласкаво просимо до нашого сервісу!");
    }

}