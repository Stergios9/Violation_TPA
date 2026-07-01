package org.in28minutes.springboot.violation_tpa.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException {

        String redirectUrl = "/main-page";

        boolean isSuperAdmin = hasRole(authentication, "ROLE_SUPER_ADMIN");
        boolean isAdmin = hasRole(authentication, "ROLE_ADMIN");
        boolean isUser = hasRole(authentication, "ROLE_USER");

        if (isSuperAdmin) {
            redirectUrl = "/super-main-page";
        }
        else if (isAdmin) {
            redirectUrl = "/admin-main-page";
        }
        else if (isUser) {
            redirectUrl = "/main-page";
        }

        response.sendRedirect(redirectUrl);
    }

    private boolean hasRole(Authentication auth, String role) {
        return auth.getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals(role));
    }
}