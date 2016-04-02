package com.manager.control.base;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.manager.common.Common; 

/**
 * 
 */
@Controller
public class BaseController {
	
 
	
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