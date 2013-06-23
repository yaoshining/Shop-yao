package com.yao.dao.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yao.dao.DAO;
import com.yao.dao.bean.SearchOperator;
import com.yao.dao.bean.WhereCondition;
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
	
	public List<T> findAll(Class<T> entityClass) {
		List<T> resultList = Collections.emptyList();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		cq.from(entityClass);
		resultList = em.createQuery(cq).getResultList();
		return resultList;
	}
	
	@Override
	public List<T> find(Class<T> entityClass,List<WhereCondition> conditions,Map<String,com.yao.dao.bean.Order> orderby) {
		List<T> resultList = Collections.emptyList();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(entityClass);
		Root<T> root = cq.from(entityClass);
		cq.select(root);
		if(conditions!=null){
			List<Predicate> predicates = new ArrayList<Predicate>();
			for(WhereCondition condition : conditions) {
				String fieldName = condition.getFieldName();
				SearchOperator operator = condition.getOperator();
				Object value = condition.getValue();
				if(operator == SearchOperator.EQUAL) {
					predicates.add(cb.equal(root.get(fieldName), value));
				}
				if(operator == SearchOperator.LIKE) {
					predicates.add(cb.like(root.get(fieldName).as(String.class), (String)value));
				}
				if(operator == SearchOperator.IN) {
					if(value instanceof Collection<?>)
						predicates.add(root.get(fieldName).in(value));
					if(value.getClass().isArray())
						predicates.add(root.get(fieldName).in((Object[])value));
				}
			}
			cq.where(predicates.toArray(new Predicate[conditions.size()]));
		}
		if(orderby!=null) {
			List<Order> orderList = new ArrayList<Order>();
			for(Entry<String, com.yao.dao.bean.Order> o : orderby.entrySet()) {
				String fieldName = o.getKey();
				com.yao.dao.bean.Order order = o.getValue();
				if(order == com.yao.dao.bean.Order.ASC)
					orderList.add(cb.asc(root.get(fieldName)));
				if(order == com.yao.dao.bean.Order.DESC)
					orderList.add(cb.desc(root.get(fieldName)));
			}
			cq.orderBy(orderList);
		}
		resultList = em.createQuery(cq).getResultList();
		return resultList;
	}
	
}
