package com.manager.control.base;
import com.manager.common.Common;
import com.manager.common.PageView;

/**
 * 
 */
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

	
}