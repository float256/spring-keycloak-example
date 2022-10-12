package com.example.mstwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsTwoController {
    @GetMapping("/")
    public String info() {
        return "Hello from second microservice!";
    }
}
