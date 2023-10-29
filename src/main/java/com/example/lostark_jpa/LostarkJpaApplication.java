package com.example.lostark_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class LostarkJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LostarkJpaApplication.class, args);
    }

}
