package com.InvestWithIntelligence.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/user")
public class UserController {

    @GetMapping("/")
    public String User() {
        return "Security test user";
    }
}
