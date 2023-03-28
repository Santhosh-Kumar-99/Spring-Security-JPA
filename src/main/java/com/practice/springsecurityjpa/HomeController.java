package com.practice.springsecurityjpa;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.toString();
    }

    @GetMapping("/user")
    public String user(){
        return "<h1>hello</h1>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

}
