package com.practice.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/public/hello")
    public String home (){
        return "¡Welcome to the public route!";
    }

    @GetMapping("/user/hello")
    public String user(){
        return "¡Hello user!";
    }

    @GetMapping("/admin/hello")
    public String admin(){
        return "¡Hello admin!";
    }

}
