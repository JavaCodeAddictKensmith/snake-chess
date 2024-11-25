package com.kensmith.repository;

import com.kensmith.entity.UserAccountToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<UserAccountToken, Long> {


    Optional<UserAccountToken> findByConfirmationToken(String confirmationToken);

    Optional<UserAccountToken> findByUserId(Long id);

}
