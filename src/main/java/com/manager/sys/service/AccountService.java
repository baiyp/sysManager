package com.manager.sys.service;

import java.util.ArrayList;

import com.manager.sys.model.Personal;

public interface AccountService {
	
	
	public int queryPersonalLimitCount();
	
	/**
	 * 查询用户信息
	 * @param pageNo  
	 * @param pageSize
	 * @param accountType
	 * @return
	 */
	public ArrayList<Personal>  queryAccount(int pageNo,int pageSize,int accountType);
	
	/**
	 * 查找用户选取
	 * @param accountId
	 * @return
	 */
	public String queryAccountDetailed(int accountId);
	
	
	/**
	 * 审核用户信息（包括企业用户和个人用户）
	 * @param accountId
	 * @param auditStatus
	 * @return
	 */
	public String auditAccount(int accountId,int auditStatus);
	
	
	

}
