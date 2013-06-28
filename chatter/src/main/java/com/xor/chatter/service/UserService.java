package com.xor.chatter.service;

import com.xor.chatter.form.User;

public interface UserService {

	public Integer createUser(User user);
	public void addFriend(Integer uid,User friend);
	public User getUserByID(Integer uid);
	public User getUserByUsernameAndPassword(String username,String password);
	
}
