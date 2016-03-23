/**
 * 
 */
package com.manager.sys.service.impl;

import org.springframework.stereotype.Service;

import com.manager.sys.service.AccountService;

/**
 * @author baiyp
 *
 */
@Service("accountService")
public class AcountServiceImpl implements AccountService {


	@Override
	public String queryAccount(int pageNo, int pageSize, int accountType) {
		//
		return null;
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
