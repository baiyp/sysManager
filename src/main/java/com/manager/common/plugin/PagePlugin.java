package com.manager.common.plugin;

import java.util.HashMap;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.Connection;
import com.sun.javafx.collections.MappingChange.Map;

@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class PagePlugin implements Interceptor {
	  
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final static ObjectFactory DEFAULT_OBJECT_FACOTRY = new DefaultObjectFactory();
	
	private final static ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		
		if(invocation.getTarget()  instanceof StatementHandler) {
			 //MetaObject：mybatis提供的一个基于返回获取属性值的对象的类
			 //BoundSql : 在这个里面可以获取都要执行的sql和执行sql要用到的参数
			 //MappedStatement ： 这个可以得到当前执行的sql语句在xml文件中配置的id的值
			 //RowBounds : 是mybatis内存分页要用到的。
			 //ParameterHandler ： 是mybatis中用来替换sql中?出现的值的.
			 StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
			 MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,SystemMetaObject.DEFAULT_OBJECT_FACTORY,SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
			 BoundSql boundSql = statementHandler.getBoundSql();
			 MappedStatement mappingStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
			 System.out.println("mappingStatement： " + mappingStatement.getId());
			 
			 Object param = boundSql.getParameterObject();
			 
			 if(null != param && Map.class.isAssignableFrom(param.getClass())){
				 HashMap paramMap = (HashMap) param;
				 Object _pageSize = paramMap.get("pageSize");
				 Object _pageNo = paramMap.get("pageNo");
				 
			 }
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			
		}
	
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) { 
		return Plugin.wrap(target,this);
	}

	@Override
	public void setProperties(Properties properties) {
	

	}

}
