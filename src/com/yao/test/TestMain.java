package com.yao.test;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	private static ClassPathXmlApplicationContext cxt;
	@Test
	public void test1() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("primary");
		EntityManager em = emf.createEntityManager();
		Employee employee = new Employee();
		employee.setId(123);
		employee.setName("asdasdasd");
		em.persist(employee);
		Employee emp = em.find(Employee.class, 123);
		System.out.println(emp.getName());
	}
	@Test
	public void test2() {
		cxt = new ClassPathXmlApplicationContext("beans.xml");
		EntityManagerFactory emf = (EntityManagerFactory) cxt.getBean("entityManagerFactory");
		EntityManager em = emf.createEntityManager();
		Employee employee = new Employee();
		employee.setId(123);
		employee.setName("asdasdasd");
		em.persist(employee);
		Employee emp = em.find(Employee.class, 123);
		System.out.println(emp.getName());
	}

}
