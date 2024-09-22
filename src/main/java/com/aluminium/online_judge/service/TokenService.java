package com.aluminium.online_judge.service;

import com.aluminium.online_judge.model.Token;
import com.aluminium.online_judge.model.User;
import com.aluminium.online_judge.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public Token getTokenByJti(UUID jti) {
        Optional<Token> tokenOptional = tokenRepository.findById(jti);
        return tokenOptional.orElseGet(Token::new);
    }

    public Token createRefreshToken(User user) {
        Token token = new Token(user);
        return tokenRepository.save(token);
    }

    public void logout(UUID jti) {
        tokenRepository.logout(jti);
    }
}
