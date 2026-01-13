package com.linkedbear.spring6.cloud.user.service;

import com.linkedbear.spring6.cloud.user.dto.LoginDTO;
import com.linkedbear.spring6.cloud.user.dto.TokenDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Long expiration;

    public TokenDTO login(LoginDTO loginDTO) throws AuthenticationException {
        // 认证用户
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword())
        );

        // 生成JWT令牌
        String token = generateToken(authentication);

        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setAccessToken(token);
        tokenDTO.setTokenType("Bearer");
        tokenDTO.setExpiresIn(expiration);

        return tokenDTO;
    }

    private String generateToken(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        // 使用Base64解码密钥
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }
}
