package pl.coderslab.dwall_reports;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder c = new BCryptPasswordEncoder();
        String rawPassword = "user";
        String encodedPassword = c.encode(rawPassword);

        System.out.println(rawPassword);
        System.out.println(encodedPassword);
    }
}
