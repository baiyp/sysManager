package com.manager.task.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.common.view.PageView;
import com.manager.sys.model.Task;
import com.manager.task.dao.TaskDao;
import com.manager.task.service.TaskService;

 
@Service("taskService")
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDao taskDao;

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
		return taskDao.queryTaskClaimEn(page, taskId);
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
	public int AssignEnterprise(int taskId, int accountId) {
		/*1:更新中标企业任务信息标记 
		 *2：更新认领未中标的企业标记（tender表 qualified ） 
		 *3：更新任务表的任务状态标记（tendertask表  flag）*/
		taskDao.updateTaskStatus(taskId);
		taskDao.updateTenderNotWinning(taskId, accountId);
		taskDao.updateTenderWinBidding(taskId, accountId);
		return 1;
	}

	@Override
	public int deletTaskManage(int taskId) {
		//taskDao.updateTaskStatus(taskId);
		return 1;
	}

 

}
