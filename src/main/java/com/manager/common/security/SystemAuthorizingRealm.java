package com.manager.common.security;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.manager.sys.dao.UserDao;
import com.manager.sys.service.UserService;



public class SystemAuthorizingRealm extends AuthorizingRealm {
	
	private static final Logger log = LoggerFactory.getLogger(SystemAuthorizingRealm.class);
	
	@Autowired
	private UserDao userDao;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String user = (String) principals.getPrimaryPrincipal();
		
		SimpleAuthorizationInfo  info = new SimpleAuthorizationInfo();
		//info.setRoles(userService.getById(user));//添加用户角色信息
	 
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		 
		return null;
	}

	
 

}