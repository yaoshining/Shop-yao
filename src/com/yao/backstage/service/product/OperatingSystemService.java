package com.yao.backstage.service.product;

import com.yao.backstage.model.po.Notebook;
import com.yao.dao.DAO;

public interface OperatingSystemService extends DAO<Notebook> {   //这是接口,让bean实现它,要继承我写的DAO接口
	public void test();  //自己写的方法
}
