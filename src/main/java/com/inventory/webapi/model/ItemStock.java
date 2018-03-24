package com.inventory.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;  

	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "wholesale_rate")
	private float wholesaleRate; 
	
	@Column(name = "retail_rate")
	private float retailRate;

	@Column(name = "rate_with_tax")
	private float rateWithTax;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getWholesaleRate() {
		return wholesaleRate;
	}

	public void setWholesaleRate(float wholesaleRate) {
		this.wholesaleRate = wholesaleRate;
	}

	public float getRetailRate() {
		return retailRate;
	}

	public void setRetailRate(float retailRate) {
		this.retailRate = retailRate;
	}

	public float getRateWithTax() {
		return rateWithTax;
	}

	public void setRateWithTax(float rateWithTax) {
		this.rateWithTax = rateWithTax;
	}

	@Override
	public String toString() {
		return "ItemStock [itemId=" + itemId + ", itemName=" + itemName + ", wholesaleRate=" + wholesaleRate
				+ ", retailRate=" + retailRate + ", rateWithTax=" + rateWithTax + "]";
	}
	 
	
	

}
