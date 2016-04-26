/**
 * 
 */
package com.manager.advertisement.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.advertisement.dao.AdvertisementDao;
import com.manager.advertisement.service.AdvertisementService;
import com.manager.common.view.PageView;
import com.manager.sys.model.Advertisement;

/**
 * @author baiyp
 *
 */
@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {

	@Autowired
	 private AdvertisementDao advertisementDao;

	@Override
	public Advertisement getAdvertisement(int id) { 
		return null;
	}

	@Override
	public int updateAdvertisement(Advertisement a) { 
		return 0;
	}

	@Override
	public int deleteAdvertisement(String id) { 
		return 0;
	}

	@Override
	public ArrayList<Advertisement> queryAdvertisement(PageView page) {
		return advertisementDao.queryAdvertisement(page);
	}

	@Override
	public int addAdvertisement(Advertisement a) { 
		return 0;
	}

}
