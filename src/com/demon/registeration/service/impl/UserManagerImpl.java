package com.demon.registeration.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.demon.registeration.dao.UserDao;
import com.demon.registeration.dao.impl.UserDaoImpl;
import com.demon.registeration.entity.User;
import com.demon.registeration.service.UserManager;
//import com.demon.registeration.util.HibernateUtil;

@Component("UserManager")
public class UserManagerImpl implements UserManager {
	
	private UserDao userDao;
	
	private List<User> users;
	
	@Override
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	public void setUsers(List<User> users) {
		this.users = userDao.getUsers();
	}

	public UserDao getUserDao() {
		return userDao;
	}
	
	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/* (non-Javadoc)
	 * @see com.demon.registeration.service.impl.UserManager#exists(com.demon.registeration.entity.User)
	 */
	@Override
	public boolean exists(User u) {
		return userDao.checkUserExistsWithName(u.getUsername());
				
		
	}
	
	/* (non-Javadoc)
	 * @see com.demon.registeration.service.impl.UserManager#add(com.demon.registeration.entity.User)
	 */
	@Override
	public boolean add(User u) {
		userDao.save(u);
		return true;
	}

	@Override
	public User loadUser(int id) {
		return this.userDao.loadUser(id);
	}
}
