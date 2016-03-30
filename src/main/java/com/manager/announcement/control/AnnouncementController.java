/**
 * 
 */
package com.manager.announcement.control;

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
		
		
		return json;
	}
	
	
	@RequestMapping(value="/queryAnnouncement")
	@ResponseBody
	public PageView<Announcement> queryAnnouncement(HttpServletRequest request,HttpServletResponse response){
		PageView<Announcement> page = new PageView<Announcement>(); 
		String sEcho = request.getParameter("draw");
		String start = request.getParameter("start");
		String length = request.getParameter("length"); 
		page.setData(announcementService.queryAnnouncement(Integer.parseInt(start),Integer.parseInt(length)));
		page.setDraw(Integer.parseInt(sEcho));
		page.setRecordsFiltered(announcementService.queryAnnouncementCount());
		page.setRecordsTotal(announcementService.queryAnnouncementCount()); 
		return page;
	}
	
	@RequestMapping(value="/getAnnouncement")
	public Announcement getAnnouncement(HttpServletRequest request,HttpServletResponse response){
		
		return null;
	}
	
	
	@RequestMapping(value="/updateAnnouncement")
	@ResponseBody
	public JsonView updateAnnouncement(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		
		
		return json;
	}
	
	
	@RequestMapping(value="/deleteAnnouncement")
	@ResponseBody
	public JsonView deleteAnnouncement(HttpServletResponse request,HttpServletResponse response){
		JsonView json = new JsonView();
		
		return json;
	}
	
 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
