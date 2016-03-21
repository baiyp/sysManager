/**
 * 
 */
package com.manager.sys.dao;

import java.util.List;

import com.manager.sys.model.Account;

/**
 * @author baiyp
 *
 */
public interface AccountDao {
	
	
	public List<Account> queryAccount(int pageNo,int pageSize,int userType);
	

}
