/**
 * 
 */
package com.manager.advertisement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.advertisement.dao.AdvertisementDao;
import com.manager.advertisement.service.AdvertisementService;
import com.manager.common.StringUtils;
import com.manager.common.view.PageView;
import com.manager.sys.model.Advertisement;

/**
 * @author baiyp
 */
@Service("advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {

	@Autowired
	 private AdvertisementDao advertisementDao;

	@Override
	public Advertisement getAdvertisement(int id) { 
		return advertisementDao.getAdvertisement(id);
	}

	@Override
	public int updateAdvertisement(Advertisement a) { 
		try{
			advertisementDao.updateAdvertisement(a);
		}catch(Exception e){
			return 0;
		}
		return 1;
	}

	@Override
	public int deleteAdvertisement(String annoId) { 
		try{
			List<String> arrList = new ArrayList<String>();
			if(null != annoId && !"".equals(annoId)){
				String [] id = annoId.split(",");
				for(String str : id){
					arrList.add(str);
				}
				advertisementDao.deleteAdvertisement(arrList);
			}else{
				return 0;
			}
		}catch(Exception e){
			return 0;
		}
		return 1; 
	}

	@Override
	public ArrayList<Advertisement> queryAdvertisement(PageView page) {
		return advertisementDao.queryAdvertisement(page);
	}

	@Override
	public int addAdvertisement(Advertisement a) {
		try{
			advertisementDao.addAdvertisement(a);
		}catch(Exception e){
			return 0;
		}
		return 1;
	}

}
