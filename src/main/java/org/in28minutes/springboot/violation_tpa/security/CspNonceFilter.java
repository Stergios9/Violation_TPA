package org.in28minutes.springboot.violation_tpa.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;


public class CspNonceFilter extends OncePerRequestFilter {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String nonce = generateNonce();
        request.setAttribute("cspNonce", nonce);


        response.setHeader("Content-Security-Policy",
                "default-src 'self'; " +
                        "script-src 'self' 'nonce-" + nonce + "'; " +
                        "style-src 'self' https://cdn.jsdelivr.net 'unsafe-inline'; " +
                        "font-src 'self' https://fonts.gstatic.com data:; " +
                        "img-src 'self' data: https://proteas-hub.hndgs.mil.gr https://ows.terrestris.de; " +
                        "frame-src 'self'; " +
                        "object-src 'none'; " +
                        "base-uri 'self'; " +
                        "form-action 'self'; " +
                        "connect-src 'self' https://proteas-hub.hndgs.mil.gr; " +
                        "frame-ancestors 'self';"
        );

        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
        response.setHeader("Pragma", "no-cache"); // για παλιούς browsers
        response.setDateHeader("Expires", 0);

        filterChain.doFilter(request, response);
    }


    private String generateNonce() {
        byte[] nonceBytes = new byte[32]; // 256bit
        SECURE_RANDOM.nextBytes(nonceBytes);
        return Base64.getEncoder().encodeToString(nonceBytes);
    }

}