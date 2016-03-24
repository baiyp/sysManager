/**
 * 
 */
package com.manager.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.sys.dao.AccountDao;
import com.manager.sys.service.AccountService;

/**
 * @author baiyp
 *
 */
@Service("accountService")
public class AcountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public String queryAccount(int pageNo, int pageSize, int accountType) {
		//
		return accountDao.queryPersonal(pageNo, pageSize).toString();
	}


	@Override
	public String queryAccountDetailed(int accountId){
		return null;
	}


	@Override
	public String auditAccount(int accountId, int auditStatus) {
		// TODO Auto-generated method stub
		return null;
	}

}
