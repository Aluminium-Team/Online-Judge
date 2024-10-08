package com.aluminium.online_judge.repository;

import com.aluminium.online_judge.model.Token;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    @Transactional
    @Modifying
    @Query("UPDATE Token t SET t.isLoggedIn = false WHERE t.jti = :jti")
    void logout(UUID jti);
}
