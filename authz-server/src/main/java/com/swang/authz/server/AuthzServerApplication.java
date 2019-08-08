package com.swang.authz.server;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableResourceServer
@SpringBootApplication
public class AuthzServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthzServerApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("tom").password(passwordEncoder().encode("12345")).roles("MONITOR").build());
        manager.createUser(User.withUsername("sam").password(passwordEncoder().encode("12345")).roles("USER").build());
        return manager;
    }
}
