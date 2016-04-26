/**
 * 
 */
package com.manager.news.service;

import java.util.ArrayList;

import com.manager.common.view.PageView;
import com.manager.sys.model.Announcement;
import com.manager.sys.model.News;

/**
 * @author baiyp
 *@category 公告管理
 */
public interface NewsService {
	
	
	/**
	 * 
	 * @param anno
	 * @return
	 */
	public int addNews(News anno);
	
	
	/**
	 * 
	 * @param annoId
	 * @return
	 */
	public News getNews(int annoId);
	
	
	/**
	 * 
	 * @param anno
	 * @return
	 */
	public int updateNews(News anno);
	
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public ArrayList<News> queryNews(PageView page);
	
	
	/**
	 * @param annoId
	 * @return
	 */
	public int deleteNews(String annoId);
	 
	
	
	
	

}
