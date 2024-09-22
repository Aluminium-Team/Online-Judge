package com.aluminium.online_judge.IO.LoginIO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginOutput {
    private String username;
    private String email;
    private String accessToken;
    private String refreshToken;
    private String deviceId;
}
