package com.manager.common.security;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.manager.common.exceptions.LockedAccountException;
import com.manager.common.exceptions.UnknownAccountException;
import com.manager.common.exceptions.UsernamePasswordException;
import com.manager.sys.dao.UserDao;
import com.manager.sys.model.User;
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
	 
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		//1:登录查询是否存在此账号信息；
		//2：验证用户名密码是否正取；
		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
		int result = userDao.findByUsername(token.getUsername());
		if(result == 0){////标准用户账号信息不存在
			throw new UnknownAccountException();
		}else{//表示改账号用户处存在
			User account = new User();
			account.setLogin_name(String.valueOf(token.getUsername()));
			account.setPassword(String.valueOf(token.getPassword()));
			User user = userDao.userLogin(account);
			if(user == null){
				 throw new UsernamePasswordException();
			}else{
				/*if(!user.isLocked()){
					throw new LockedAccountException();
				}*/
				return new SimpleAuthenticationInfo(user.getLogin_name(),user.getPassword(),getName());
			}
		}
		 
	}
 
 

}