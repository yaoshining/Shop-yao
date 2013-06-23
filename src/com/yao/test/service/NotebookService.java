package com.yao.test.service;

import com.yao.dao.DAO;
import com.yao.test.po.Notebook;

public interface NotebookService extends DAO<Notebook> {   //这是接口,让bean实现它,要继承我写的DAO接口
	public void test();  //自己写的方法
}
