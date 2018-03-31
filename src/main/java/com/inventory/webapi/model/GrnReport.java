package com.inventory.webapi.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GrnReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grn_detail_id")
	private int grnDetailId;   

	@Column(name = "item_id")
	private int itemId;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "hsn_code")
	private String hsnCode;  
	
	@Column(name = "qty")
	private int qty;
	
	@Column(name = "total")
	private float total;

	public int getGrnDetailId() {
		return grnDetailId;
	}

	public void setGrnDetailId(int grnDetailId) {
		this.grnDetailId = grnDetailId;
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

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "GrnReport [grnDetailId=" + grnDetailId + ", itemId=" + itemId + ", itemName=" + itemName + ", hsnCode="
				+ hsnCode + ", qty=" + qty + ", total=" + total + "]";
	}
	
	

}
