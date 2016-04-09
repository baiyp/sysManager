/**
 * 
 */
package com.manager.dao.base;

import java.util.List;

/**
 * @author baiyp
 */
public interface Base<T> {
	
	/**
 
	 * @return
	 */
	public List<T> queryAll(T t);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public T  getById(String id);
	
	/**
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int update(T t) throws Exception;
	
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteById(String id) throws Exception;
	
	
	/**
	 * 
	 * @param arrId
	 * @return
	 * @throws Exception
	 */
	public int delete(List<String> arrId) throws Exception;
	
	/**
	 * 
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int add(T t) throws Exception;
	
	

}
