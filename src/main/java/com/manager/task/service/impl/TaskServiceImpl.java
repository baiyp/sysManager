package com.manager.task.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public ArrayList<Task> queryTaskManage(int pageNo, int pageSize) {
		return taskDao.queryTaskManage(pageNo, pageSize);
	}

	@Override
	public int queryTaskManageCount() {
		return taskDao.queryTaskManageCount();
	}

	@Override
	public ArrayList<Task> queryTaskAssign(int pageNo, int pageSize) {
		return taskDao.queryTaskAssign(pageNo, pageSize);
	}

	@Override
	public int queryTaskAssignCount() { 
		return taskDao.queryTaskAssignCount();
	}

	@Override
	public ArrayList<Task> queryTaskClaimEn(int pageNo, int pageSize, int taskId) {
		return taskDao.queryTaskClaimEn(pageNo, pageSize, taskId);
	}

	@Override
	public int queryTaskClaimEnCount(int taskId) { 
		return taskDao.queryTaskClaimenCount(taskId);
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
