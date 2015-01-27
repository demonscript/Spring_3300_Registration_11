package com.demon.registeration.dao;

import java.util.List;

import com.demon.registeration.entity.User;

public interface UserDao {
	
	public void save(User u);
	public boolean checkUserExistsWithName(String username);
	public List<User> getUsers();
	public User loadUser(int id);
}
