package com.manager.service.base;

import com.manager.common.PageView;
import com.manager.dao.base.Base;




public interface BaseService<T> extends Base<T> {
	/**
	 * ���ط�ҳ�������
	 * @param pageView
	 * @param t
	 * @return
	 */
	public PageView query(PageView pageView,T t);
}
