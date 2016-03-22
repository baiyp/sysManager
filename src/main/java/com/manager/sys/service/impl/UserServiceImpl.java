package com.manager.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authc.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.common.PageView;
import com.manager.sys.dao.UserDao;
import com.manager.sys.model.User;
import com.manager.sys.service.UserService;

@Service("accountService")
public class UserServiceImpl  implements UserService{

	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public PageView query(PageView pageView, User t) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging",pageView);
		map.put("t",t);
		List<User> list = userDao.query(map);
		pageView.setRecords(list);
		return pageView;
	}

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
	public User countUser(User user) {
		return userDao.countAccount(user);
	}

	@Override
	public PageView queryNoMatch(User user, PageView pageView) {
		return null;
	}

	@Override
	public User userLogin(String userName, String password) {
		return userDao.userLogin(userName, password);
	}

}
