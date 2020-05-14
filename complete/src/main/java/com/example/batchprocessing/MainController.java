package com.example.batchprocessing;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello";
    }
}
