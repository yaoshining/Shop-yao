package com.yao.backstage.model.po;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
		private String name;
		/** 地址**/
		private String url;
		/** 模块**/
		private String module;
		
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


}
