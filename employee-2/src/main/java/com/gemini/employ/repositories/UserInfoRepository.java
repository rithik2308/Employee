package com.gemini.employ.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gemini.employ.entities.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

	Optional<UserInfo> findByName(String username);

}
