package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class App {
    public static void main(String[] args) throws IOException {
        // ApplicationContext 생성 방식중에서 Annotation 방식을 사용하여 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        Server server = context.getBean(Server.class);
        server.run();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
