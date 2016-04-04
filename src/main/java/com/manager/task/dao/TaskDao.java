/**
 * 
 */
package com.manager.task.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.manager.common.view.PageView;
import com.manager.sys.model.Coworkinfo;
import com.manager.sys.model.Task;

/**
 * @author baiyp
 * @category 任务管理模块
 */

public interface TaskDao {
	
 
	
	public Coworkinfo getTaskCoworkinfo(int taskId);
	
	
	
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
	public ArrayList<Task>  queryTaskManage(PageView page);

	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return ArrayList<Task>
	 */
	public ArrayList<Task>  queryTaskAssign(PageView page);
	

	/**
	 * @param pageNo
	 * @param pageSize
	 * @return ArrayList<Task>
	 */
	public ArrayList<Task>  queryTaskClaimEn(PageView page,@Param("taskId") int taskId);

	/**
	 * 
	 * @param taskId
	 * @param status
	 * @return
	 */
	public int auditTaskManage(@Param("taskId") int taskId,@Param("review") int status);
	
	
	
	/**
	 * @param taskId
	 */
	public void deletTaskManage(@Param("taskId") int taskId);
	
	
	/**
	 *添加任务状态信息
	 *@param work
	 */
	public void insetCoworkinfo(Coworkinfo work);
	
	
	/**
	 * 更新任务表的任务状态信息（flag 任务状态：0进行中；1 已完成；2 无人认领）
	 * @param taskId
	 * @return
	 */
	public void updateTaskStatus(@Param("taskId") int taskId);
	
	
	/**
	 * 更新Tender的中标状态信息
	 * @param taskId
	 * @param accountId
	 * @return
	 */
	public void updateTenderWinBidding(@Param("taskId") int taskId,@Param("accountId") int accountId);
	
	/**
	 * 更新任务认领的未中标状态信息
	 * @param taskId
	 * @param accountId
	 * @return
	 */
	public void updateTenderNotWinning(@Param("taskId") int taskId,@Param("accountId") int accountId);
	
	
	
	
	

}
