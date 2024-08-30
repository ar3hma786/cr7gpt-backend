package com.cristiano.cr7gpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristiano.cr7gpt.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String username);

}
