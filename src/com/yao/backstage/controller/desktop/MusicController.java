package com.yao.backstage.controller.desktop;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/music")
public class MusicController {
	@RequestMapping(value="/playlist",produces={"application/json;charset=UTF-8"},method={RequestMethod.GET})
	@ResponseBody
	public String playlist(){
		String message = WebClient.create("http://localhost:8080").path("/MusicYao/music/random/20").accept(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(message);
		return message;
	}
}
