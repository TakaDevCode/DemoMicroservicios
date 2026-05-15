package org.example.atencion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AtencionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtencionApplication.class, args);
    }

}
