package com.aluminium.online_judge.controller;

import com.aluminium.online_judge.IO.LoginIO.LoginInput;
import com.aluminium.online_judge.IO.signupIO.SignupInput;
import com.aluminium.online_judge.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody SignupInput request) {
        return authService.signup(request.getUsername(), request.getEmail(), request.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginInput request) {
        return authService.login(request.getEmail(), request.getPassword());
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logout(Authentication authentication) {
        return authService.logout((UUID) authentication.getPrincipal());
    }

    @PostMapping("/generateAccessToken")
    public ResponseEntity<String> generateAccessToken(Authentication authentication) {
        return authService.generateAccessToken((UUID) authentication.getPrincipal());
    }
}
