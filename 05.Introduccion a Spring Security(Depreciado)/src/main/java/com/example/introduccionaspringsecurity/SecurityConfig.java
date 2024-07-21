package com.example.introduccionaspringsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/*
DEPRECIADO
 */

/*
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
*/

@Configuration
public class SecurityConfig {

/*
public class SecurityConfig implements WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        var userDetailsService = new InMemoryUserDetailsManager();
        UserDetails user1 = User.builder()
                .username("postman")
                .password(this.passwordEncoder().encode("admin)"))
                .authorities("read")
                .build();

        UserDetails user2 = User.builder()
                .username("browser")
                .password(this.passwordEncoder().encode("admin)"))
                .authorities("read")
                .build();

        userDetailsService.createUser(user1);
        userDetailsService.createUser(user2);
        return userDetailsService;
    }

        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
 */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/users/login").permitAll()
                        .requestMatchers("/users/register").permitAll()
                        .requestMatchers("files/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "books").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "books").hasAnyAuthority("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "books").hasAnyAuthority("ADMIN")
                        .anyRequest().authenticated()
                ).build();

    }

}
