package com.example.SmartGov.security;

import io.jsonwebtoken.security.Keys;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
@AllArgsConstructor
public class JwtSecretKeyGenerator {

    private final SecretKey secretKey;

    public JwtSecretKeyGenerator(){
        this.secretKey = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
        System.out.println(" Generated Secret Key: " + getSecretKeyString());
    }

    public SecretKey getSecretKey(){
        return secretKey;
    }

    public String getSecretKeyString(){
        return java.util.Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }


}
