package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // this class will handle HTTP requests and return responses
public class HelloController {

    @GetMapping("/hello") // When someone sends a GET request to /hello, execute the method below
    public String hello() {
        return "Hello, World";
    }
}
