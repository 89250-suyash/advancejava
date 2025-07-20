package com.sunbeam.service;

import java.time.LocalDate;
import java.util.List;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.User;
import com.sunbeam.entities.UserRole;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public UserServiceImpl() {
		// create dependency
		userDao = new UserDaoImpl();
	}
	
	@Override
	public List<User> listUsers() {
		//call dao's method
		return userDao.listUsers();
	}

	@Override
	public String deleteUser(Long userId) {		
		return userDao.deleteUser(userId);
	}

	@Override
	public String addUser(User user) {
		//set user status - available
		user.setStatus(true);
		//set role - voter
		user.setUserRole(UserRole.VOTER);		
		return userDao.signUp(user);
	}

	@Override
	public User getUserDetails(Long userId) {
		// TODO Auto-generated method stub
		return userDao.getUserDetails(userId);
	}

	@Override
	public String updateUserDetails(Long userId, String newPassword, 
			LocalDate newDob) {
		User user = userDao.getUserDetails(userId);
		if (user != null) {
			user.setPassword(newPassword);
			user.setDob(newDob);
			return userDao.updateUserDetails(user);
		}
		
		return  "Updated details";
	}
	
	
	
	
	
	
	
	
	
}
