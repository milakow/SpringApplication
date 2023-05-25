package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;


@Profile("prod")
@Configuration
@EnableWebSecurity
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/hello").permitAll()
                        .requestMatchers(HttpMethod.GET).authenticated()
//                        .requestMatchers(HttpMethod.POST).authenticated()
//                        .requestMatchers(HttpMethod.PUT).authenticated()
//                        .requestMatchers(HttpMethod.PATCH).authenticated()
                        .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.PUT).hasAnyRole("ADMIN","USER")
                        .requestMatchers(HttpMethod.PATCH).hasAnyRole("ADMIN","USER")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("user")
                .password("{noop}user")
                .build();
        UserDetails user1 = User.withUsername("user1")
                .password("{noop}user1")
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, user1, admin);


    }
}
