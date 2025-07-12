package com.finance.security;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
//    private final PasswordEncoder passwordEncoder;
    @Autowired
    private StringEncryptor encryptor;

    public CustomAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
//        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException, BadCredentialsException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        
        System.out.println("UN: " + username + " PW: " + password);
        
//        UserDetails user = userDetailsService.loadUserByUsername(username);
        String pass = "admin";

        if (password.equals(pass) && username.equals("admin")) {
            // Authentication successful
            return new UsernamePasswordAuthenticationToken(username, password);
        } else {
            // Authentication failed
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}