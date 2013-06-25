package com.yao.backstage.service.product.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yao.backstage.model.po.Menu;
import com.yao.backstage.service.product.MenuService;
import com.yao.dao.jpa.JpaDaoSupport;
@Service 
@Transactional 
public class MenuServiceBean extends JpaDaoSupport<Menu>  implements MenuService{

}
