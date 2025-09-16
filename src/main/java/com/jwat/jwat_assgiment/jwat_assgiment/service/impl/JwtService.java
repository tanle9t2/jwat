package com.jwat.jwat_assgiment.jwat_assgiment.service.impl;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;

import java.util.Map;

import java.util.function.Function;

@Service
public class JwtService {
    @Value(value = "${app.security.jwt.secret-key}")
    private String SECRET_KEY;

//    @Value(value = "${app.token.expirationTime}")
    private int expirationTime;

//    @Value(value = "${app.token.refreshTime}")
    private int refreshTime;


    public String extractUserId(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractUsername(String token) {
        return extractClaim(token, (claims -> claims.get("username", String.class)));
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    private String generateToken(Map<String, Object> extraClaims, String username, Date expirationTime) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expirationTime)
                .signWith(getSignInKey())
                .compact();
    }


    public String extractToken(String token) {
        return token.split(" ")[1];
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }


    public Boolean validateToken(String token) {
        if(token == null || token.trim().isEmpty()) return false;

        String username = extractUsername(token);
        return !(username == null || username.isEmpty() || isTokenExpired(token));
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}