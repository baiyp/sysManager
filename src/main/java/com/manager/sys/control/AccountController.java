package com.manager.sys.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.common.view.JsonView;
import com.manager.control.base.BaseController;
import com.manager.sys.service.AccountService;

@Controller
public class AccountController extends BaseController {
	
	@Autowired
	private AccountService accountService = null;
	
	@RequestMapping(value="/queryAccount")
	public JsonView queryAccount(HttpServletRequest request,HttpServletResponse response){
		
		String sEcho = request.getParameter("draw");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		/*int pageNo = Integer.parseInt(request.getParameter("displayStart"));
		int pageSize = Integer.parseInt(request.getParameter("iDisplayLength"));
		int accountType = Integer.parseInt(request.getParameter("accountType")); */
		accountService.queryAccount(1,15,0);
  
		return new JsonView();
	}

}
