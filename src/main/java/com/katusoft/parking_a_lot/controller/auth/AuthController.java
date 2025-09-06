package com.katusoft.parking_a_lot.controller.auth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class AuthController {

    @GetMapping("/hello")
    @PreAuthorize("permitAll()")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello-secured")
    @PreAuthorize("hasAnyAuthority('READ')")
    public String helloSecured() {
        return "Hello Secured";
    }

    @GetMapping("/hello-secured2")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String helloSecured2() {
        return "Hello Secured2";
    }
    

}
