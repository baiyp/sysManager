/**
 * 
 */
package com.manager.news.control;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.announcement.service.AnnouncementService;
import com.manager.common.view.JsonView;
import com.manager.common.view.PageView;
import com.manager.control.base.BaseController;
import com.manager.news.service.NewsService;
import com.manager.sys.model.Announcement;
import com.manager.sys.model.News;

/**
 * @author baiyp
 *
 */
@Controller
public class NewsController extends BaseController {
	
	@Autowired
	private NewsService newsService;
	
	
	@RequestMapping(value="/addNews")
	@ResponseBody
	public JsonView addAnnouncement(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		News anno = new News();
		anno.setContent(content);
		anno.setCreate_Date(String.valueOf(new Date().getTime()/1000));
		anno.setTitle(title);
		anno.setUserId(1);
		int result = newsService.addNews(anno);
		if(result == 0){
			json.setMessage("添加新闻信息失败");
			json.setSuccess(false);
			json.setMessageCode("100001");
		}else{
			json.setMessage("添加新闻信息成功");
			json.setMessageCode("100001");
		}
		return json;
	}
	
	
	@RequestMapping(value="/queryNews")
	@ResponseBody
	public PageView<News> queryAnnouncement(HttpServletRequest request,HttpServletResponse response){
		PageView<News> page = super.getPageView(request, response); 
		page.setData(newsService.queryNews(page));
		page.setRecordsFiltered(page.getRecordsTotal());
		return page;
	}
	
	@RequestMapping(value="/getNews")
	@ResponseBody
	public News getNews(HttpServletRequest request,HttpServletResponse response){ 
		int newId = Integer.parseInt(request.getParameter("newId")); 
		return  newsService.getNews(newId);
	}
	
	
	@RequestMapping(value="/updateNews")
	@ResponseBody
	public JsonView updateNews(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		News news = new News();
		int newId = Integer.parseInt(request.getParameter("newId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		news.setId(newId);
		news.setTitle(title);
		news.setContent(content);
		news.setUpdate_Date(String.valueOf(new Date().getTime()/1000));
		int result = newsService.updateNews(news);
		if(result == 0){
			json.setMessage("更新新闻信息失败");
			json.setMessageCode("10001");
			json.setSuccess(false);
		}else{
			json.setMessage("更新新闻信息成功");
			json.setMessageCode("10001");
		}
		return json;
	}
	
	
	@RequestMapping(value="/deleteNews")
	@ResponseBody
	public JsonView deleteNews(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		String news = request.getParameter("newsId"); 
		int result = newsService.deleteNews(news); 
		if(result == 0){
			json.setMessage("删除新闻信息失败");
			json.setMessageCode("10001");
			json.setSuccess(false);
		}else{
			json.setMessage("删除新闻信息成功");
			json.setMessageCode("10001");
		}
		return json;
	}
	
 
	/**
	 * @param args
	 */
	public static void main(String[] args) { 

	}

}
