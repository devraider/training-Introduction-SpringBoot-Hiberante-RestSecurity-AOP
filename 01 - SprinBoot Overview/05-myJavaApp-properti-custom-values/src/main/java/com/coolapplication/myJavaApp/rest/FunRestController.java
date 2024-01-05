package com.coolapplication.myJavaApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${coach.name}")
//    Custom property from properties file
    private String coachName;
    @Value("${team.name}")
    private String teamName;


    // expose / endpoint with Hello World
    @GetMapping("/")
    public String sayHell(){
        return "Hello World!" + coachName;
    }
    @GetMapping("/devtool")
    public String newEndpoint() {
        return "New endpoint testing devtools hot reload!";
    }
}
