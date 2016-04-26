package com.manager.advertisement.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.manager.common.view.PageView;
import com.manager.sys.model.Advertisement;


public interface AdvertisementService {
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	public ArrayList<Advertisement> queryAdvertisement(PageView page);
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Advertisement getAdvertisement(int id);
	
	
	/**
	 * @param a
	 * @return
	 */
	public int   updateAdvertisement(Advertisement a);
	
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public int addAdvertisement(Advertisement a);
	
	
	/**
	 * @param id
	 * @return
	 */
	public int   deleteAdvertisement(String id);

}
