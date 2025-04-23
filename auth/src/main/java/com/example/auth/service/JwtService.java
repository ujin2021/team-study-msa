package com.example.auth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.key.private}")
    private Resource privateKeyResource;
    @Value("${jwt.key.public}")
    private Resource publicKeyResource;
    @Value("${jwt.expiration}")
    private long expiration;
    private PrivateKey getPrivateKey() throws Exception {
        try (InputStream is = privateKeyResource.getInputStream()) {
            // 1) PEM 전체를 문자열로 읽어서
            String pem = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            // 2) 헤더/푸터 제거, 개행·공백도 모두 제거
            String base64 = pem
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s+", "");

            // 3) Base64 디코딩 → DER 바이트
            byte[] der = Base64.getDecoder().decode(base64);

            // 4) PKCS#8 스펙으로 키 생성
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(der);
            return KeyFactory.getInstance("RSA").generatePrivate(spec);

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new IllegalStateException("Failed to load private key", e);
        }
    }
    public String generateToken(UserDetails userDetails) throws Exception {
        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("roles", userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).toList())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plusSeconds(expiration)))
                .signWith(getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }
}
