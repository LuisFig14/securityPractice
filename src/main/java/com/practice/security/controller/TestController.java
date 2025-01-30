package com.practice.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String home (){
        return "¡Welcome to the principal page!";
    }

    @GetMapping("/user")
    public String user(){
        return "¡Hello user!";
    }

    @GetMapping("/admin")
    public String admin(){
        return "¡Hello admin!";
    }

}
