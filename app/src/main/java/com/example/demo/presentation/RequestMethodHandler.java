package com.example.demo.presentation;

import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public interface RequestMethodHandler {

    String handler(String content) throws IOException;

    String key();
}
