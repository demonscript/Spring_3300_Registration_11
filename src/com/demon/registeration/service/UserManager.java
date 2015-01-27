package com.demon.registeration.service;

import java.util.List;

import com.demon.registeration.entity.User;

public interface UserManager {

	public abstract boolean exists(User u);

	public abstract boolean add(User u);
	
	public List<User> getUsers();
	
	public User loadUser(int id);

}