package my.code.chapter2.prefer_dependency_injection.email;

public class MailApp {
    public static void main(String[] args) {
        MailSender slack = new SlackMailSender();
        EmailService emailService = new EmailService(slack);

        emailService.sendWelcomeEmail("slack_user123");
    }
}
