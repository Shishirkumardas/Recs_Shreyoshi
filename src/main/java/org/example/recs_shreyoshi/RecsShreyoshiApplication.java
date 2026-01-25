package org.example.recs_shreyoshi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.example.recs_shreyoshi")
@EnableJpaRepositories(basePackages = "org.example.recs_shreyoshi")
public class RecsShreyoshiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecsShreyoshiApplication.class, args);
    }

}
