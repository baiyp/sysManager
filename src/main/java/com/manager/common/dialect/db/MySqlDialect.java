/**
 * 
 */
package com.manager.common.dialect.db;

import com.manager.common.view.PageView;

/**
 * @author baiyp
 *
 */
public class MySqlDialect extends BaseSqlDialect {

	 
	@Override
	public String getLimitString(String querySqlString,PageView page) {
		StringBuilder pageSql = new StringBuilder(); 
		int pageSize = page.getPageSize(); 
		if(pageSize == 0){
			pageSize = page.getDefaultPageSize();
		} 
		String begin =String.valueOf((page.getPageNo()) * pageSize);
		
		pageSql.append(querySqlString).append(" limit ").append(begin).append(",").append(pageSize);
		 
		return pageSql.toString();
	}

 
	@Override
	public String getCountString(String querySqlString) {
		
		int lastIndex = querySqlString.lastIndexOf("limit");
		
		int beginIndex = querySqlString.toUpperCase().indexOf("FROM");
		
		if(lastIndex != -1){
			querySqlString = querySqlString.substring(beginIndex,lastIndex != -1 ? lastIndex : querySqlString.length() - 1);
		}

		return "SELECT COUNT(*) " + querySqlString;
	}
	
	
	


	@Override
	public boolean supportsLimit() { 
		return true;
	}

}
