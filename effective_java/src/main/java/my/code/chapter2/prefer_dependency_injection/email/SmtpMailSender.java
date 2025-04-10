package my.code.chapter2.prefer_dependency_injection.email;

public class SmtpMailSender implements MailSender {
    @Override
    public void send(String to, String message) {
        System.out.printf("📨 Надіслано через SMTP до %s: %s%n", to, message);
    }
}
