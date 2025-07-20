package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.entities.User;

public interface UserService {

	List<User> listUsers();

	String deleteUser(Long userId);

	String addUser(User user);

	User getUserDetails(Long userId);

	String updateUserDetails(Long userId, String password, LocalDate newDob);

}
