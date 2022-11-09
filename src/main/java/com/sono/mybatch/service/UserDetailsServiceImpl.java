package com.sono.mybatch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sono.mybatch.repository.LoginRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	LoginRepository loginRepository;

	public UserDetails loadUserByUsername(String emailaddress) throws UsernameNotFoundException {

		var loginUser = loginRepository.findUserByEmailAddress(emailaddress);
		if (loginUser.isEmpty()) {
			throw new BadCredentialsException(String.format("emailAddress < %s > not found.", emailaddress));
		}

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		authorities.add(authority);
		UserDetails userDetails = (UserDetails) new User(loginUser.get().getEmailAddress(),
				loginUser.get().getPassword(), authorities);
		return userDetails;
	}
}
