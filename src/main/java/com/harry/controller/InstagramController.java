package com.harry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/instagram")
public class InstagramController {

    @GetMapping("/welcome/{userName}")
    public String welcome(@PathVariable String userName) {
        return "Hello " + userName + ", welcome to instagram media!!";
    }
}
