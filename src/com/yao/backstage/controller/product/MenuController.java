package com.yao.backstage.controller.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yao.backstage.model.po.Menu;
import com.yao.backstage.service.system.MenuService;
import com.yao.backstage.service.system.ResourcesService;
import com.yao.dao.bean.SearchOperator;
import com.yao.dao.bean.WhereCondition;
import com.yao.data.enumeration.BackstageModule;

@Controller
@RequestMapping("/backstage/menus")
public class MenuController {
	@Resource
	private MenuService menuService;
	@Resource
	private ResourcesService resourcesService;
	@RequestMapping(value="/{module}/{parentId}",method=RequestMethod.GET)
	@ResponseBody
	public List<Menu> getMenusByParent(@PathVariable("module") BackstageModule module, @PathVariable("parentId") int parentId) {
		List<Menu> menuList = Collections.emptyList();
		List<WhereCondition> conditions = Arrays.asList(new WhereCondition[]{
				new WhereCondition("parent", SearchOperator.IS_NULL, null),
				new WhereCondition("module", SearchOperator.EQUAL, module)
		});
		if(parentId<=0) {
			menuList = menuService.find(Menu.class, conditions , null);
		} else{
			menuList = new ArrayList<Menu>(menuService.find(Menu.class, parentId).getChildren());
		}
		return menuList;
	}
}
