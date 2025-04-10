package my.code.chapter2.prefer_dependency_injection.email;

public class EmailService {
    private final MailSender  mailSender;

    public EmailService(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendWelcomeEmail(String to) {
        String message = "Ласкаво просимо до нашого сервісу!";
        mailSender.send(to, message);
    }
}
