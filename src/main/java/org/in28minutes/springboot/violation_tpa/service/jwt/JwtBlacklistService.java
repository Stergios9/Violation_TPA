package org.in28minutes.springboot.violation_tpa.service.jwt;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class JwtBlacklistService {

    // token -> expiresAt
    private final Map<String, Instant> blacklist = new ConcurrentHashMap<>();

    public void blacklist(String token, Instant expiresAt) {
        blacklist.putIfAbsent(token, expiresAt);
    }

    public boolean isBlacklisted(String token) {
        Instant exp = blacklist.get(token);
        if (exp == null) return false;

        Instant now = Instant.now();
        if (exp.isAfter(now)) return true;

        blacklist.remove(token, exp);
        return false;
    }


    public void cleanupExpired() {
        Instant now = Instant.now();
        blacklist.entrySet().removeIf(e -> e.getValue().isBefore(now));
    }
}