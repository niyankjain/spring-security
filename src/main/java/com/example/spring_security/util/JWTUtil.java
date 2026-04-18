package com.example.spring_security.util;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;

public class JWTUtil {

  private static final long EXPIRATION_TIME = 1000*60*60;
  private static final String SECRET_KEY = "my-super-secret-key-that-is-long-enough-1234567890!@#";
  private static final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

  public static String generateToken(String username) {
    return Jwts.builder()
        .subject(username)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
  }

  public static String extractUsername(String token) {
    return extractToken(token).getSubject();
  }

  private static Claims extractToken(String token) {
    return Jwts.parser()
        .setSigningKey(key)
        .build()
        .parseClaimsJws(token)
        .getBody();
  }

  public static boolean isExpiredToken(String token) {
    return extractToken(token).getExpiration().before(new Date());
  }
}
