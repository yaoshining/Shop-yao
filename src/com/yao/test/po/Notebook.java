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
	private int size;
	
	@Column(nullable=true)
	/** 颜色**/
	private String colour;

	@Column(nullable=true)
	@Temporal(TemporalType.TIMESTAMP)
	/** 上市时间**/
	private Date time_to_market;
		
	@Column(nullable=true)
	/**价格**/
	private double price;
	
	/**操作系统**/
	@Column(nullable=true)
	@Enumerated(EnumType.STRING)
	private OperatingSystem operating_system;

	
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

	public Date getTime_to_market() {
		return time_to_market;
	}

	public void setTime_to_market(Date time_to_market) {
		this.time_to_market = time_to_market;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OperatingSystem getOperating_system() {
		return operating_system;
	}

	public void setOperating_system(OperatingSystem operating_system) {
		this.operating_system = operating_system;
	}
	
}
