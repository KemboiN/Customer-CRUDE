package com.PrestoTechnologies.customerRegistration.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig
{
@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
  http.csrf(csrf->csrf.disable())
          .headers(headers->headers.frameOptions(frameOptions-> frameOptions.disable()))

          .authorizeHttpRequests(authorize->authorize
                  .requestMatchers("/swagger-ui/**","/v3/api-docs/**","/swagger-ui.html","/h2-console/**").permitAll()
                  .requestMatchers("/customers/**").permitAll()
                  .requestMatchers("User").hasRole("USER")
                  .anyRequest().authenticated()
          );
        return http.build();
    }

//    @Bean
//     public UserDetailsService userDetailsService()
//    {
//     var user=User.builder()
//                .username("user")
//                .password(passwordEncoder().encode("4321"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
