package edu.classtrack.config;

import edu.classtrack.security.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {

    private Logger logger = LoggerFactory.getLogger(UserConfig.class);
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles(Role.ADMIN.name())
                .build();
        UserDetails faculty = User.builder()
                .username("faculty")
                .password(passwordEncoder().encode("faculty"))
                .roles(Role.FACULTY.name())
                .build();
        UserDetails student = User.builder()
                .username("student")
                .password(passwordEncoder().encode("student"))
                .roles(Role.STUDENT.name())
                .build();
        return new InMemoryUserDetailsManager(admin,faculty,student);
    }
}
