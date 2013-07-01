package com.yao.backstage.controller.product;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yao.backstage.model.po.Notebook;
import com.yao.backstage.service.product.NotebookService;

@Controller
@RequestMapping("/backstage/notebook")   //注意看路径,enb2
public class NotebookController {
	@Resource
	private NotebookService notebookService;
	@RequestMapping(value={"","/save"},method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void save(@RequestBody Notebook notebook) {   //现不写save了,因为json我们还没定义,先能访问把
		System.out.println(notebook.getModelNumber());
		//		notebookService.save(notebook);
	}
		
}
