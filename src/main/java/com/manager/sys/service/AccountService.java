package com.manager.sys.service;

import java.util.ArrayList;

import com.manager.sys.model.Enterprise;
import com.manager.sys.model.Personal;

public interface AccountService {
	
	
	public int queryPersonalLimitCount(int userType);
	
	
	public int queryEnterpriseLimitCount(int userType);
	
	/**
	 * 查询用户信息
	 * @param pageNo  
	 * @param pageSize
	 * @param accountType 0 是个人普通会员、大于0是个人VIP会员
	 * @return
	 */
	public ArrayList<Personal>  queryAccount(int pageNo,int pageSize,int accountType);
	
	/**
	 * 查找用户选取
	 * @param accountId
	 * @return
	 */
	public Personal queryPersonalDetailed(int accountId);
	
	
	/**
	 * 查找企业选取
	 * @param accountId
	 * @return
	 */
	public Enterprise queryEnterpriseDetailed(int accountId);
	
	
	/**
	 * 审核用户信息（包括企业用户和个人用户)
	 * @param accountId
	 * @param auditStatus
	 * @return
	 */
	public int auditAccount(int accountId,int auditStatus);
	
	/**
	 * 
	 * @param pageNo   页码
	 * @param pageSize  每页显示记录数
	 * @param accountType 普通企业会员 、VIP企业会员 
	 * @return
	 */
	public ArrayList<Enterprise> queryEnterprise(int pageNo,int pageSize,int accountType);
	
	
	
	public int forbiddenAccount(int accountId);
	
	
	

}
