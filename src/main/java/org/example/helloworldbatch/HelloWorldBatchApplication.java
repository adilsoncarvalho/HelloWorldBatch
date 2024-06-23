package org.example.helloworldbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldBatchApplication {
    public static void main(String[] args) {
        System.exit(
                SpringApplication.exit(
                    SpringApplication.run(HelloWorldBatchApplication.class, args)
                )
        );
    }
}
