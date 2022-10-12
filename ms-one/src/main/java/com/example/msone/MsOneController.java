package com.example.msone;

import org.springframework.http.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
public class MsOneController {
    private final RestTemplate restTemplate;

    public MsOneController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String hello(@AuthenticationPrincipal Jwt jwt) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt.getTokenValue());

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:42069",
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class
        );
        return "Hello from first microservice! " + response.getBody();
    }
}
