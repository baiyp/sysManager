/**
 * 
 */
package com.manager.messageboard.control;
 

import java.util.Date;

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
import com.manager.messageboard.service.MessageBoardService;
import com.manager.sys.model.Advertisement;
import com.manager.sys.model.MessageBoard; 

/**
 * @author baiyp
 */
@Controller
public class MessageBoardController extends BaseController {
	
	@Autowired
	private MessageBoardService messageBoardService;
	
	
	 
	
	
	@RequestMapping(value="/queryMessageBoard")
	@ResponseBody
	public PageView<MessageBoard> queryAdvertisement(HttpServletRequest request,HttpServletResponse response){
		PageView<MessageBoard> page = super.getPageView(request, response); 
		page.setData(messageBoardService.queryMessageBoard(page));
		page.setRecordsFiltered(page.getRecordsTotal());
		return page;
	}
	
	@RequestMapping(value="/getMessageBoard")
	@ResponseBody
	public MessageBoard getMessageBoard(HttpServletRequest request,HttpServletResponse response){ 
		int adverId = Integer.parseInt(request.getParameter("adverId")); 
		return  messageBoardService.getMessageBoard(adverId);
	}
	
	
 
	
	@RequestMapping(value="/deleteMessageBoard")
	@ResponseBody
	public JsonView deleteAdvertisement(HttpServletRequest request,HttpServletResponse response){
		JsonView json = new JsonView();
		String  advertId = request.getParameter("advertId"); 
		int result = messageBoardService.deleteMessageBoard(advertId); 
		if(result == 0){
			json.setMessage("删除留言板失败");
			json.setMessageCode(Global.BUSINESS_CODE_RESULET);
			json.setSuccess(false);
		}else{
			json.setMessage("删除留言板成功");
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
