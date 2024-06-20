package com.alataf.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("hello-robert")
    public String helloRobert() {
        return "Hey, Robert finally i did it..";
    }
}
