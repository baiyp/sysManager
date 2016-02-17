package com.manager.dao.base;

import java.util.List;
import java.util.Map;

/**
 * ���е�Mapper�̳�����ӿ�
 * ʵ�ֻ����� ��,ɾ,��,��ӿ�
 */
public interface BaseDao<T> extends Base<T> {
	/**
	 * ���ط�ҳ�������
	 * @param List
	 * @param t
	 * @return
	 */
	public List<T> query(Map<String, Object> map);
}

