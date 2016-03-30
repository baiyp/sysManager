/**
 * 
 */
package com.manager.announcement.service;

import java.util.ArrayList;

import com.manager.sys.model.Announcement;

/**
 * @author baiyp
 *@category 公告管理
 */
public interface AnnouncementService {
	
	
	/**
	 * 
	 * @param anno
	 * @return
	 */
	public int addAnnouncement(Announcement anno);
	
	
	/**
	 * 
	 * @param annoId
	 * @return
	 */
	public Announcement getAnnouncement(int annoId);
	
	
	/**
	 * 
	 * @param anno
	 * @return
	 */
	public int updateAnnouncement(Announcement anno);
	
	
	/**
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Announcement> queryAnnouncement(int pageNo, int pageSize);
	
	
	/**
	 * @param annoId
	 * @return
	 */
	public int deleteAnnouncement(int annoId);
	
	
	public int queryAnnouncementCount();
	
	
	
	

}
