package com.ligan.oauth2login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Bean
    public SecurityFilterChain defaultSecurityChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .oauth2Login(oauth->oauth.defaultSuccessUrl("/user-info", true))
                .logout(logout->logout.logoutSuccessUrl("/"))
                .formLogin(form->form.defaultSuccessUrl("/secured", true))
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}
