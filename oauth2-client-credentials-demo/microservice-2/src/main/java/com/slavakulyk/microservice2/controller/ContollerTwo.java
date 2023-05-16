package com.slavakulyk.microservice2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContollerTwo {

    @GetMapping("/microservice2/home")
    @ResponseStatus(HttpStatus.OK)
    public String helloRestTemplate() {
        return "Hello";
    }

}
