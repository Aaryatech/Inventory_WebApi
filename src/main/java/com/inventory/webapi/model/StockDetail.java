package com.inventory.webapi.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_stock_detail")
public class StockDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stock_detail_id")
	private int stockDetailId; 
	
	@Column(name = "stock_id")
	private int stockId;

	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_name")
	private String itemName;  

	@Column(name = "total_purchase")
	private int totalPurchase;
	
	@Column(name = "total_sale")
	private int totalSale;

	@Column(name = "grn")
	private int grn;
	
	@Column(name = "closing_stock")
	private int closingStock; 
	
	@Column(name = "last_purchase_rate")
	private float lastPurchaseRate;

	@Column(name = "last_wholesale_rate")
	private float lastWholesaleRate;
	
	@Column(name = "last_retail_rate")
	private float lastRetailRate; 
	
	@Column(name = "total")
	private float total;
	
	@Column(name = "opening_stock")
	private int openingStock;

	public int getStockDetailId() {
		return stockDetailId;
	}

	public void setStockDetailId(int stockDetailId) {
		this.stockDetailId = stockDetailId;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

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

	public int getGrn() {
		return grn;
	}

	public void setGrn(int grn) {
		this.grn = grn;
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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	

	public int getOpeningStock() {
		return openingStock;
	}

	public void setOpeningStock(int openingStock) {
		this.openingStock = openingStock;
	}

	@Override
	public String toString() {
		return "StockDetail [stockDetailId=" + stockDetailId + ", stockId=" + stockId + ", itemId=" + itemId
				+ ", itemName=" + itemName + ", totalPurchase=" + totalPurchase + ", totalSale=" + totalSale + ", grn="
				+ grn + ", closingStock=" + closingStock + ", lastPurchaseRate=" + lastPurchaseRate
				+ ", lastWholesaleRate=" + lastWholesaleRate + ", lastRetailRate=" + lastRetailRate + ", total=" + total
				+ ", openingStock=" + openingStock + "]";
	}
	
	

}
