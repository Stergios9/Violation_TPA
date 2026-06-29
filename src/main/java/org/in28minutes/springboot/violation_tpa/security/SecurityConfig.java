package org.in28minutes.springboot.violation_tpa.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Value("${security.bcrypt.strength:12}")
    private int strength;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(strength);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)  throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login",
                                "/css/**",
                                "/js/**",
                                "/images/**")
                        .permitAll()

                        // TO /home είναι προσβάσιμο από -->
                        .requestMatchers("/home").hasAnyRole("USER", "ADMIN", "SUPER_ADMIN")

                        // ADMIN level
                        .requestMatchers("/admin/**").hasAnyRole("ADMIN", "SUPER_ADMIN")

                        // SUPER ADMIN only
                        .requestMatchers("/super/**").hasRole("SUPER_ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true) //μετα από επιτυχημένο login πηγαίνει εδώ
                        .failureUrl("/login?error")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                        .permitAll()
                );

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("user1")
//                .password("123")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User
//                .withDefaultPasswordEncoder()
//                .username("admin")
//                .password("123")
//                .roles("ADMIN","USER")
//                .build();
//
//        UserDetails superAdmin = User
//                .withDefaultPasswordEncoder()
//                .username("superAdmin")
//                .password("123")
//                .roles("SUPER_ADMIN","ADMIN","USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1,admin,superAdmin);
//    }
}


