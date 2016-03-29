package com.manager.sys.control;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.common.view.JsonView;
import com.manager.common.view.PageView;
import com.manager.control.base.BaseController;
import com.manager.sys.model.Enterprise;
import com.manager.sys.model.Personal;
import com.manager.sys.service.AccountService;

@Controller
public class AccountController extends BaseController {
	
	@Autowired
	private AccountService accountService = null;
	
	@RequestMapping(value="/queryAccount")
	@ResponseBody
	public PageView<Personal> queryAccount(HttpServletRequest request,HttpServletResponse response){
		PageView<Personal> page = new PageView<Personal>();
		String sEcho = request.getParameter("draw");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		int userType = Integer.parseInt(request.getParameter("userType"));
		
		page.setData(accountService.queryAccount(Integer.parseInt(start),Integer.parseInt(length),userType));
		page.setDraw(Integer.parseInt(sEcho));
		page.setRecordsFiltered(accountService.queryPersonalLimitCount(userType));
		page.setRecordsTotal(accountService.queryPersonalLimitCount(userType));
		return page;
	}
	
	@RequestMapping(value="/auditAccount")
	@ResponseBody
	public JsonView auditAccount(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		int auditStatus = Integer.parseInt(request.getParameter("auditStatus"));
		int result =accountService.auditAccount(accountId, auditStatus);
		if(result == 0){
			json.setMessage("审核用户失败");
			json.setMessageCode("10001");
			json.setSuccess(false);
		}else{
			json.setMessage("审核用户成功");
			json.setMessageCode("10001");
		}
		return json;
	}
	
	@RequestMapping(value="/forbiddenAccount")
	@ResponseBody
	public JsonView forbiddenAccount(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		int accountId  = Integer.parseInt(request.getParameter("accountId"));
		int result = accountService.forbiddenAccount(accountId);
		if(result == 0){
			json.setMessage("禁用用户失败");
			json.setMessageCode("10001");
			json.setSuccess(false);
		}else{
			json.setMessage("禁用用户成功");
			json.setMessageCode("10001");
		}
		return json; 
	}
	
	@RequestMapping(value="/getPersonal")
	@ResponseBody
	public Personal getAccount(HttpServletRequest request,HttpServletResponse response){
		String accountId = request.getParameter("accountId"); 
		return accountService.queryPersonalDetailed(Integer.parseInt(accountId));
	}
	
	@RequestMapping(value="/getEnterprise")
	@ResponseBody
	public Enterprise getEnterprise(HttpServletRequest request,HttpServletResponse response){
		String accountId = request.getParameter("accountId"); 
		return accountService.queryEnterpriseDetailed(Integer.parseInt(accountId));
	}
 
	@RequestMapping(value="/queryEnterprise")
	@ResponseBody
	public PageView<Enterprise> queryEnterprise(HttpServletRequest request,HttpServletResponse response){
		PageView<Enterprise> page = new PageView<Enterprise>();
		String sEcho = request.getParameter("draw");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		int userInfo = Integer.parseInt(request.getParameter("userinfo"));
		page.setData(accountService.queryEnterprise(Integer.parseInt(start),Integer.parseInt(length),userInfo));
		page.setDraw(Integer.parseInt(sEcho));
		page.setRecordsFiltered(accountService.queryEnterpriseLimitCount(userInfo));
		page.setRecordsTotal(accountService.queryEnterpriseLimitCount(userInfo)); 
		return page;
	}

}
