package com.yao.backstage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/backstage")
public class BackstageController {
	
	@RequestMapping(value={"","/","index"},method=RequestMethod.GET)
	public String index() {
		return "backstage/index"; 
	}
	
	@RequestMapping(value={"/addProduct"},method=RequestMethod.GET)
	public String addProduct() {
		return "backstage/addProduct"; 
	}
	
}
