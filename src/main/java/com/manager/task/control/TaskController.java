/**
 * 
 */
package com.manager.task.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.common.view.JsonView;
import com.manager.common.view.PageView;
import com.manager.control.base.BaseController;
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
		PageView<Task> page = new PageView<Task>();
		String sEcho = request.getParameter("draw");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		page.setData(taskService.queryTaskManage(Integer.parseInt(start),Integer.parseInt(length)));
		page.setDraw(Integer.parseInt(sEcho));
		page.setRecordsFiltered(taskService.queryTaskManageCount());
		page.setRecordsTotal(taskService.queryTaskManageCount());
		return page;
	}
	
	/**
	 * 获取单个任务信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/getTaskManage")
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
		PageView<Task> page = new PageView<Task>(); 
		String sEcho = request.getParameter("draw");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		page.setData(taskService.queryTaskAssign(Integer.parseInt(start),Integer.parseInt(length)));
		page.setDraw(Integer.parseInt(sEcho));
		page.setRecordsFiltered(taskService.queryTaskAssignCount());
		page.setRecordsTotal(taskService.queryTaskAssignCount());
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
		PageView<Task> page = new PageView<Task>(); 
		String sEcho = request.getParameter("draw");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		page.setData(taskService.queryTaskClaimEn(Integer.parseInt(start),Integer.parseInt(length),taskId));
		page.setDraw(Integer.parseInt(sEcho));
		page.setRecordsFiltered(taskService.queryTaskClaimEnCount(taskId));
		page.setRecordsTotal(taskService.queryTaskClaimEnCount(taskId));
		return page;
	}
	
	/**
	 * 分派任务给企业 一个任务只能分派给一个企业，不能进行拆分
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/assignEnterprise")
	@ResponseBody
	public JsonView AssignEnterprise(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		int result = taskService.AssignEnterprise(taskId,accountId);
		if(result == 0){
			json.setMessage("任务分派失败");
			json.setMessageCode("10001");
			json.setSuccess(false);
		}else{
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
