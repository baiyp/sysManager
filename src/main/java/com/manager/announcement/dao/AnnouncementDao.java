/**
 * 
 */
package com.manager.announcement.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.manager.sys.model.Announcement;

/**
 * @author baiyp
 *
 */
public interface AnnouncementDao{
	
	/**
	 * 
	 * @param anno
	 */
	public void addAnnouncement(Announcement anno);
	
	/**
	 * @param anno
	 */
	public void updateAnnouncement(Announcement anno);
	
	/**
	 * 
	 * @param annoId
	 * @return
	 */
	public void deleteAnnouncement(int annoId);
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Announcement> queryAnnouncement(@Param("pageNo") int pageNo,@Param("pageSize")int pageSize);
	
	/**
	 * @param annoId
	 * @return
	 */
	public Announcement getAnnouncement(int annoId);
	
	
	/**
	 * @return
	 */
	public int queryAnnouncementCount();
	
}
