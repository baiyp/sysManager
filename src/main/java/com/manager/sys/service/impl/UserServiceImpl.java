package com.manager.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.sys.dao.UserDao;
import com.manager.sys.model.User;
import com.manager.sys.service.UserService;

@Service("userService")
public class UserServiceImpl  implements UserService{

	
	@Autowired
	private UserDao userDao;
	

	@Override
	public List<User> queryAll(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(User t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(String id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<String> arrId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(User t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User userLogin(String userName, String password) {
		 
		return null;
	}

 

 

}
