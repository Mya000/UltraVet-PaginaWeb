package com.ultravet.veterinaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. RUTAS
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/js/**", "/images/**", "/favicon.ico").permitAll()
                .requestMatchers("/", "/servicios", "/adopcion").permitAll()
                .requestMatchers("/login", "/registro", "/citas", "/citas/**", "/adoptar").permitAll()
                // Admin se valida con AdminSessionInterceptor porque el login usa sesion propia.
                .requestMatchers("/admin/**", "/admin").permitAll()
                .anyRequest().permitAll()
            )

            // 2. CSRF
            // Los formularios actuales usan sesion HTTP propia; con CSRF activo faltarian tokens.
            .csrf(csrf -> csrf.disable())

            // 3. LOGOUT
            // Spring Security invalida la sesion cuando el usuario entra a /logout.
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/")
                .permitAll()
            )

            // 4. ACCESO DENEGADO
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint((request, response, authException) -> {
                    response.sendRedirect(request.getContextPath() + "/");
                })
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    response.sendRedirect(request.getContextPath() + "/");
                })
            );

        return http.build();
    }
}
