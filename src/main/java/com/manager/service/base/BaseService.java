package com.manager.service.base;

import com.manager.common.PageView;
import com.manager.dao.base.Base;



/**
 * 所有服务接口都要继承这个
 * @param <T>
 */
public interface BaseService<T> extends Base<T> {
	/**
	 * 返回分页后的数据
	 * @param pageView
	 * @param t
	 * @return
	 */
	public PageView query(PageView pageView,T t);
}
