/**
 * 
 */
package com.manager.news.dao;

import java.util.ArrayList;
import java.util.List;

import com.manager.common.view.PageView; 
import com.manager.sys.model.News;

/**
 * @author baiyp
 *
 */
public interface NewsDao{
	
	/**
	 * 
	 * @param anno
	 */
	public void addNews(News anno);
	
	/**
	 * @param anno
	 */
	public void updateNews(News anno);
	
	/**
	 * 
	 * @param annoId
	 * @return
	 */
	public void deleteNews(List id);
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public ArrayList<News> queryNews(PageView page);
	
	/**
	 * @param annoId
	 * @return
	 */
	public News getNews(int id);
 
	
}
