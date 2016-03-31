/**
 * 
 */
package com.manager.sys.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.sys.dao.AccountDao;
import com.manager.sys.model.Enterprise;
import com.manager.sys.model.Personal;
import com.manager.sys.service.AccountService;

/**
 * @author baiyp
 *
 */
@Service("accountService")
public class AcountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	
	public int queryPersonalLimitCount(int userType){
		if(userType == 0){
			return accountDao.queryPersonalLimitCount();
		}
		return accountDao.queryPersonalVipLimitCount();
	}

	@Override
	public ArrayList<Personal> queryAccount(int pageNo, int pageSize, int accountType) {
		if(accountType == 0){
			return accountDao.queryPersonal(pageNo, pageSize);
		}
		return accountDao.queryPersonalVip(pageNo, pageSize);
	}


	@Override
	public Personal queryPersonalDetailed(int accountId){
		return accountDao.getPersonal(accountId);
	}
 
	@Override
	public int auditAccount(int accountId, int auditStatus) {
		accountDao.auditAccount(accountId, auditStatus);
		return 1;
	}

	@Override
	public ArrayList<Enterprise> queryEnterprise(int pageNo, int pageSize, int accountType) { 
		if(accountType > 0){
			return accountDao.queryEnterpriseVip(pageNo, pageSize);
		} 
		return accountDao.queryEnterprise(pageNo, pageSize);
	}

	@Override
	public int queryEnterpriseLimitCount(int userType) {
		if(userType > 0){
			return accountDao.queryEnterpriseVipLimitCount();
		}
		return accountDao.queryEnterpriseLimitCount();
	}
	
	@Override
	public Enterprise queryEnterpriseDetailed(int accountId) { 
		return accountDao.getEnterprise(accountId);
	}

	@Override
	public int forbiddenAccount(int accountId) {
		try{
			accountDao.forbiddenAccount(accountId);
		}catch(Exception e){
			return 0;
		}
		return 1;
	}

}
