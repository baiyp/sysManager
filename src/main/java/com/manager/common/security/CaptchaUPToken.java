package com.manager.common.security;

import org.apache.shiro.authc.UsernamePasswordToken;

@SuppressWarnings("all")
public class CaptchaUPToken extends UsernamePasswordToken {
	
	 private String captcha;
	
	public CaptchaUPToken(String username, String password,
		boolean rememberMe, String host, String captcha) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
	}

	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
 
}
