package com.yao.backstage.model.po;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Resource implements Serializable {

	/**
	 * id:1  code:  'name:   url:  模块
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue
		private int id;
		/** 代码**/
		private String code;
		/** 显示的名字**/
		private String name = "资源名";
		/** 地址**/
		private String url = "#";
		/** 模块**/
		private String module = "无";
		
		/** 资源所属的菜单 **/
		@ManyToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER)
		@JoinTable(
				name="menu_resource",
				joinColumns={
						@JoinColumn(name="menuId")
				},
				inverseJoinColumns={
						@JoinColumn(name="resourceId")
				}
		)
		private Set<Menu> menus;
		
		public Resource() {}
		
		public Resource(String code) {
			this.code = code;
		}
		
		public Resource(String code, String name, String url, String module) {
			super();
			this.code = code;
			this.name = name;
			this.url = url;
			this.module = module;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getModule() {
			return module;
		}
		public void setModule(String module) {
			this.module = module;
		}
		public Set<Menu> getMenus() {
			return menus;
		}
		public void setMenus(Set<Menu> menus) {
			this.menus = menus;
		}

}
