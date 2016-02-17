package com.manager.common.exceptions;

import org.apache.shiro.authc.AuthenticationException;

@SuppressWarnings("all")
public class CaptchaException extends AuthenticationException{
	
	public CaptchaException() {
		super();
	}

	public CaptchaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CaptchaException(String message) {
		super(message);
	}

	public CaptchaException(Throwable cause) {
		super(cause);
	}

}
