/**
 * 
 */
package com.manager.common.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * @author baiyp
 *
 */
public class SystemSessionListener implements SessionListener {


	@Override
	public void onStart(Session session) { 
		System.out.println("onStart--------------------------------------------------"); 
	}


	@Override
	public void onStop(Session session) {
		System.out.println("onStop---------------------------------------------------");
	}


	@Override
	public void onExpiration(Session session) {
		System.out.println("onExpiration----------------------------------------------"); 
	}

}
