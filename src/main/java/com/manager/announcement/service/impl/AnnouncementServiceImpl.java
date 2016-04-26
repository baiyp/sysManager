package com.manager.announcement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.announcement.dao.AnnouncementDao;
import com.manager.announcement.service.AnnouncementService;
import com.manager.common.view.PageView;
import com.manager.sys.model.Announcement;

@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService {
	
	@Autowired
	private AnnouncementDao announcementDao;

	@Override
	public int addAnnouncement(Announcement anno) {
		try{
			announcementDao.addAnnouncement(anno);
		}catch(Exception e){
			return 0;
		}
		return 1;
	}

	@Override
	public Announcement getAnnouncement(int annoId) {
		return announcementDao.getAnnouncement(annoId);
	}

	@Override
	public int updateAnnouncement(Announcement anno) {
		try{
			announcementDao.updateAnnouncement(anno);
		}catch(Exception e){
			return 0;
		}
		return 1;
	}

	@Override
	public ArrayList<Announcement> queryAnnouncement(PageView page) {
		return announcementDao.queryAnnouncement(page);
	}

	@Override
	public int deleteAnnouncement(String annoId) {
		try{
			List<String> arrList = new ArrayList<String>();
			String [] id = annoId.split(",");
			for(String str : id){
				arrList.add(str);
			}
			announcementDao.deleteAnnouncement(arrList);
		}catch(Exception e){
			return 0;
		}
		return 1;
	}
 
}
