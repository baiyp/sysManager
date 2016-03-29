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
	public ArrayList<Task>  queryTaskClaimEn(@Param("pageNo")int pageNo,@Param("pageSize") int pageSize,int taskId);
	
	
	/**
	 * 
	 * @param taskId
	 * @return
	 */
	public int queryTaskClaimenCount(int taskId);
	
	

}
