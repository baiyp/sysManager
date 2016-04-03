package com.manager.control.base;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.manager.common.Common;
import com.manager.common.view.PageView;
import com.manager.sys.model.Personal; 

/**
 * 
 */
@Controller
public class BaseController {
	
	protected PageView page = null;
	
	
	public PageView getPageView(HttpServletRequest request,HttpServletResponse response) {
		page = new PageView();
		int echo = 0;
		int pageNo = 0;
		int pageSize = 0;
		String sEcho = request.getParameter("draw");
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		if(!("".equals(sEcho) || null ==  sEcho)){
			echo = Integer.parseInt(sEcho);
			
		}
		if(!("".equals(start) || null ==  start)){
			pageNo = Integer.parseInt(start);
			if(echo == 1 && pageNo > 0){
				 pageNo = 0;
			}
		}
		if(!("".equals(length) || null ==  length)){
			pageSize = Integer.parseInt(length);
		}else{
			pageSize = page.getDefaultPageSize();
		}
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setDraw(echo);
		return page;
	}
	
	
	
 
	
	/**
	 * 客户端返回字符串
	 * @param response
	 * @param type
	 * @param string
	 * @return
	 */
	protected String rederString(HttpServletResponse response, String type,String string){
		
		try{
			response.reset();
			response.setContentType(type);
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(string);
			return null;
		}catch(Exception e){
			return null;
		}finally{
			
		}
		
	}

	
}