package com.yao.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller("testAction")
public class TestAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9058682255989110605L;
	@Resource DAOTest daoTest;
	@Override
	public String execute() throws Exception {
		Employee emp = new Employee();
		emp.setId(345);
		emp.setName("Ò¦ÊÀÄþ");
		daoTest.save(emp);
		return SUCCESS;
	}
}
