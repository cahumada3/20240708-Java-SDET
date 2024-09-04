package com.skillstorm.spring_gateway.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class FallBackController {
    
    @GetMapping("/cache/accounts")
    public String cachedAccounts() {
        return "Cached Accounts: courtesy of circuit breaker";
    }
}
