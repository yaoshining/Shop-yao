package com.yao.test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yao.dao.jpa.JpaDaoSupport;
import com.yao.test.po.Resource;
import com.yao.test.service.ResourceService;
@Service 
@Transactional 
public class ResourceServiceBean extends JpaDaoSupport<Resource>  implements ResourceService{

}
