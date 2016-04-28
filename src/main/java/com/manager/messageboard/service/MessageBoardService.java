package com.manager.messageboard.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.manager.common.view.PageView;
import com.manager.sys.model.Advertisement;
import com.manager.sys.model.MessageBoard;


public interface MessageBoardService {
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	public ArrayList<MessageBoard> queryMessageBoard(PageView page);
 
	/**
	 * 
	 * @param id
	 * @return
	 */
	public MessageBoard getMessageBoard(int id); 
 
	/**
	 * @param id
	 * @return
	 */
	public int   deleteMessageBoard(String id);

}
