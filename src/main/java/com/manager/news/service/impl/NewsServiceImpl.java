package com.manager.news.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.announcement.dao.AnnouncementDao;
import com.manager.announcement.service.AnnouncementService;
import com.manager.common.view.PageView;
import com.manager.news.dao.NewsDao;
import com.manager.news.service.NewsService;
import com.manager.sys.model.Announcement;
import com.manager.sys.model.News;

@Service("newsService")
public class NewsServiceImpl implements NewsService {
	
	@Autowired
	private NewsDao newsDao;

	@Override
	public int addNews(News anno) {
		try{
			newsDao.addNews(anno);
		}catch(Exception e){
			return 0;
		}
		return 1;
	}

	@Override
	public News getNews(int annoId) {
		return newsDao.getNews(annoId);
	}

	@Override
	public int updateNews(News anno) {
		try{
			newsDao.updateNews(anno);
		}catch(Exception e){
			return 0;
		}
		return 1;
	}

	@Override
	public ArrayList<News> queryNews(PageView page) {
		return newsDao.queryNews(page);
	}

	@Override
	public int deleteNews(String annoId) {
		String id [] = annoId.split(",");
		List<String> arrList = new ArrayList<String>();
		for(String str : id){
			arrList.add(str);
		}
		try{
			newsDao.deleteNews(arrList);
		}catch(Exception e){
			return 0;
		}
		return 1;
	}
 
}
