package com.example.medical_management.service.email;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}
