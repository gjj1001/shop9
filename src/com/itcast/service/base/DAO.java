package com.itcast.service.base;

import java.util.LinkedHashMap;

import com.itcast.bean.QueryResult;

/**
 * @author Jason
 *
 */
public interface DAO {
	/**����ʵ��
	 * @param entity
	 */
	public void save(Object entity);
	/**ɾ��ʵ��
	 * @param entityid
	 */
	public <T> void delete(Class<T> entityClass, Object entityid);
	/**ɾ��ʵ������
	 * @param entityids
	 */
	public <T> void delete(Class<T> entityClass, Object[] entityids);
	/**����ʵ��
	 * @param entity
	 */
	public void update(Object entity);
	/**��ȡʵ��
	 * @param entityClass
	 * @param entityid
	 * @return
	 */
	public <T> T find(Class<T> entityClass, Object entityid);
	
	/**��ȡ��ҳ����
	 * @param entityClass
	 * @param firstIndex
	 * @param maxResult
	 * @return
	 */
	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult,
			String whereql, Object[] queryParams, LinkedHashMap<String, String> orderby);
	
	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult,
			LinkedHashMap<String, String> orderby);
	
	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstIndex, int maxResult,
			String whereql, Object[] queryParams);
	
	public <T> QueryResult<T> getScrollData(Class<T> entityClass,  int firstIndex, int maxResult);
	
	public <T> QueryResult<T> getScrollData(Class<T> entityClass);
}
