package org.in28minutes.springboot.violation_tpa.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.in28minutes.springboot.violation_tpa.security.CspNonceFilter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    public SecurityConfig(UserDetailsService userDetailsService, CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.userDetailsService = userDetailsService;
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

//    @Value("${security.bcrypt.strength:12}")
//    private int strength;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());

        return provider;

    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) {
        return config.getAuthenticationManager();
    }
    @Bean
    public CspNonceFilter cspNonceFilter() {
        return new CspNonceFilter();
    }


    // With formLogin and InMemoryUserDetailsManager
    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http,
            CspNonceFilter cspNonceFilter)  throws Exception {

        CookieCsrfTokenRepository csrfRepo =
                CookieCsrfTokenRepository.withHttpOnlyFalse();

        csrfRepo.setCookieName("XSRF-TOKEN");
        csrfRepo.setHeaderName("X-XSRF-TOKEN");
        csrfRepo.setCookiePath("/");

        csrfRepo.setCookieCustomizer(cookie ->
                cookie.sameSite("Strict")
                        .secure(true)
        );

        http
                .addFilterBefore(cspNonceFilter, CsrfFilter.class)
//                .csrf(csrf -> csrf.disable())
                .csrf(csrf -> csrf
                        .csrfTokenRepository(csrfRepo)
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/checkAuthority/**",
                                "/login",
                                "/error",
                                "/errorPage",
                                "/register",
                                "/css/**",
                                "/js/**",
                                "/images/**"
                        ).permitAll()

                        .requestMatchers("/turkey-admin/**").hasAnyRole("ADMIN", "SUPER_ADMIN")
                        .requestMatchers("/turkey-user-page/**").hasAnyRole("ADMIN", "SUPER_ADMIN","USER")
                        .requestMatchers("/turkey-super/**").hasRole("SUPER_ADMIN")

                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(customAuthenticationSuccessHandler)
//                        .defaultSuccessUrl("/home", true) //μετα από επιτυχημένο login πηγαίνει εδώ
                        .failureUrl("/login?error")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .clearAuthentication(true)
                        .permitAll()
                );

        secureHeaders(http);
        return http.build();
    }

    private void secureHeaders(HttpSecurity http) throws Exception {
        http.headers(headers -> headers
                .cacheControl(Customizer.withDefaults())
                .contentTypeOptions(Customizer.withDefaults())
                .frameOptions(frame -> frame.sameOrigin())
                .httpStrictTransportSecurity(hsts -> hsts
                        .includeSubDomains(true)
                        .preload(true)
                        .maxAgeInSeconds(31536000)
                )
                .referrerPolicy(referrer -> referrer
                        .policy(org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter.ReferrerPolicy.NO_REFERRER)
                )
                .addHeaderWriter((request, response) -> {
                    response.setHeader("Permissions-Policy", "geolocation=(), microphone=(), camera=()");
                })
        );
    }

    //    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http
//                .csrf(csrf -> csrf.disable())
//
//                .sessionManagement(session ->
//                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//
//                .authorizeHttpRequests(auth -> auth
//
//                        .requestMatchers(
//                                "/login",
//                                "/register",
//                                "/css/**",
//                                "/js/**",
//                                "/images/**"
//                        ).permitAll()
//
//                        .requestMatchers("/home")
//                        .hasAnyRole("USER", "ADMIN", "SUPER_ADMIN")
//
//                        .requestMatchers("/admin/**")
//                        .hasAnyRole("ADMIN", "SUPER_ADMIN")
//
//                        .requestMatchers("/super/**")
//                        .hasRole("SUPER_ADMIN")
//
//                        .anyRequest().authenticated()
//                );
//
//        return http.build();
//    }

}


