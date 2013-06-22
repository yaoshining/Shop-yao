package com.yao.dao;

import java.util.List;

public interface DAO {
	public void save(Object entity);
	public void saveEntities(Iterable<?> entities);
	public void saveEntities(Object...entities);
	public <T> void removeById(Class<T> entityClass, Object entityId);
	public <T> void removeByIds(Class<T> entityClass, Object...entityIds);
	public <T> void removeByIds(Class<T> entityClass, Iterable<?> entityIds);
	public <T> T find(Class<T> entityClass, Object entityId);
	public <T> List<T> findByIds(Class<T> entityClass, Iterable<?> entityIds);
	public <T> List<T> findByIds(Class<T> entityClass, Object...entityIds);
	public <T> T update(T entity);
	public <T> List<T> updateEntities(Iterable<T> entities);
	public <T> List<T> updateEntities(T[] entities);
}
