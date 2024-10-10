package com.example.demo.presentation;

import java.io.IOException;

public abstract class ResourceMethodHandler {
    public abstract String handle(String content) throws IOException;
    public abstract String key();
}
