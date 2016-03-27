package com.manager.sys.control;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.common.view.PageView;
import com.manager.control.base.BaseController;
import com.manager.sys.model.Personal;
import com.manager.sys.service.AccountService;

@Controller
public class AccountController extends BaseController {
	
	@Autowired
	private AccountService accountService = null;
	
	@RequestMapping(value="/queryAccount")
	@ResponseBody
	public PageView queryAccount(HttpServletRequest request,HttpServletResponse response){
		PageView<Personal> page = new PageView<Personal>();
		String sEcho = request.getParameter("draw");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		page.setData(accountService.queryAccount(Integer.parseInt(start),Integer.parseInt(length),0));
		page.setDraw(Integer.parseInt(sEcho));
		page.setRecordsFiltered(accountService.queryPersonalLimitCount());
		page.setRecordsTotal(accountService.queryPersonalLimitCount());
		return page;
	}

}
