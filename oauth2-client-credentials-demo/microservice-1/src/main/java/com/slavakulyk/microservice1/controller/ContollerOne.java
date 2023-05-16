package com.slavakulyk.microservice1.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

@RestController
public class ContollerOne {

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @GetMapping("/microservice1/home")
    @ResponseStatus(HttpStatus.OK)
    public String helloRestTemplate() {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt.getTokenValue());
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8084/microservice2/home",
                GET,
                new HttpEntity<>(httpHeaders),
                String.class);

        return "hello - message from microservice 2 -  " + exchange.getBody();
    }

}
