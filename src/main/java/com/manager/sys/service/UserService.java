package com.manager.sys.service;

import com.manager.common.PageView;
import com.manager.service.base.BaseService;
import com.manager.sys.model.User;

public interface UserService extends BaseService<User>{
	
	
	public User countUser(User user);
	
	/**
	 * @param account
	 * @param pageView
	 * @return
	 */
	public PageView queryNoMatch(User user,PageView pageView);

}
