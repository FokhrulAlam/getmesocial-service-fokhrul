package com.fokhrul.HelloWorld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
public class requestController {

    @RequestMapping
    public String userInfo(){
        return "Hello World! This is Fokhrul.";
    }
}
