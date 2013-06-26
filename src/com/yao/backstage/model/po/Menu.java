package com.yao.backstage.model.po;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

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
	@JsonIgnore
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
	@OneToMany(cascade=CascadeType.ALL,mappedBy="parent") 
	
	/** 子菜单 **/
	private Set<Menu> children;
	
	/** 资源 **/
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER,mappedBy="menus")
	@JsonIgnore
	private Set<Resources> resources; 
	private String icon;
	private String iconCls;
	@Transient
	private boolean leaf = false;
	@Transient
	private boolean expanded = false;
	public Menu() {}
	public Menu(String name) {
		this.name = name;
	}
	
	/******  getter and setter  *******/
	public Set<Resources> getResources() {
		return resources;
	}
	public void setResources(Set<Resources> resources) {
		this.resources = resources;
	}
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
		return leaf;
	}
	public boolean isExpanded() {
		return expanded;
	}
	
}
