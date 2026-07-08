package org.example.ch3_develop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ch3DevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch3DevelopApplication.class, args);
    }

}
