/**
 * 
 */
package com.manager.announcement.control;

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
import com.manager.sys.model.Announcement;

/**
 * @author baiyp
 *
 */
@Controller
public class AnnouncementController extends BaseController {
	
	@Autowired
	private AnnouncementService announcementService;
	
	
	@RequestMapping(value="/addAnnouncement")
	@ResponseBody
	public JsonView addAnnouncement(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Announcement anno = new Announcement();
		anno.setContent(content);
		anno.setCreate_Date(String.valueOf(new Date().getTime()/1000));
		anno.setTitle(title);
		anno.setUserId(1);
		int result = announcementService.addAnnouncement(anno);
		if(result == 0){
			json.setMessage("添加公告信息失败");
			json.setSuccess(false);
			json.setMessageCode("100001");
		}else{
			json.setMessage("添加公告信息成功");
			json.setMessageCode("100001");
		}
		return json;
	}
	
	
	@RequestMapping(value="/queryAnnouncement")
	@ResponseBody
	public PageView<Announcement> queryAnnouncement(HttpServletRequest request,HttpServletResponse response){
		PageView<Announcement> page = super.getPageView(request, response); 
		page.setData(announcementService.queryAnnouncement(page));
		page.setRecordsFiltered(page.getRecordsTotal());
		return page;
	}
	
	@RequestMapping(value="/getAnnouncement")
	@ResponseBody
	public Announcement getAnnouncement(HttpServletRequest request,HttpServletResponse response){ 
		int noticeId = Integer.parseInt(request.getParameter("noticeId")); 
		return  announcementService.getAnnouncement(noticeId);
	}
	
	
	@RequestMapping(value="/updateAnnouncement")
	@ResponseBody
	public JsonView updateAnnouncement(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		Announcement anno = new Announcement();
		int noticeId = Integer.parseInt(request.getParameter("noticeId")); 
		String title = request.getParameter("title"); 
		String content = request.getParameter("content");
		anno.setId(noticeId);
		anno.setContent(content);
		anno.setUpdate_Date(String.valueOf(new Date().getTime()/1000));
		anno.setTitle(title);
		int result = announcementService.updateAnnouncement(anno);
		if(result == 0){
			json.setMessage("修改公告信息失败");
			json.setSuccess(false);
			json.setMessageCode("100001");
		}else{
			json.setMessage("修改公告信息成功");
			json.setMessageCode("100001");
		}
		return json;
	}
	
	
	@RequestMapping(value="/deleteAnnouncement")
	@ResponseBody
	public JsonView deleteAnnouncement(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		String  noticeId = request.getParameter("noticeId"); 
		int result = announcementService.deleteAnnouncement(noticeId); 
		if(result == 0){
			json.setMessage("删除公告信息失败");
			json.setMessageCode("10001");
			json.setSuccess(false);
		}else{
			json.setMessage("删除公告信息成功");
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
