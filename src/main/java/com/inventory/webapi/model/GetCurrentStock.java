package com.inventory.webapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetCurrentStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;
	 
	@Column(name = "item_name")
	private String itemName;  
	
	@Column(name = "opening_stock")
	private int openingStock;

	@Column(name = "total_purchase")
	private int totalPurchase;
	
	@Column(name = "total_sale")
	private int totalSale;

	@Column(name = "total_grn")
	private int totalGrn;
	
	@Column(name = "closing_stock")
	private int closingStock;
	 
	@Column(name = "last_purchase_rate")
	private float lastPurchaseRate;

	@Column(name = "last_wholesale_rate")
	private float lastWholesaleRate;
	
	@Column(name = "last_retail_rate")
	private float lastRetailRate;

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

	public int getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(int openingStock) {
		this.openingStock = openingStock;
	}

	public int getTotalPurchase() {
		return totalPurchase;
	}

	public void setTotalPurchase(int totalPurchase) {
		this.totalPurchase = totalPurchase;
	}

	public int getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(int totalSale) {
		this.totalSale = totalSale;
	}

	public int getTotalGrn() {
		return totalGrn;
	}

	public void setTotalGrn(int totalGrn) {
		this.totalGrn = totalGrn;
	}

	public int getClosingStock() {
		return closingStock;
	}

	public void setClosingStock(int closingStock) {
		this.closingStock = closingStock;
	}

	public float getLastPurchaseRate() {
		return lastPurchaseRate;
	}

	public void setLastPurchaseRate(float lastPurchaseRate) {
		this.lastPurchaseRate = lastPurchaseRate;
	}

	public float getLastWholesaleRate() {
		return lastWholesaleRate;
	}

	public void setLastWholesaleRate(float lastWholesaleRate) {
		this.lastWholesaleRate = lastWholesaleRate;
	}

	public float getLastRetailRate() {
		return lastRetailRate;
	}

	public void setLastRetailRate(float lastRetailRate) {
		this.lastRetailRate = lastRetailRate;
	}

	@Override
	public String toString() {
		return "GetCurrentStock [itemId=" + itemId + ", itemName=" + itemName + ", openingStock=" + openingStock
				+ ", totalPurchase=" + totalPurchase + ", totalSale=" + totalSale + ", totalGrn=" + totalGrn
				+ ", closingStock=" + closingStock + ", lastPurchaseRate=" + lastPurchaseRate + ", lastWholesaleRate="
				+ lastWholesaleRate + ", lastRetailRate=" + lastRetailRate + "]";
	} 
	 
	
	

}
