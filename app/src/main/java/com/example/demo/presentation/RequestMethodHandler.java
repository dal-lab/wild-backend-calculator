package com.example.demo.presentation;

import java.io.IOException;

public interface RequestMethodHandler {

    String handler(String content) throws IOException;
}
