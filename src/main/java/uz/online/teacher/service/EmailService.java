package uz.online.teacher.service;

public interface EmailService {
    void sendGmailMessage(String to, String subject, String text);
}
