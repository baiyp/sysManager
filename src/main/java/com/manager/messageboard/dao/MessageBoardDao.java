package com.manager.messageboard.dao;

import java.util.ArrayList;
import java.util.List;

import com.manager.common.view.PageView;
import com.manager.sys.model.Advertisement;
import com.manager.sys.model.MessageBoard;

public interface MessageBoardDao {
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	public ArrayList<MessageBoard> queryMessageBoard(PageView page);
	
	
	/** 
	 * @param id
	 * @return
	 */
	public MessageBoard getMessageBoard(int id);
	
 
	
	/**
	 * @param id
	 * @return
	 */
	public void   deleteMessageBoard(List id);

}
