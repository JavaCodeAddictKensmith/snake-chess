package com.example.jwtbyChatbot;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "7e7e77r7r7f77f7f6u383jend99r99f";

    public String generateToken(String username, String role) {
        return JWT.create()
                .withSubject(username)
                .withClaim("role", role)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .sign(Algorithm.HMAC256(SECRET.getBytes()));
    }

    public DecodedJWT validateToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET.getBytes())).build().verify(token);
    }
}
