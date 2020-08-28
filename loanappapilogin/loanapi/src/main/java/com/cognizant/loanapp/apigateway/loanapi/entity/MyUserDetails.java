package com.cognizant.loanapp.apigateway.loanapi.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	// Just returning the user name passed by spring security
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;
	
	public MyUserDetails(Users users) {
		this.userName = users.getUserName();
		this.password = users.getPassword();
		this.authorities = Arrays.stream(users.getRoles().split(","))
				       .map(SimpleGrantedAuthority :: new)
				       .collect(Collectors.toList());
	}
	
	public MyUserDetails() {		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
