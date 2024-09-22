package com.aluminium.online_judge.service;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ParserService {

    public UUID stringToUUID(String request) {
        UUID uuid;

        try {
            uuid = UUID.fromString(request);
        } catch (Exception e) {
            throw new IllegalArgumentException("Token UUID invalid: " + e.getMessage());
        }

        return uuid;
    }
}
