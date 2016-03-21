package com.manager.dao.base;

import java.util.List;
import java.util.Map;


public interface BaseDao<T> extends Base<T> {


	public List<T> query(Map<String, Object> map);
}

