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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryTaskManageCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Task> queryTaskAssign(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryTaskAssignCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
