package com.aluminium.online_judge.service;

import com.aluminium.online_judge.model.User;
import com.aluminium.online_judge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccessService accessService;

    @Autowired
    private JwtUtils jwtUtils;

    public User getUserById(UUID id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseGet(User::new);
    }

    public UUID getUserIdFromAuth(Authentication authentication){
        return (UUID) authentication.getPrincipal();
    }

    public ResponseEntity<Map<String, Object>> getUserInfo(UUID userId) {
        User user;
        try {
            user = userRepository.findById(userId).orElseThrow(Exception::new);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(
                Map.of("username", user.getUsername(),
                        "email", user.getEmail(),
                        "created_at", user.getCreatedAt())
                , HttpStatus.OK);
    }

    public User createUser(String username, String email, String encryptedPassword) {
        User user = new User(username, email, encryptedPassword);
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) throws Exception {
        return userRepository.findByEmail(email).orElseThrow(Exception::new);
    }
}
