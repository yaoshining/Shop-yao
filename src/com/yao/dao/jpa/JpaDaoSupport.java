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
public abstract class JpaDaoSupport<T> implements DAO<T> {
	
	@PersistenceContext
	protected EntityManager em;
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public JpaDaoSupport() {
		String superClassName = getClass().getGenericSuperclass().toString();
		String entityClassName = superClassName.substring(superClassName.indexOf("<")+1, superClassName.indexOf(">"));
		try {
			entityClass = (Class<T>) Class.forName(entityClassName).getClass();
			System.out.println(entityClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
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
	public void removeById(Object entityId) {
		em.remove(em.find(entityClass, entityId));
	}

	@Override
	public T find(Object entityId) {
		return (T) em.find(entityClass, entityId);
	}
	
	@Override
	public List<T> findByIds(Iterable<?> entityIds) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		cq.from(entityClass).in(entityIds);
		return em.createQuery(cq).getResultList();
	}
	
	@Override
	public List<T> findByIds(Object... entityIds) {
		return findByIds(entityClass, Arrays.asList(entityIds));
	}

	@Override
	public void removeByIds(Object... entityIds) {
		for(Object entityId : entityIds) {
			em.remove(em.getReference(entityClass, entityId));
		}
	}

	@Override
	public void removeByIds(Iterable<?> entityIds) {
		for(Object entityId : entityIds) {
			em.remove(em.getReference(entityClass, entityId));
		}
	}

	@Override
	public T update(T entity) {
		return em.merge(entity);
	}
	
	@Override
	public List<T> updateEntities(Iterable<T> entities) {
		List<T> mergedEntities = new ArrayList<T>();
		for(T entity : entities) {
			mergedEntities.add(em.merge(entity));
		}
		return mergedEntities;
	}
	
	@Override
	public List<T> updateEntities(T[] entities) {
		return updateEntities(Arrays.asList(entities));
	}
}
