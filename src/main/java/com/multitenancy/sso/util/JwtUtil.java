package com.multitenancy.sso.util;

import com.multitenancy.sso.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    public String generateToken(User user, String tenantId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("tenantId", tenantId);
        claims.put("roles", convertRolesToList(user));
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getLoggedInUserId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private List<String> convertRolesToList(User user) {
        return user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String extractTenantId(String token) {
        return extractAllClaims(token).get("tenantId", String.class);
    }

    public List<String> extractRoles(String token) {
        return extractAllClaims(token).get("roles", List.class);
    }

    public Boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}