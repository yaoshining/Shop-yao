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
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

@Entity
@JsonAutoDetect
public class Resources implements Serializable {

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
		@JsonProperty("text")
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
		@JsonIgnore
		private Set<Menu> menus;
		private String icon;
		private String iconCls;
		@Transient
		private final boolean leaf = true;
		public Resources() {}
		
		public Resources(String code) {
			this.code = code;
		}
		
		public Resources(String code, String name, String url, String module) {
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

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getIconCls() {
			return iconCls;
		}

		public void setIconCls(String iconCls) {
			this.iconCls = iconCls;
		}

		public boolean isLeaf() {
			return leaf;
		}
		
}
