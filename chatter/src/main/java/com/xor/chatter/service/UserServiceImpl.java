package com.xor.chatter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xor.chatter.dao.UserDAO;
import com.xor.chatter.form.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired private UserDAO userDAO;
	
	@Transactional
	public Integer createUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.createUser(user);
	}

	@Transactional
	public void addFriend(Integer uid, User friend) {
		// TODO Auto-generated method stub
		userDAO.addFriend(uid, friend);
	}

	@Transactional
	public User getUserByID(Integer uid) {
		// TODO Auto-generated method stub
		return userDAO.getUserByID(uid);
	}

	@Transactional
	public User getUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return userDAO.getUserByUsernameAndPassword(username, password);
	}

}
