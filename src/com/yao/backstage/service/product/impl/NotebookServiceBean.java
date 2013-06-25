package com.yao.backstage.service.product.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yao.backstage.service.product.NotebookService;
import com.yao.dao.jpa.JpaDaoSupport;
@Service  //告诉Spring这是个Service
@Transactional //告诉spring对这个类添加事务管理
public class NotebookServiceBean extends JpaDaoSupport  implements NotebookService{

	@Override
	public void test() {
		System.out.println("asdadsasdasdadads");
	} 
	//类是不能几成接口的,只能实现接口,因为你要实现这个接口,所以要实现接口里面定义的所有方法,
	//但是我已经写了一个类实现这些方法,所以你几成那个类就可以不需要写这些方法了,明白了吗,因为内那个类里面已经实现了DAO接口恩
	//明白了.,你把他删了你就得自己实现,现在就写完了,但是得交给Spring帮我们管理

}
