package com.yao.backstage.service.system.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yao.backstage.model.po.Resource;
import com.yao.backstage.service.system.ResourceService;
import com.yao.dao.jpa.JpaDaoSupport;
@Service 
@Transactional 
public class ResourceServiceBean extends JpaDaoSupport<Resource>  implements ResourceService{

}
