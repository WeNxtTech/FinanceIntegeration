package com.finance.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/generateToken")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		try {
		Authentication authenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
				authRequest.getPassword());

		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		if (authentication.isAuthenticated()) {
			String token = jwtService.generateToken(authRequest);
			return token;
		} else {
			throw new AuthenticationServiceException("Invalid username or password");
		}
		}catch(Exception e) {
			e.printStackTrace();
			return e.getLocalizedMessage();
		}
	}

}
