package my.code.chapter2.prefer_dependency_injection.email;

public interface MailSender {
    void send(String to, String message);
}
