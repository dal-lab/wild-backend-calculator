package com.example.demo;

import com.example.demo.presentation.RequestHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws IOException {
        App app = new App();

        app.run();
    }

    public void run() throws IOException {


        RequestHandler requestHandler = new RequestHandler();

        //서버 생성 및 start
        InetSocketAddress address = new InetSocketAddress("localhost", 8080);
        HttpServer httpServer = HttpServer.create(address, 0);
        httpServer.createContext("/", requestHandler);
        httpServer.start();

        System.out.println("Listening http://localhost:8080/");
    }
}
