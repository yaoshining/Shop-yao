package com.yao.dao.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yao.dao.DAO;
@Repository
@Transactional
public class JpaDaoSupport implements DAO {
	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public void save(Object entity) {
		if(entity.getClass().isArray()) {
			saveEntities((Object[])entity);
			return;
		}
		em.persist(entity);
	}

	@Override
	public void saveEntities(Iterable<?> entities) {
		for(Object entity : entities) {
			em.persist(entity);
		}
	}

	@Override
	public void saveEntities(Object... entities) {
		for(Object entity : entities) {
			em.persist(entity);
		}
	}

	@Override
	public <T> void removeById(Class<T> entityClass, Object entityId) {
		em.remove(em.find(entityClass, entityId));
	}

	@Override
	public <T> T find(Class<T> entityClass, Object entityId) {
		return em.find(entityClass, entityId);
	}
	
	@Override
	public <T> List<T> findByIds(Class<T> entityClass, Iterable<?> entityIds) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		cq.from(entityClass).in(entityIds);
		return em.createQuery(cq).getResultList();
	}
	
	@Override
	public <T> List<T> findByIds(Class<T> entityClass, Object... entityIds) {
		return findByIds(entityClass, Arrays.asList(entityIds));
	}

	@Override
	public <T> void removeByIds(Class<T> entityClass, Object... entityIds) {
		for(Object entityId : entityIds) {
			em.remove(em.getReference(entityClass, entityId));
		}
	}

	@Override
	public <T> void removeByIds(Class<T> entityClass, Iterable<?> entityIds) {
		for(Object entityId : entityIds) {
			em.remove(em.getReference(entityClass, entityId));
		}
	}

	@Override
	public <T> T update(T entity) {
		return em.merge(entity);
	}
	
	@Override
	public <T> List<T> updateEntities(Iterable<T> entities) {
		List<T> mergedEntities = new ArrayList<T>();
		for(T entity : entities) {
			mergedEntities.add(em.merge(entity));
		}
		return mergedEntities;
	}
	
	@Override
	public <T> List<T> updateEntities(T[] entities) {
		return updateEntities(Arrays.asList(entities));
	}
}
