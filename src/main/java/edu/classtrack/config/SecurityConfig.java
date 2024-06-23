package edu.classtrack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(
                        ar -> ar
                                .requestMatchers("/home","/h2-console/**","/actuator/**").permitAll()

                                .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                                .requestMatchers(HttpMethod.POST).hasRole("ADMIN")

                                .requestMatchers(
                                        new AntPathRequestMatcher("/api/courses/{variable}", "PUT"),
                                        new AntPathRequestMatcher("/api/faculty-attendances/{variable}", "PUT"),
                                        new AntPathRequestMatcher("/api/classschedules/{variable}", "PUT")
                                ).hasAnyRole("FACULTY","ADMIN")

                                .requestMatchers(HttpMethod.PUT).hasRole("ADMIN")

                                .requestMatchers(
                                        new AntPathRequestMatcher("/api/courses/**", "GET"),
                                        new AntPathRequestMatcher("/api/subjects/**", "GET")
                                ).hasAnyRole("STUDENT", "ADMIN", "FACULTY")

                                .requestMatchers(HttpMethod.GET).hasAnyRole("ADMIN", "FACULTY")

                                .requestMatchers("/**").hasRole("ADMIN")

                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .headers(h -> h.frameOptions(f -> f.sameOrigin()))
                .build();
    }

}
