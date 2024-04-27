package com.example.webpos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan("com.example.webpos.model")
public class WebPosApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebPosApplication.class, args);
    }
}
