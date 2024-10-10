package com.example.demo;

import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class Server {

    public void run() throws IOException {
        System.out.println("Listening on http://localhost:8080");
    }
}
