package com.manager.sys.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.control.base.BaseController;
import com.manager.sys.model.User;
import com.manager.sys.service.UserService;

@Controller
public class UserController extends BaseController{
	
	
	@Autowired
	private UserService accountService = null;
	
	
	@RequestMapping(value="/userLogin")
	@ResponseBody
	public String loginUser(HttpServletRequest request,HttpServletResponse response) {
		 
		User user = new User();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		user.setLogin_name(userName);
		user.setPassword(password);
		User user1 = accountService.countUser(user);
		
		if(user1 == null){//登录错误
			return "{\"result\":\"1\"}";
		}
		//登录成功进入主页面
		return "{\"result\":\"2\"}";
	}

	
	
	
	
	 
	
  

}
