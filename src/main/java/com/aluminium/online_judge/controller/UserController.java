package com.aluminium.online_judge.controller;

import com.aluminium.online_judge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getUserInfo(Authentication authentication) {
        UUID userId = (UUID) authentication.getPrincipal();
        return userService.getUserInfo(userId);
    }

}
