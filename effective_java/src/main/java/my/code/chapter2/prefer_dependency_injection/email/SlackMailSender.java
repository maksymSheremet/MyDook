package my.code.chapter2.prefer_dependency_injection.email;

public class SlackMailSender implements MailSender {
    @Override
    public void send(String to, String message) {
        System.out.printf("💬 Надіслано через Slack до %s: %s%n", to, message);
    }
}
