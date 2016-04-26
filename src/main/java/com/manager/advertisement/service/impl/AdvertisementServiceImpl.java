/**
 * 
 */
package com.manager.advertisement.service.impl;

import com.manager.advertisement.service.AdvertisementService;
import com.manager.common.view.PageView;
import com.manager.sys.model.Advertisement;

/**
 * @author baiyp
 *
 */
public class AdvertisementServiceImpl implements AdvertisementService {

	@Override
	public PageView<Advertisement> queryAnnouncement(PageView page) {
		return null;
	}

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

}
