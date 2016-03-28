/**
 * 
 */
package com.manager.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manager.sys.model.Account;
import com.manager.sys.model.Enterprise;
import com.manager.sys.model.Personal;

/**
 * @author baiyp
 *
 */
public interface AccountDao {
	
	
	public int queryEnterpriseLimitCount();
	
	public int queryEnterpriseVipLimitCount();
	
	public int queryPersonalLimitCount();
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Personal> queryPersonal(@Param("pageNo")int pageNo,@Param("pageSize") int pageSize);
	
	/**
	 * 
	 * @param accountId
	 * @return
	 */
	public Personal getPersonal(int accountId);
	
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Enterprise> queryEnterprise(@Param("pageNo")int pageNo,@Param("pageSize") int pageSize);
	
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Enterprise> queryEnterpriseVip(@Param("pageNo")int pageNo,@Param("pageSize") int pageSize);
	
	
	/**
	 * 
	 * @param accountId
	 * @return
	 */
	public Enterprise getEnterprise(int accountId);
	
	
	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	public int auditAccount(@Param("id") int id,@Param("status") int status);
	
	
	
	
	

}
