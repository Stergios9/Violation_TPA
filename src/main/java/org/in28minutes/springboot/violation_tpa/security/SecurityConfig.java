package org.in28minutes.springboot.violation_tpa.security;

import org.in28minutes.springboot.violation_tpa.service.CustomUserDetailsService;
import org.in28minutes.springboot.violation_tpa.service.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login",
                                "/css/**",
                                "/js/**",
                                "/images/**")
                        .permitAll()

                        // USER level
                        .requestMatchers("/home").hasAnyRole("USER", "ADMIN", "SUPER_ADMIN")

                        // ADMIN level
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN", "SUPER_ADMIN")

                        // SUPER ADMIN only
                        .requestMatchers("/super/**").hasRole("SUPER_ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?error")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .permitAll()
                );

        return http.build();
    }
}


