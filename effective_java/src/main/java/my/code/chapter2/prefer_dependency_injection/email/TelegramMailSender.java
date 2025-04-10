package my.code.chapter2.prefer_dependency_injection.email;

public class TelegramMailSender implements MailSender {
    @Override
    public void send(String to, String message) {
        System.out.printf("📲 Надіслано через Telegram до %s: %s%n", to, message);
    }
}
