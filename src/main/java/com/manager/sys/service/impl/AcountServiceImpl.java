/**
 * 
 */
package com.manager.sys.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.common.sms.MessageSender;
import com.manager.common.view.PageView;
import com.manager.sys.dao.AccountDao;
import com.manager.sys.model.Account;
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
 

	@Override
	public ArrayList<Personal> queryAccount(PageView page, int accountType) {
		if(accountType == 0){
			return accountDao.queryPersonal(page);
		}
		return accountDao.queryPersonalVip(page);
	}


	@Override
	public Personal queryPersonalDetailed(int accountId){
		return accountDao.getPersonal(accountId);
	}
 
	@Override
	public int auditAccount(int accountId, int auditStatus) {
		if(auditStatus == 1){
			accountDao.auditAccount(accountId,auditStatus,0);
		}else{
			accountDao.auditAccount(accountId,auditStatus,1);
			Account account = accountDao.getAccount(accountId);
			MessageSender.sendMessage("加加物联网提示：您的VIP会员申请已通过，可以正常使用【加加物联网】",account.getUsername());
		}
		return 1;
	}

	@Override
	public ArrayList<Enterprise> queryEnterprise(PageView pageView, int accountType) { 
		if(accountType > 0){
			return accountDao.queryEnterpriseVip(pageView);
		} 
		return accountDao.queryEnterprise(pageView);
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
