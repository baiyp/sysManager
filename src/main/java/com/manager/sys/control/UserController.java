package com.manager.sys.control;
 
import java.io.UnsupportedEncodingException;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.manager.common.Base64;
import com.manager.common.Global;
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
		Subject subject = SecurityUtils.getSubject();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
		//token.setRememberMe(true);//添加记住我复选框时使用
		
		subject.login(token);
		
		if(subject.isAuthenticated()){//验证是否通过
			json.setMessageCode("2");
			Session session = subject.getSession(); 
			//session.setAttribute(Global.USER_SESSION,);
		}else{
			json.setSuccess(false);
			json.setMessage("账号不存在或密码错误！");
			json.setMessageCode("0");
			return json;
			
		}
		//登录成功进入主页面
		return json;
	}
 
}
