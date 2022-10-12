package com.example.mstwo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsTwoController {
    @GetMapping("/info")
    public String info(@AuthenticationPrincipal Jwt jwt) {
        return jwt.getClaims().toString();
    }
}
