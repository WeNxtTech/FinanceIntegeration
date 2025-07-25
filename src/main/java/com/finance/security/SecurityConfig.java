package com.finance.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//import com.wenxt.claims.security.UserInfoService; 

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig { 
//
	@Autowired
	private JwtAuthFilter authFilter; 
//	
//	@Bean(name = "jasyptStringEncryptor")
//    public StringEncryptor stringEncryptor() {
//        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
//        encryptor.setPassword("yourEncryptionPassword"); // Set your encryption password here
//        return encryptor;
//    }
//
//	// User Creation 
////	@Bean
////	public UserDetailsService userDetailsService() { 
////		return new UserInfoService(); 
////	} 
//
//	// Configuring HttpSecurity 
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
////		return http.csrf().disable() 
////				.authorizeHttpRequests() 
////				.requestMatchers("/auth/generateToken").permitAll()
////				.and()
////				.authorizeHttpRequests() 
////				.requestMatchers("/auth/addNewUser").permitAll()
////				.and()
////				.authorizeHttpRequests() 
////				.requestMatchers("/swagger-ui/**").permitAll()
////				.and()
////				.authorizeHttpRequests() 
////				.requestMatchers("/v3/**").permitAll()
////				.and()
////				.authorizeHttpRequests() 
////				.requestMatchers("/auth/**").permitAll()
////				.and()
////				.authorizeHttpRequests().requestMatchers("/common/**").authenticated() 
////				.and()
////				.sessionManagement() 
////				.sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
////				.and() 
////				.authenticationProvider(authenticationProvider()) 
////				.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class) 
////				.build(); 
//		
//		return http
//				.csrf().disable()
//			.authorizeHttpRequests() 
//			.requestMatchers("/auth/generateToken").permitAll()
//			.and()
//			.authorizeHttpRequests()
//         .requestMatchers("/common/**").authenticated()  // All other endpoints require authentication
//         .and()
//         .sessionManagement() 
//			.sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
//			.and() 
//			.authenticationProvider(authenticationProvider()) 
//			.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class) 
//			.build(); 
//	} 
//	
////	 @Bean
////	    public UserDetailsService userDetailsService() {
////	        // Create users in-memory with roles for demo purposes
////	        return new InMemoryUserDetailsManager(
////	            User.withUsername("admin")
////	                .password("admin")
////	                .build()
////	        );
////	    }
//	
//	@Bean
//	public UserDetailsService userDetailsService() { 
//		return new UserInfoService(); 
//	} 
//
//	// Password Encoding 
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return NoOpPasswordEncoder.getInstance(); // Jasypt handles encryption and decryption
////    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        CustomAuthenticationProvider authenticationProvider = new CustomAuthenticationProvider(userDetailsService());
//        return authenticationProvider;
//    }
//
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception { 
//		return config.getAuthenticationManager(); 
//	} 
//


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF for APIs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/generateToken","/actuator/prometheus","/actuator/**").permitAll() // Allow JWT generation API
                        .anyRequest().authenticated()                // Secure other endpoints
                )
                .authenticationProvider(staticAuthenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }

    @Bean
    public AuthenticationProvider staticAuthenticationProvider() {
        return new StaticAuthenticationProvider();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // No encoding for static password
    }

    private static class StaticAuthenticationProvider implements AuthenticationProvider {

        private static final String STATIC_USERNAME = "admin";
        private static final String STATIC_PASSWORD = "admin";

        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {
            String username = authentication.getName();
            String password = authentication.getCredentials().toString();

            if (STATIC_USERNAME.equals(username) && STATIC_PASSWORD.equals(password)) {
                UserDetails user = new User(username, password, Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
                return new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
            }
            throw new AuthenticationServiceException("Invalid username or password");
        }

        @Override
        public boolean supports(Class<?> authentication) {
            return authentication.equals(org.springframework.security.authentication.UsernamePasswordAuthenticationToken.class);
        }
    }

} 

