package com.demon.registeration.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.demon.registeration.dao.UserDao;
import com.demon.registeration.entity.User;
//import com.demon.registeration.util.HibernateUtil;

@Component("UserDao")
public class UserDaoImpl implements UserDao {

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void save(User u) {
		
		hibernateTemplate.save(u);

	}

	@Override
	public boolean checkUserExistsWithName(String username) {
		// TODO Auto-generated method stub
		List<User> lu = (List<User>) hibernateTemplate.find("from User where username = '"+ username +"'");
		if(lu!=null && lu.size()>0) return true;
		return false;
	}

	@Override
	public List<User> getUsers() {
		return (List<User>)hibernateTemplate.find("from User");
	}

	@Override
	public User loadUser(int id) {
		return (User)this.hibernateTemplate.load(User.class, id);
	}
 
}
