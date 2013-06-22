package com.yao.test.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Notebook implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 主键**/
	@Id   //主键不能写column了
	@GeneratedValue
	private int id; 
	
	/** 品牌**/
	@Column(nullable=true)
	private String brand;

	/** 尺寸**/
	@Column(nullable=true)
	private int size;
	
	@Column(nullable=true)
	/** 颜色**/
	private String colour;

	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	/** 上市时间**/
	private Date timeToMarket;
		
	@Column(nullable=true)
	/**价格**/
	private double price;
	
	/**操作系统**/
	@Column(nullable=true)
	@Enumerated(EnumType.STRING)
	private OperatingSystem operatingSystem;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getTimeToMarket() {
		return timeToMarket;
	}

	public void setTimeToMarket(Date timeToMarket) {
		this.timeToMarket = timeToMarket;
	}

	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(OperatingSystem operatingSystem) {
		this.operatingSystem = operatingSystem;
	}


	
}
