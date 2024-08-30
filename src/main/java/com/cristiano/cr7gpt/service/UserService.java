package com.cristiano.cr7gpt.service;

import java.util.List;

import com.cristiano.cr7gpt.entities.User;
import com.cristiano.cr7gpt.exception.UserException;



public interface UserService {
	
	 	public User findUserById(Long userId) throws UserException;
		
		public User findUserProfileByJwt(String jwt) throws UserException;
		
		public User findUserByEmail(String email) throws UserException;
		
		public List<User> findAllUsers();

}