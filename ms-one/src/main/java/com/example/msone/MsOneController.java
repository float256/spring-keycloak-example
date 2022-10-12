package com.example.msone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MsOneController {
    private final RestTemplate restTemplate;

    public MsOneController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return "Hello";
    }
}
