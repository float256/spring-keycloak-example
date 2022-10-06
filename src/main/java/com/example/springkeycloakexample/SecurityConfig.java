package com.example.springkeycloakexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(a -> a
                        .antMatchers("/info/*")
                        .hasRole("USER")
                        .anyRequest()
                        .permitAll()
                )
                .logout(l -> l
                        .logoutSuccessUrl("/")
                        .logoutUrl("/logout")
                        .addLogoutHandler(new KeycloakLogoutHandler())
                        .invalidateHttpSession(true)
                        .permitAll()
                )
                .oauth2Login();
        return http.build();
    }
}
