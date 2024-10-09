package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {
    @Test
    void creation() {
        App app = new App();
        assertThat(app).isNotNull();
    }
}
