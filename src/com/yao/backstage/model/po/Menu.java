package com.yao.backstage.model.po;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.yao.data.enumeration.BackstageModule;

@Entity
@JsonAutoDetect
@JsonSerialize(include=Inclusion.NON_NULL)
public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	/** 名字**/
	@Column(nullable=false)
	@JsonProperty("text")
	private String name;
	
	/** 父菜单**/
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},optional=true)
	@JoinColumn(name="parentId")
	@JsonIgnore
	private Menu parent;
	@Enumerated(EnumType.STRING)
	@JsonIgnore
	private BackstageModule module;
	/** 子菜单 **/
	@OneToMany(cascade=CascadeType.ALL,mappedBy="parent")
	@JsonIgnore
	private Set<Menu> children;
	
	/** 资源 **/
//	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER,mappedBy="menus")
//	@JsonIgnore
//	private Set<Resources> resources; 
	private String icon;
	private String iconCls;
	private String controller;
	@Column(name="viewName")
	private String view;
	@Transient
	private boolean leaf = false;
	@Transient
	private boolean expanded = false;
	@Transient
	private boolean loaded = false;
	public Menu() {}
	public Menu(String name) {
		this.name = name;
	}
	
	/******  getter and setter  *******/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Menu getParent() {
		return parent;
	}
	public void setParent(Menu parent) {
		this.parent = parent;
	}
	public Set<Menu> getChildren() {
		return children;
	}
	public void setChildren(Set<Menu> children) {
		this.children = children;
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
		if(children.size()<=0) {
			leaf = true;
		}
		return leaf;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean isLoaded() {
		if(children.size()<=0) {
			loaded = true;
		}
		return loaded;
	}
	public BackstageModule getModule() {
		return module;
	}
	public void setModule(BackstageModule module) {
		this.module = module;
	}
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	
}
