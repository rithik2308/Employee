package com.gemini.employ.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gemini.employ.entities.UserInfo;
import com.gemini.employ.entities.UserInfoUserDetails;
import com.gemini.employ.repositories.UserInfoRepository;
@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo =repository.findByName(username);
		return userInfo.map(UserInfoUserDetails::new).orElseThrow(()->new UsernameNotFoundException("User not found "+username));
	}

}
