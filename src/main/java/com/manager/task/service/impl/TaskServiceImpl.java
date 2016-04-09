package com.manager.task.service.impl;
 
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.common.sms.MessageSender;
import com.manager.common.view.PageView;
import com.manager.sys.dao.AccountDao;
import com.manager.sys.model.Coworkinfo;
import com.manager.sys.model.Enterprise;
import com.manager.sys.model.Task;
import com.manager.task.dao.TaskDao;
import com.manager.task.service.TaskService; 
 
@Service("taskService")
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDao taskDao;
	
	@Autowired
	private AccountDao accountDao;
	 

	public TaskServiceImpl() {
		
	}

	@Override
	public ArrayList<Task> queryTaskManage(PageView page) {
		return taskDao.queryTaskManage(page);
	}

	@Override
	public ArrayList<Task> queryTaskAssign(PageView page) {
		return taskDao.queryTaskAssign(page);
	}



	@Override
	public ArrayList<Task> queryTaskClaimEn(PageView page, int taskId) {
		return taskDao.queryTaskClaimEn(page,taskId);
	}
 

	@Override
	public Task getTaskManage(int taskId) { 
		return taskDao.getTaskManage(taskId);
	}

	@Override
	public int auditTaskManage(int taskId, int status) {
		return taskDao.auditTaskManage(taskId,status);
	}

	@Override
	public int AssignEnterprise(Coworkinfo work) { 
		Enterprise workOwner = accountDao.getTaskEnterprise(work.getTask_id());//发布任务信息
		Enterprise workContractor = accountDao.getEnterprise(work.getWork_contractor_id());//接受任务信息
		work.setWin_time(new Date().getTime()/1000);
		work.setWork_owner_id(workOwner.getId());
		work.setWork_owner_name(workOwner.getEnterprise_name());
		work.setWork_type(workOwner.getCategory());
		work.setWork_name(workOwner.getTitle()); 
		work.setWork_place(workContractor.getCity());
		work.setWork_contractor_name(workContractor.getEnterprise_name());
		/*1: 更新中标企业任务信息标记 
		 *2： 更新认领未中标的企业标记（tender表 qualified ） 
		 *3： 更新任务表的任务状态标记（tendertask表  flag）*/
		try{
			taskDao.insetCoworkinfo(work);
			taskDao.updateTaskStatus(work.getTask_id());
			taskDao.updateTenderNotWinning(work.getTask_id(),work.getWork_contractor_id());
			taskDao.updateTenderWinBidding(work.getTask_id(),work.getWork_contractor_id());
			MessageSender.sendMessage("加加物联网提示：您的领取任务信息已通过，请及时登录网站确认合作信息【加加物联网】",workContractor.getUsername());
		}catch(Exception e){
			return 0;
		}
		return 1;
	}

	@Override
	public int deletTaskManage(int taskId) {
		taskDao.deleteTask(taskId);
		return 1;
	}
	
	
	@Override
	public int updateTaskStatus(int taskId){
		taskDao.updateTaskStatus(taskId);
		return 1;
	}

  
 
}
