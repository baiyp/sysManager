package com.manager.common;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.xml.bind.PropertyException;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;


/**
 * Mybatis�ķ�ҳ��ѯ�����ͨ������StatementHandler��prepare������ʵ�֡� 
 * ֻ���ڲ����б��а���Page���͵Ĳ���ʱ�Ž��з�ҳ��ѯ�� 
 * �ڶ����������£�ֻ�Ե�һ��Page���͵Ĳ�����Ч�� 
 * ���⣬�ڲ����б��У�Page���͵Ĳ���������@Param����ע 
 */
@SuppressWarnings("unchecked")
@Intercepts( { @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PagePlugin implements Interceptor {

	private static String dialect = null;//���ݿ�����
	private static String pageSqlId = ""; // mybaits�����ݿ�xmlӳ���ļ�����Ҫ���ص�ID(����ƥ��)

	public Object intercept(Invocation ivk) throws Throwable {
		if (ivk.getTarget() instanceof RoutingStatementHandler) {
			RoutingStatementHandler statementHandler = (RoutingStatementHandler) ivk
					.getTarget();
			BaseStatementHandler delegate = (BaseStatementHandler) ReflectHelper.getValueByFieldName(statementHandler, "delegate");
			MappedStatement mappedStatement = (MappedStatement) ReflectHelper.getValueByFieldName(delegate, "mappedStatement");
			/**
			 * ����1��ͨ���ɣ��������Ƿ���Ҫ��ҳ��.*query.*
			 * ����2������Ĳ����Ƿ���page����������У����ҳ��
			 */
		//	if (mappedStatement.getId().matches(pageSqlId)) { // ������Ҫ��ҳ��SQL
				BoundSql boundSql = delegate.getBoundSql();
				Object parameterObject = boundSql.getParameterObject();// ��ҳSQL<select>��parameterType���Զ�Ӧ��ʵ���������Mapper�ӿ���ִ�з�ҳ�����Ĳ���,�ò�������Ϊ��
				if (parameterObject == null) {
					//throw new NullPointerException("boundSql.getParameterObject() is null!");
					return ivk.proceed();
				} else {
					PageView pageView = null;
					if (parameterObject instanceof PageView) { // ��������Pagesʵ��
						pageView = (PageView) parameterObject;
					} else if (parameterObject instanceof Map) {
						for (Entry entry : (Set<Entry>) ((Map) parameterObject)
								.entrySet()) {
							if (entry.getValue() instanceof PageView) {
								pageView = (PageView) entry.getValue();
								break;
							}
						}
					} else { // ����Ϊĳ��ʵ�壬��ʵ��ӵ��Pages����
						pageView = ReflectHelper.getValueByFieldType(
								parameterObject, PageView.class);
						if (pageView == null) {
							return ivk.proceed();
						}
					}
					if (pageView == null) {
						return ivk.proceed();
					}
					String sql = boundSql.getSql();
					Connection connection = (Connection) ivk.getArgs()[0];
					setPageParameter(sql, connection, mappedStatement, boundSql, parameterObject, pageView);
					String pageSql = generatePagesSql(sql, pageView);
					ReflectHelper.setValueByFieldName(boundSql, "sql", pageSql); // ����ҳsql��䷴���BoundSql.
				}
			//}
		}
		return ivk.proceed();
	}
	/**
     * �����ݿ����ѯ�ܵļ�¼����������ҳ������д����ҳ����<code>PageParameter</code>,���������߾Ϳ���ͨ�� ��ҳ����
     * <code>PageParameter</code>��������Ϣ��
     * 
     * @param sql
     * @param connection
     * @param mappedStatement
     * @param boundSql
     * @param page
	 * @throws SQLException 
     */
    private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
            BoundSql boundSql,Object parameterObject, PageView pageView) throws SQLException {
        // ��¼�ܼ�¼��
    	PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			String countSql = "select count(1) from (" + sql
					+ ") tmp_count"; // ��¼ͳ��
			countStmt = connection.prepareStatement(countSql);
			ReflectHelper.setValueByFieldName(boundSql, "sql",
					countSql);
			DefaultParameterHandler parameterHandler = new DefaultParameterHandler(
					mappedStatement, parameterObject, boundSql);
			parameterHandler.setParameters(countStmt);
			rs = countStmt.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = ((Number) rs.getObject(1)).intValue();
			}
			pageView.setRowCount(count);
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				countStmt.close();
			} catch (Exception e) {
			}
		}

    }
	/**
	 * �������ݿⷽ�ԣ������ض��ķ�ҳsql
	 * 
	 * @param sql
	 * @param page
	 * @return
	 */
	private String generatePagesSql(String sql, PageView page) {
		if (page != null) {
			if("mysql".equals(dialect)){
				return buildPageSqlForMysql(sql, page).toString();
			}else if("oracle".equals(dialect)){
				return buildPageSqlForOracle(sql, page).toString();
			}
		}
		return sql;
	}
	  /**
     * mysql�ķ�ҳ���
     * 
     * @param sql
     * @param page
     * @return String
     */
    public StringBuilder buildPageSqlForMysql(String sql, PageView page) {
        StringBuilder pageSql = new StringBuilder(100);
        String beginrow = String.valueOf((page.getPageNow() - 1) * page.getPageSize());
        pageSql.append(sql);
        pageSql.append(" limit " + beginrow + "," + page.getPageSize());
        return pageSql;
    }

    /**
     * �ο�hibernate��ʵ�����oracle�ķ�ҳ
     * 
     * @param sql
     * @param page
     * @return String
     */
    public StringBuilder buildPageSqlForOracle(String sql, PageView page) {
        StringBuilder pageSql = new StringBuilder(100);
        String beginrow = String.valueOf((page.getPageNow() - 1) * page.getPageSize());
        String endrow = String.valueOf(page.getPageNow() * page.getPageSize());

        pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
        pageSql.append(sql);
        pageSql.append(" ) temp where rownum <= ").append(endrow);
        pageSql.append(") where row_id > ").append(beginrow);
        return pageSql;
    }
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties p) {
		dialect = p.getProperty("dialect");
		if (Common.isEmpty(dialect)) {
			try {
				throw new PropertyException("dialectName or dialect property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		} 
		pageSqlId = p.getProperty("pageSqlId");//����id�������Ƿ���Ҫ��ҳ
		if (Common.isEmpty(pageSqlId)) {
			try {
				throw new PropertyException("pageSqlId property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		}
	}

}
