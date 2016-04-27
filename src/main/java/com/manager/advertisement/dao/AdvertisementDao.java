package com.manager.advertisement.dao;

import java.util.ArrayList;
import java.util.List;

import com.manager.common.view.PageView;
import com.manager.sys.model.Advertisement;

public interface AdvertisementDao {
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	public ArrayList<Advertisement> queryAdvertisement(PageView page);
	
	
	/** 
	 * @param id
	 * @return
	 */
	public Advertisement getAdvertisement(int id);
	
	
	/**
	 * @param a
	 * @return
	 */
	public void   updateAdvertisement(Advertisement a);
	
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public void addAdvertisement(Advertisement a);
	
	
	/**
	 * @param id
	 * @return
	 */
	public void   deleteAdvertisement(List id);

}
