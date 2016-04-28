package com.manager.common;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
	
	
	public static boolean isNotNullorBlank(String o){

		if(StringUtils.isBlank(StringUtils.trim(o)) || "".equals(StringUtils.trim(o))){
			return false;
		}
		
		return true;
		
	}

}
