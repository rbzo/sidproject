package com.banque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("springbeans.xml")
public class ProjetsidApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetsidApplication.class, args);
    }
}
