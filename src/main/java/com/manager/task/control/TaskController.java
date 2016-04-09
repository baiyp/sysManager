/**
 * 
 */
package com.manager.task.control;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.common.view.JsonView;
import com.manager.common.view.PageView;
import com.manager.control.base.BaseController;
import com.manager.sys.model.Coworkinfo;
import com.manager.sys.model.Task;
import com.manager.task.service.TaskService;

/**
 * @author baiyp
 *
 */
@Controller
public class TaskController extends BaseController {
	
	
	@Autowired
	private TaskService taskService;

	/**
	 * 
	 */
	public TaskController() {
	}
	
	/**
	 * 获取任务信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/taskManage")
	@ResponseBody
	public PageView<Task> queryTaskManage(HttpServletRequest request,HttpServletResponse response){
		PageView<Task> page = super.getPageView(request, response);
		page.setData(taskService.queryTaskManage(page)); 
		page.setRecordsFiltered(page.getRecordsTotal());
		return page;
	}
	
	/** 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/suspendTask")
	@ResponseBody
	public JsonView suspendTask(HttpServletRequest request,HttpServletResponse response){
		 
		JsonView json = new JsonView();
		String taskId = request.getParameter("taskId");
		int result = taskService.updateTaskStatus(Integer.parseInt(taskId));
		if(result == 1){
			json.setMessage("终止任务信息成功");
			json.setMessageCode("10001");
		}else{
			json.setMessage("终止任务信息失败");
			json.setMessageCode("10001");
			json.setSuccess(false);
		}
		return json;
	}
	
	/**
	 * 获取任务信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/deleteTaskManage")
	@ResponseBody
	public JsonView deleteTaskManage(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		PageView<Task> page = new PageView<Task>();
		String taskId = request.getParameter("taskId");
		int result = taskService.deletTaskManage(Integer.parseInt(taskId));
		if(result == 1){
			json.setMessage("删除任务信息成功");
			json.setMessageCode("10001");
		}else{
			json.setMessage("删除任务信息失败");
			json.setMessageCode("10001");
			json.setSuccess(false);
		}
		return json;
	}
	
	/**
	 * 获取单个任务信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getTaskManage")
	@ResponseBody
	public Task getTaskManage(HttpServletRequest request,HttpServletResponse response){
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		return taskService.getTaskManage(taskId);
	}
	
	/**
	 * 审核公司上报的任务信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/auditTaskManage")
	@ResponseBody
	public JsonView auditTaskManage(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		int status = Integer.parseInt(request.getParameter("status"));
		int result = taskService.auditTaskManage(taskId, status);
		if(result == 0){
			json.setMessage("任务信息审核失败");
			json.setMessageCode("10001");
			json.setSuccess(false);
		}else{
			json.setMessage("任务信息审核成功");
			json.setMessageCode("10001");
		}
		return json;
	}
	
	/**
	 * 审核后的任务信息列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/taskAssign")
	@ResponseBody
	public PageView<Task> queryTaskAssign(HttpServletRequest request,HttpServletResponse response){
		PageView<Task> page = super.getPageView(request, response);
		page.setData(taskService.queryTaskAssign(page)); 
		page.setRecordsFiltered(page.getRecordsTotal()); 
		return page;
	}
	/**
	 * 获取单个任务认领的公司信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/queryTaskClaimEn")
	@ResponseBody
	public PageView<Task> queryTaskClaimEn(HttpServletRequest request,HttpServletResponse response){
		PageView page = super.getPageView(request, response);
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		page.setData(taskService.queryTaskClaimEn(page,taskId)); 
		page.setRecordsFiltered(page.getRecordsTotal()); 
		return page;
	}
	
	/**
	 * 分派任务给企业 一个任务只能分派给一个企业，不能进行拆分
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/assignEnterprise")
	@ResponseBody
	public JsonView AssignEnterprise(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		JsonView json = new JsonView();
		Coworkinfo work = new Coworkinfo();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		String remark = request.getParameter("remark");
		String contract_no = request.getParameter("contract_no");
		int work_days = Integer.parseInt(request.getParameter("work_days"));
		BigDecimal contract_sum = BigDecimal.valueOf(Double.parseDouble(request.getParameter("contract_sum")));
		String work_qualification = request.getParameter("work_qualification");
		String datepicker = request.getParameter("datepicker");
		Date d = dateFormat.parse(datepicker);
		work.setContract_no(contract_no);
		work.setContract_sum(contract_sum);
		work.setTask_id(taskId);
		work.setStart_time(d.getTime()/1000);
		work.setWork_qualification(work_qualification);
		work.setWork_days(work_days);
		work.setRemark(remark);
		work.setWork_contractor_id(accountId); 
		int result = taskService.AssignEnterprise(work); 
		if(result == 1){
			json.setMessage("任务分派成功");
			json.setMessageCode("10001"); 
		}else{
			json.setSuccess(false);
			json.setMessage("任务分派失败");
			json.setMessageCode("10001");
		}
		return json; 
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
