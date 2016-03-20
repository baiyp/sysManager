package com.manager.control.base;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.manager.common.Common;
import com.manager.common.PageView;

/**
 * 
 */
@Controller
public class BaseController {
	
	PageView pageView = null;
 
	public PageView getPageView(String pageNow,String pagesize) {
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		if (Common.isEmpty(pagesize)) {
			pagesize = "10";
		} 
		pageView.setPageSize(Integer.parseInt(pagesize));
		return pageView;
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