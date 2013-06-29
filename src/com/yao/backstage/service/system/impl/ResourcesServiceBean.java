package com.yao.backstage.service.system.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yao.backstage.service.system.ResourcesService;
import com.yao.dao.jpa.JpaDaoSupport;
@Service 
@Transactional 
public class ResourcesServiceBean extends JpaDaoSupport  implements ResourcesService{

}
