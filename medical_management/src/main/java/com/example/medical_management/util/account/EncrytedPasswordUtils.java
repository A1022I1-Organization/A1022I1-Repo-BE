package com.example.medical_management.util.account;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Method để mã hoà password
    public static String encrytePassword(String password) {
        return encoder.encode(password);
    }

    // Method để kiểm tra mật khẩu đã mã hóa có khớp với mật khẩu gốc không
    public static boolean checkPassword(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }

    // chạy test để mã hoá password
    public static void main(String[] args) {
        String password = "123";
        String encrytedPassword = encrytePassword(password);

        System.out.println("Encryted Password: " + encrytedPassword);

        // Kiểm tra mật khẩu
        System.out.println("Is password valid? " + checkPassword("123", "$2a$10$iFzuka6g2q9CyYat.2mc.MQ1.B/2ZJdCcyZONsYy.YrVWp2EMvga"));
    }

}
