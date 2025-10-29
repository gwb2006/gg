package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ggController {

    @GetMapping("/test")
    public String test() {
        return "Hello, Spring Boot is running!";
    }
}