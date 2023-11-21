package com.example.medical_management.email;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);
    String sendMailWithAttachMent(EmailDetails details);
}
