package com.coolapplication.myJavaApp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose / endpoint with Hello World
    @GetMapping("/")
    public String sayHell(){
        return "Hello World";
    }
}
