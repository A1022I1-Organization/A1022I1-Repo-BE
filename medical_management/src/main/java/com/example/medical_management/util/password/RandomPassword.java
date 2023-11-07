package com.example.medical_management.util.password;

import java.security.SecureRandom;

public class RandomPassword {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    private static final String ALL = UPPER + LOWER + DIGITS + SPECIAL;

    private static SecureRandom random = new SecureRandom();

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(ALL.length());
            password.append(ALL.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        // Example: Generate a random password with length 12
        String password = generatePassword(12);
        System.out.println("Random Password: " + password);
    }
}
