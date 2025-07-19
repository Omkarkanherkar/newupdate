package com.substring.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Scans com.substring.chat.*
public class ChatAppBackenedApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatAppBackenedApplication.class, args);
    }
}
