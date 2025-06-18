package com.katusoft.parking_a_lot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/auth/login")
public class AuthController {

    @GetMapping()
    public String getMethodName() {
        return "test";
    }
    

}
