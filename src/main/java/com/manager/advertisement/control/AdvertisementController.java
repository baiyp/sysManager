/**
 * 
 */
package com.manager.advertisement.control;
 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manager.advertisement.service.AdvertisementService; 
import com.manager.common.Global;
import com.manager.common.view.JsonView;
import com.manager.common.view.PageView;
import com.manager.control.base.BaseController;
import com.manager.sys.model.Advertisement; 

/**
 * @author baiyp
 *
 */
@Controller
public class AdvertisementController extends BaseController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	
	@RequestMapping(value="/addAdvertisement")
	@ResponseBody
	public JsonView addAdvertisement(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView(); 
		Advertisement anno = new Advertisement();
		int result = advertisementService.addAdvertisement(anno);
		if(result == 0){
			json.setMessage("添加广告信息失败");
			json.setSuccess(false);
			json.setMessageCode(Global.BUSINESS_CODE_RESULET);
		}else{
			json.setMessage("添加广告信息成功");
			json.setMessageCode(Global.BUSINESS_CODE_RESULET);
		}
		return json;
	}
	
	
	@RequestMapping(value="/queryAdvertisement")
	@ResponseBody
	public PageView<Advertisement> queryAdvertisement(HttpServletRequest request,HttpServletResponse response){
		PageView<Advertisement> page = super.getPageView(request, response); 
		page.setData(advertisementService.queryAnnouncement(page));
		page.setRecordsFiltered(page.getRecordsTotal());
		return page;
	}
	
	@RequestMapping(value="/getAdvertisement")
	@ResponseBody
	public Advertisement getAdvertisement(HttpServletRequest request,HttpServletResponse response){ 
		int noticeId = Integer.parseInt(request.getParameter("noticeId")); 
		return  advertisementService.getAdvertisement(noticeId);
	}
	
	
	@RequestMapping(value="/updateAdvertisement")
	@ResponseBody
	public JsonView updateAdvertisement(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		Advertisement anno = new Advertisement();
	 
		int result = advertisementService.updateAdvertisement(anno);
		if(result == 0){
			json.setMessage("修改广告信息失败");
			json.setSuccess(false);
			json.setMessageCode(Global.BUSINESS_CODE_RESULET);
		}else{
			json.setMessage("修改广告信息成功");
			json.setMessageCode(Global.BUSINESS_CODE_RESULET);
		}
		return json;
	}
	
	
	@RequestMapping(value="/deleteAdvertisement")
	@ResponseBody
	public JsonView deleteAdvertisement(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		String  noticeId = request.getParameter("noticeId"); 
		int result = advertisementService.deleteAdvertisement(noticeId); 
		if(result == 0){
			json.setMessage("删除广告信息失败");
			json.setMessageCode(Global.BUSINESS_CODE_RESULET);
			json.setSuccess(false);
		}else{
			json.setMessage("删除广告信息成功");
			json.setMessageCode(Global.BUSINESS_CODE_RESULET);
		}
		return json;
	}
	
 
	/**
	 * @param args
	 */
	public static void main(String[] args) { 

	}

}
