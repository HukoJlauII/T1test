package com.example.t1test;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "T1 test case", version = "1.0.0", contact = @Contact(name = "Glushko Nikita", email = "polosatay_zebra@mail.ru", url = "https://github.com/HukoJlauII")))
@SpringBootApplication
public class T1testApplication {

    public static void main(String[] args) {
        SpringApplication.run(T1testApplication.class, args);
    }

}
