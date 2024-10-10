package com.example.demo.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomeGetHandlerTest {

    private RequestMethodHandler requestMethodHandler;

    @BeforeEach
    void setUp() {
        requestMethodHandler = new HomeGetHandler();
    }

    @Test
    void HomeHandler() throws IOException {
        String handler = requestMethodHandler.handler("/");

        assertThat(handler).isEqualTo("hello World");
    }

    @Test
    void getKey() {
        String key = requestMethodHandler.key();

        assertThat(key).isEqualTo("GET /");
    }
}
