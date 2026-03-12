package com.example.marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal que inicializa a aplicação Spring Boot.
 */
@SpringBootApplication // Anotação que combina @Configuration, @EnableAutoConfiguration e @ComponentScan
public class MarketplaceApplication {

    public static void main(String[] args) {
        // Método estático que inicia a aplicação Spring Boot
        SpringApplication.run(MarketplaceApplication.class, args);
    }
}