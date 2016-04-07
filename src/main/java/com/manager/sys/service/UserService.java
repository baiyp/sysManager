package com.manager.sys.service;
 
import com.manager.service.base.BaseService;
import com.manager.sys.model.User;

public interface UserService extends BaseService<User>{
	
	 
	
	
	public User userLogin(String userName,String password);
	 
 

}
