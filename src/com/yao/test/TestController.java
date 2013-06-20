package com.yao.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author yaoshining
 *
 */
@Controller("designer")
@RequestMapping("/controller")
public class TestController {
	@RequestMapping("/test")
	public String test(Model model,@RequestBody String definition) throws Exception {
//				Diagram diagram = Process2DiagramUtil.buildDiagramForProcess(ruleFlowProcess);
				model.addAttribute("diagram", "123");
//				model.addAttribute("nodes", nodes);
//				model.addAttribute("flows", sequenceFlows);
		return "designer";
	}
}
