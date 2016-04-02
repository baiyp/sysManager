package com.manager.common.dialect;

import com.manager.common.view.PageView;

//类似hibernate的Dialect,只精简出分页部分
public interface Dialect {
	
	public static enum Type{MYSQL,ORACLE,SQLSERVER}
	
	
    /**
     * 数据库本身是否支持分页当前的分页查询方式
     * 如果数据库不支持的话，则不进行数据库分页 
     * @return true：支持当前的分页查询方式
     */
    public boolean supportsLimit();
	
    /**
     * 将sql转换为分页SQL，分别调用分页sql
     *
     * @param querySqlString    SQL语句
     * @param offset 开始条数
     * @param limit  每页显示多少纪录条数
     * @return 分页查询的sql
     */
	public  String getLimitString(String querySql,PageView page);
	
	
	
	public String getCountString(String querySqlString);

 
}
