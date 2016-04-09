package com.manager.common.session;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebSessionDAO extends AbstractSessionDAO{
	
	
	 private static final Logger log = LoggerFactory.getLogger(WebSessionDAO.class);

	@Override
	public void update(Session session) throws UnknownSessionException {
		
		System.out.println("WebSessionDAO ----------------------------update");
		
	}

	@Override
	public void delete(Session session) {
		
		System.out.println("WebSessionDAO ----------------------------delete");
	}

	@Override
	public Collection<Session> getActiveSessions() {
		
		System.out.println("WebSessionDAO ----------------------------getActiveSessions");
		return null;
	}

	@Override
	protected Serializable doCreate(Session session) {
		
		System.out.println("WebSessionDAO ----------------------------doCreate");
		return null;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		
		System.out.println("WebSessionDAO ----------------------------doReadSession");
		return null;
	}

}
