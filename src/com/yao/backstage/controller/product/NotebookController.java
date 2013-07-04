package com.yao.backstage.controller.product;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yao.backstage.model.po.Notebook;
import com.yao.backstage.service.product.NotebookService;

@Controller
@Scope("prototype")
@RequestMapping("/backstage/notebook")   //注意看路径,enb2
public class NotebookController {
	
	private final NotebookService notebookService;
	
	@Inject
	public NotebookController(NotebookService notebookService) {
		this.notebookService = notebookService;
	}
	
	@PersistenceContext
	private EntityManager em;
	@RequestMapping(value={"","/save"},method=RequestMethod.POST)
	@ResponseBody
	public Notebook save(@RequestBody Notebook notebook) {   //现不写save了,因为json我们还没定义,先能访问把
		notebookService.save(notebook);
		return notebook;  
	}
		
}
