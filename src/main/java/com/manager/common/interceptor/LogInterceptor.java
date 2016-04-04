/**
 * 
 */
package com.manager.common.interceptor;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.manager.common.DateUtils;
import com.manager.common.Global;
import com.manager.sys.model.User;
 

/**
 * @author baiyp
 *
 */
public class LogInterceptor implements HandlerInterceptor {
	
	//记录当前时间
	private static final ThreadLocal<Long> startTimeThreadLocal = new  NamedThreadLocal<Long>("startTime threadLocal");

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 
	 */
	public LogInterceptor() { 
	}

 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		User user = (User) request.getSession().getAttribute(Global.USER_SESSION);
		String path = request.getServletPath();
		
		 if(!(path.indexOf("/login.html") > -1 || path.indexOf(".css") > -1 || path.indexOf(".js") > -1  || path.indexOf("/userLogin") > -1)){
           if (user == null) {
        	   response.sendRedirect("/sysManager/login.html");				
        	    return false;
	       } 
	     }
 
		if(logger.isDebugEnabled()){
			long startTime = System.currentTimeMillis();
			startTimeThreadLocal.set(startTime);
			logger.debug("开始计时时间： {}, URI： {}",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(startTime),request.getRequestURI());
		}
		return true;
	}


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView != null){
			logger.info("viewName: " + modelAndView.getViewName());
		}

	}


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if(logger.isDebugEnabled()){
			Long startTime = startTimeThreadLocal.get();//获取线程局部时间
			Long endTime = System.currentTimeMillis();//结束时间
			logger.debug("计时结束：{}  耗时：{}  URI: {}  最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
	        		new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(endTime), DateUtils.formatDateTime(endTime - startTime),
					request.getRequestURI(), Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024, 
					(Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024); 
			
		}
		 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
