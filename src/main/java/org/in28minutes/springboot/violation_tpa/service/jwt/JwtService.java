package org.in28minutes.springboot.violation_tpa.service.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    // *** Create SecretKey Manual  ***

    // from https://jwtsecretkeygenerator.com/
    // Standard Secret Key for HMAC SHA-256 (HS256) algorithm
    private static final String SECRET = "841svncchKs0ehV9vH16fVX6s9N4OJkhUthPfZGlx1T";

    // Enhanced Secret Key for HMAC SHA-256 (HS256) algorithm
//    private static final String TOKEN_PREFIX = "m7RN%xAsDDz[nkC|F_-h7VNnU^!Ski0]|f5W<g/JOFc";

    private String secretKey;

    public JwtService() {
        secretKey = generateSecretKey();
    }

    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiration
                .signWith(getKey(),SignatureAlgorithm.HS256)
                .compact();
    }

    // Generate secretKey not Manuall
    public String generateSecretKey(){
        try{
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();
            System.out.println("Generated Secret Key: " + secretKey.toString());
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating secret key", e);
        }
    }

//    private Key getKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
//        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
//    }
    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }



    // ********* Youtube *********
//    private final String SECRET = "mySecretKeyMySecretKeyMySecretKey";
//
//    public String generateToken(UserDetails user) {
//
//        return Jwts.builder()
//                .setSubject(user.getUsername())
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
//                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()))
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//
//        return Jwts.parserBuilder()
//                .setSigningKey(SECRET.getBytes())
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    public boolean isValid(String token, UserDetails user) {
//
//        String username = extractUsername(token);
//        return username.equals(user.getUsername());
//    }
}