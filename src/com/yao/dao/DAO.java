package com.yao.dao;

import java.util.List;

public interface DAO<T> {
	/**
	 * 保存实体对象
	 * @param entity 可以是实体对象或实体对象的数组
	 */
	public void save(Object entity);
	/**
	 * 批量保存实体对象
	 * @param entities 实体对象的集合
	 */
	public void saveEntities(Iterable<?> entities);
	/**
	 * 批量保存实体对象
	 * @param entities 多个实体对象或实体对象的数组
	 */
	public void saveEntities(Object...entities);
	/**
	 * 删除记录
	 * @param entityId 要删除的实体对象的主键
	 */
	public void removeById(Object entityId);
	/**
	 * 批量删除多个记录
	 * @param entityIds 要删除的多个实体对象的主键
	 */
	public void removeByIds(Object...entityIds);
	/**
	 * 批量删除多个记录
	 * @param entityIds 要删除的多个实体对象的主键的集合
	 */
	public void removeByIds(Iterable<?> entityIds);
	/**
	 * 查询某条记录
	 * @param entityId 实体对象的主键
	 * @return 查询到的实体对象
	 */
	public T find(Object entityId);
	public List<T> findByIds(Iterable<?> entityIds);
	public List<T> findByIds(Object...entityIds);
	public T update(T entity);
	public List<T> updateEntities(Iterable<T> entities);
	public List<T> updateEntities(T[] entities);
}
