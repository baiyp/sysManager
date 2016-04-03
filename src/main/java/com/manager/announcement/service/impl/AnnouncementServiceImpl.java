package com.manager.announcement.service.impl;

import java.util.ArrayList;

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
		return 0;
	}

	@Override
	public Announcement getAnnouncement(int annoId) {
		return null;
	}

	@Override
	public int updateAnnouncement(Announcement anno) {
		return 0;
	}

	@Override
	public ArrayList<Announcement> queryAnnouncement(PageView page) {
		return announcementDao.queryAnnouncement(page);
	}

	@Override
	public int deleteAnnouncement(int annoId) {
		return 0;
	}
 
}
