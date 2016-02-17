package com.manager.dao.base;

import java.util.List;
import java.util.Map;

/**
 * 所有的Mapper继承这个接口
 * 实现基本的 增,删,改,查接口
 */
public interface BaseDao<T> extends Base<T> {
	/**
	 * 返回分页后的数据
	 * @param List
	 * @param t
	 * @return
	 */
	public List<T> query(Map<String, Object> map);
}

