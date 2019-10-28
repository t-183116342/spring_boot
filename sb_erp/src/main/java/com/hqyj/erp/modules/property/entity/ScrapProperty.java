package com.hqyj.erp.modules.property.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 报废资产
 * 
 * @author: HymanHu
 * @date: 2019年10月27日
 */
@Entity
@Table(name = "scrap_property")
public class ScrapProperty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int scrapPropertyId;
	private String propertyName;
	private String model;
	private String bigtypeName;
	private String malltypeName;
	private int propertyNum;
	private double price;
	private double totalPrice;

	public int getScrapPropertyId() {
		return scrapPropertyId;
	}

	public void setScrapPropertyId(int scrapPropertyId) {
		this.scrapPropertyId = scrapPropertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBigtypeName() {
		return bigtypeName;
	}

	public void setBigtypeName(String bigtypeName) {
		this.bigtypeName = bigtypeName;
	}

	public String getMalltypeName() {
		return malltypeName;
	}

	public void setMalltypeName(String malltypeName) {
		this.malltypeName = malltypeName;
	}

	public int getPropertyNum() {
		return propertyNum;
	}

	public void setPropertyNum(int propertyNum) {
		this.propertyNum = propertyNum;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
