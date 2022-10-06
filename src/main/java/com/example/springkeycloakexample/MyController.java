package com.example.springkeycloakexample;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
    @GetMapping("/")
    public String startPage() {
        return "startPage";
    }

    @GetMapping("/info")
    public String getUserInfo(Model model, @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("info", principal.getAuthorities().toString());
        return "info";
    }
}
