package com.manager.sys.control;
 
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.manager.common.Base64;
import com.manager.common.view.JsonView;
import com.manager.control.base.BaseController;
import com.manager.sys.model.User;
import com.manager.sys.service.UserService;

@Controller
public class UserController extends BaseController{
	
	
	@Autowired
	private UserService userService = null;
	
	
	@RequestMapping(value="/userLogin")
	@ResponseBody
	public JsonView loginUser(HttpServletRequest request,HttpServletResponse response) {
		JsonView json = new JsonView();
		User user = new User();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		user.setLogin_name(userName);
		user.setPassword(password);
		User user1 = userService.countUser(user);
		 
		if(user1 == null){//登录错误
			json.setSuccess(false);
			json.setMessage("账号不存在或密码错误！");
			json.setMessageCode("0");
			return json;//"{\"result\":\"1\",\"m\":\""++"\"}";
		}
		 
		json.setMessageCode("2");
		//登录成功进入主页面
		return json;//"{\"result\":\"2\"}";
	}
 
}
