/**
 * 
 */
package com.manager.common.dialect.db;

import com.manager.common.dialect.Dialect;

/**
 * @author baiyp
 *
 */
public class MySqlDialect implements Dialect {

	 
	@Override
	public String getLimitString(String querySqlString, int offset, int limit) {
		return querySqlString + " limit " + offset + " ," + limit;
	}

 
	@Override
	public String getCountString(String querySqlString) {
		 
		int limitIndex = querySqlString.lastIndexOf("limit");

		if(limitIndex != -1){
			querySqlString = querySqlString.substring(0, limitIndex != -1 ? limitIndex : querySqlString.length() - 1);
		}

		return "SELECT COUNT(*) FROM (" + querySqlString + ") tem";
	}


	@Override
	public boolean supportsLimit() { 
		return true;
	}

}
