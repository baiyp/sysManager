package com.manager.common.security;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.LoggerFactory;
import com.manager.common.exceptions.CaptchaException;


@SuppressWarnings("all")
public class AuthenticationFilter extends FormAuthenticationFilter {

	private boolean development;
	
	private String captchaParam = DEFAULT_CAPTCHA_PARAM;
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	//private static Logger logger = (Logger) LoggerFactory.getLogger(AuthenticationFilter.class);

	protected void saveRequestAndRedirectToLogin(ServletRequest request,
	ServletResponse response) throws IOException {
		redirectToLogin(request, response);
	}

	protected boolean onLoginFailure(AuthenticationToken token,
	AuthenticationException e, ServletRequest request,
	ServletResponse response) {
	boolean result = super.onLoginFailure(token, e, request, response);
	String errorMessage = "用户名或者密码错误";
	if (e instanceof CaptchaException) {
		errorMessage = "验证码输入错误";
	}
	request.setAttribute("authenticationErrorMessage", errorMessage);
	return result;
	}

	@Override
	protected CaptchaUPToken  createToken(ServletRequest request,
	ServletResponse response) {

	String username = getUsername(request);
	String password = getPassword(request);
	String captcha = getCaptcha(request);
	boolean rememberMe = isRememberMe(request);
	String host = getHost(request);

	return new CaptchaUPToken(username,password,rememberMe, host, captcha);
	}

	// 验证码校验
	protected void doCaptchaValidate(HttpServletRequest request,CaptchaUPToken token) {

		if (isDevelopment()) {
			//logger.info("开发模式，忽略验证码!");
			return;
		}

		String captcha = (String) request.getSession().getAttribute("captcha");
		if (captcha == null || !captcha.equalsIgnoreCase(token.getCaptcha())) {
		String message = String.format("输入的验证码[%s]错误！正确的是[%s]。",token.getCaptcha(), captcha);
		///logger.info(message);
		throw new CaptchaException(message);
	}
	}

	// 认证
	@Override
	protected boolean executeLogin(ServletRequest request,
	ServletResponse response) throws Exception {
	CaptchaUPToken token = createToken(request, response);
	try {
	doCaptchaValidate((HttpServletRequest) request, token);

	Subject subject = getSubject(request, response);
	//logger.debug("isRemembered: " + subject.isRemembered());
	subject.login(token);

	return onLoginSuccess(token, subject, request, response);
	} catch (AuthenticationException e) {
	e.printStackTrace();
	return onLoginFailure(token, e, request, response);
	}
	}

	public String getCaptchaParam() {
	return captchaParam;
	}

	public void setCaptchaParam(String captchaParam) {
	this.captchaParam = captchaParam;
	}

	protected String getCaptcha(ServletRequest request) {
	return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	public boolean isDevelopment() {
		return development;
	}

	public void setDevelopment(boolean development) {
		this.development = development;
	}
	
	
	public static void main(String[] args) {
		
		new UsernamePasswordToken();

	}

}
