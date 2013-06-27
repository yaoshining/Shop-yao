package com.yao.backstage.controller.product;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yao.backstage.model.po.Notebook;
import com.yao.backstage.service.product.NotebookService;

@Controller
@RequestMapping("/notebook")   //注意看路径,enb2
public class NotebookController {
	@Resource
	private NotebookService notebookService;
	@RequestMapping("/save")
	public String save(Model model,HttpServletRequest request,HttpServletResponse response,@RequestParam String id) {   //现不写save了,因为json我们还没定义,先能访问把
		System.out.println(request.getContextPath());
		System.out.println(response);
		System.out.println(id);
		return "notebook";
	}
		
	@RequestMapping("/find")
	@ResponseBody
	public List<Notebook> find(@RequestParam int id) {  
		List<Notebook> notebooks = notebookService.find(Notebook.class, null, null);
		return notebooks;
	}
	
}
