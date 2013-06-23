package com.yao.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yao.dao.jpa.JpaDaoSupport;
import com.yao.test.Employee;
import com.yao.test.service.EmployeeService;
@Service
@Transactional
public class EmployeeServiceBean extends JpaDaoSupport<Employee> implements EmployeeService{

}
