package my.code.chapter2.prefer_dependency_injection.email;

import org.junit.jupiter.api.Test;

class SlackMailSenderTest {
    @Test
    void testSlackIntegrationWithEmailService() {
        MailSender slackSender = new SlackMailSender();
        EmailService service = new EmailService(slackSender);

        service.sendWelcomeEmail("tester_slack");
    }
}