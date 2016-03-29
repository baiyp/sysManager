/**
 * 
 */
package com.manager.task.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.manager.sys.model.Task;

/**
 * @author baiyp
 * @category 任务管理模块
 */

public interface TaskDao {
	
	
	
	/**
	 * 
	 * @param taskId
	 * @return
	 */
	public Task getTaskManage(@Param("taskId") int taskId);
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return ArrayList<Task>
	 */
	public ArrayList<Task>  queryTaskManage(@Param("pageNo")int pageNo,@Param("pageSize") int pageSize);
 

	/**
	 * 
	 * @return
	 */
	public int queryTaskManageCount();
	
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return ArrayList<Task>
	 */
	public ArrayList<Task>  queryTaskAssign(@Param("pageNo")int pageNo,@Param("pageSize") int pageSize);
	
	/**
	 * 
	 * @return
	 */
	public int queryTaskAssignCount();
	
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @return ArrayList<Task>
	 */
	public ArrayList<Task>  queryTaskClaimEn(@Param("pageNo")int pageNo,@Param("pageSize") int pageSize,@Param("taskId") int taskId);
	
	
	/**
	 * 
	 * @param taskId
	 * @return
	 */
	public int queryTaskClaimenCount(int taskId);
	
	
	
	/**
	 * 
	 * @param taskId
	 * @param status
	 * @return
	 */
	public int auditTaskManage(@Param("taskId") int taskId,@Param("review") int status);
	
	
	
	/**
	 * 更新任务表的任务状态信息（flag 任务状态：0进行中；1 已完成；2 无人认领）
	 * @param taskId
	 * @return
	 */
	public int updateTaskStatus(@Param("taskId") int taskId);
	
	
	/**
	 * 更新Tender的中标状态信息
	 * @param taskId
	 * @param accountId
	 * @return
	 */
	public int updateTenderWinBidding(@Param("taskId") int taskId,@Param("accountId") int accountId);
	
	/**
	 * 更新任务认领的未中标状态信息
	 * @param taskId
	 * @param accountId
	 * @return
	 */
	public int updateTenderNotWinning(@Param("taskId") int taskId,@Param("accountId") int accountId);
	
	
	
	
	

}
