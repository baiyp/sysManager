/**
 * 
 */
package com.manager.messageboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.advertisement.dao.AdvertisementDao;
import com.manager.advertisement.service.AdvertisementService;
import com.manager.common.StringUtils;
import com.manager.common.view.PageView;
import com.manager.messageboard.dao.MessageBoardDao;
import com.manager.messageboard.service.MessageBoardService;
import com.manager.sys.model.Advertisement;
import com.manager.sys.model.MessageBoard;

/**
 * @author baiyp
 */
@Service("messageBoardService")
public class MessageBoardServiceImpl implements MessageBoardService {

	@Autowired
	 private MessageBoardDao messageBoardDao;

	@Override
	public MessageBoard getMessageBoard(int id) { 
		return messageBoardDao.getMessageBoard(id);
	}
  
	@Override
	public int deleteMessageBoard(String annoId) { 
		try{
			List<String> arrList = new ArrayList<String>();
			if(null != annoId && !"".equals(annoId)){
				String [] id = annoId.split(",");
				for(String str : id){
					arrList.add(str);
				}
				messageBoardDao.deleteMessageBoard(arrList);
			}else{
				return 0;
			}
		}catch(Exception e){
			return 0;
		}
		return 1; 
	}
	
	@Override
	public ArrayList<MessageBoard> queryMessageBoard(PageView page) {
		return messageBoardDao.queryMessageBoard(page);
	}

	 

}
