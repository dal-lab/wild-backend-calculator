package com.example.demo.presentation;

public class HomeGetHandler extends ResourceMethodHandler {

    public final static String KEY = "GET /";

    @Override
    public String handle(String content) {
        return "Hello, World!";
    }

}
