package com.demon.registeration.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.demon.registeration.entity.User;
import com.demon.registeration.service.UserManager;
import com.demon.registeration.service.impl.UserManagerImpl;
import com.demon.registeration.vo.UserInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component("u")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven{
	
	UserInfo userInfo = new UserInfo();
	
	List<User> users;
	
	User user;
	
	
	
	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public String list() {
		this.users = um.getUsers();
		System.out.println("users"+users.size());
		return "list";
	}
	
	public String load() {
		this.user = this.um.loadUser(userInfo.getId());
		return "getUserById";
	}
	
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	@Resource
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	UserManager um;
	
	public UserAction() {
		ApplicationContext cxt = new ClassPathXmlApplicationContext("beans.xml");
		um = (UserManager) cxt.getBean("UserManager"); 
	}
	
	public UserManager getUm() {
		return um;
	}
	
	@Resource(name="UserManager")
	public void setUm(UserManager um) {
		this.um = um;
	}

	@Override
	public String execute() throws Exception {
		User u = new User();
		u.setUsername(userInfo.getUsername());
		u.setPassword(userInfo.getPassword());
		if(um.exists(u)) {
			return "fail";
		}
		um.add(u);
		return "success";
	}
	
	@Override
	public Object getModel() {
		return userInfo;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
}
