package com.sunbeam.dao;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.entities.User;

public interface UserDao {

	User signIn(String email,String pwd);
	
	String signUp(User newUser) ;
	//update user details 
	String updateUserDetails(User user) ;
	//delete user
	String deleteUser(Long userId) ;
	//list all users 
	List<User> listUsers() ;
	//get user details
	User getUserDetails(Long userId) ;
	
}
