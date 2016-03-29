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
	
	
	/**
	 * 获取任务列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Task> queryTaskManage(int pageNo,int pageSize);
	 
	
	/**
	 * 获取任务列表总数
	 * @return
	 */
	public int queryTaskManageCount();
	
	/**
	 * 获取单个任务信息
	 * @param taskId
	 * @return
	 */
	public Task getTaskManage(int taskId);
	
	/**
	 * 审核单个任务信息
	 * @param taskId
	 * @param status
	 * @return
	 */
	public int auditTaskManage(int taskId,int status);
	
	/**
	 * 查询可以认领的任务列表  审核通过的任务信息才可以进行认领
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Task> queryTaskAssign(int pageNo,int pageSize);
	
	/**
	 * 
	 * @return
	 */
	public int queryTaskAssignCount();
	
	/**
	 * 查询单个任务所认领公司信息列表
	 * @param pageNo
	 * @param pageSize
	 * @param taskId
	 * @return
	 */
	public ArrayList<Task> queryTaskClaimEn(int pageNo,int pageSize,int taskId);
	
	
	/**
	 * 查询单个任务所认领公司的总数
	 * @param taskId
	 * @return
	 */
	public int queryTaskClaimEnCount(int taskId);
	
	/**
	 * 选派中标企业
	 * @param taskId
	 * @param accountId
	 * @return
	 */
	public int AssignEnterprise(int taskId,int accountId);

}
