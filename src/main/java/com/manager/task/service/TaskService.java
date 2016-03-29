/**
 * 
 */
package com.manager.task.service;

import java.util.ArrayList;

import com.manager.sys.model.Task;

/**
 * @author baiyp
 * @category 任务管理模块
 */
public interface TaskService {
	
	
	public ArrayList<Task> queryTaskManage(int pageNo,int pageSize);
	
	
	public int queryTaskManageCount();
	
	
	public ArrayList<Task> queryTaskAssign(int pageNo,int pageSize);
	
	
	public int queryTaskAssignCount();

}
