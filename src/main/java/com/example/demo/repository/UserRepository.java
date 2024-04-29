package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT * FROM users where user_name =:username",nativeQuery = true)
	Optional<User> findByUsername(String username);

}
