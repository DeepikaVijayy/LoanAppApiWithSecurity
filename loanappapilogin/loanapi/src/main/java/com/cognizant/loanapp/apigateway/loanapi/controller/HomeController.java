package com.cognizant.loanapp.apigateway.loanapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loanapp.apigateway.loanapi.entity.AuthenticationResponse;
import com.cognizant.loanapp.apigateway.loanapi.entity.Users;
import com.cognizant.loanapp.apigateway.loanapi.service.JwtUtil;
import com.cognizant.loanapp.apigateway.loanapi.service.MyuserDetailsService;

@RestController
@RequestMapping("/loanapp")
public class HomeController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyuserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/")
	public String home() {
		return "Welcome";
	}
	
	
	@PostMapping("/user")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Users user)throws Exception
	{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		} catch (BadCredentialsException e) {
		
			throw new Exception("Incorrect username or password" , e);
		}
		final UserDetails userdetails = userDetailsService.loadUserByUsername(user.getUserName());
		
		final String jwt = jwtUtil.generateToken(userdetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
