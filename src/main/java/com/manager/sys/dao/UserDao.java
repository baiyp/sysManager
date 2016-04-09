package com.manager.sys.dao;

import com.manager.dao.base.BaseDao;
import com.manager.sys.model.User;

public interface UserDao extends BaseDao<User>{
	 
	
	public User userLogin(User user);
	
	
	public User findByLoginUserByName(String loginUser);
	
	
	public int findByUsername(String username);
	

}
