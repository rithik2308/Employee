package com.gemini.employ.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gemini.employ.entities.UserInfo;
import com.gemini.employ.repositories.UserInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserInfoService {
	@Autowired
	private UserInfoRepository repository;
	@Autowired
	private PasswordEncoder passwordencoder;
	public String addUser(UserInfo userInfo) {
		log.info("Adding an user into the database");
		userInfo.setPassword(passwordencoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "User added";
	}
}
