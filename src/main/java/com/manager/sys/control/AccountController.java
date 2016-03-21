package com.manager.sys.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.control.base.BaseController;

@Controller
public class AccountController extends BaseController {
	
	
	@RequestMapping(value="/queryAccount",method=RequestMethod.POST)
	public String queryAccount(HttpServletRequest request,HttpServletResponse response){
		
		
		
		return "";
	}

}
