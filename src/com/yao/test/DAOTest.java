package com.yao.test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class DAOTest {
	@PersistenceContext protected EntityManager em;
	public void save(Object entity) {
		em.persist(entity);  //“¶ ¿ƒ˛Ã·Ωª
	}
}
