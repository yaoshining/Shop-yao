package com.yao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/access")
public class AccessController {
	
	@RequestMapping(value={"/login","/login/{type}"},method=RequestMethod.GET)
	public String loginUI(@PathVariable("type") String type) {
		if(type.equals("backstage")) {
			return "backstage/login";
		}
		return "shop/login";
	}
	
}
